import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {
	private JMenuBar bar;
	private JMenu file, load, save;
	private JMenuItem loadObj, saveObj, loadTxt, saveTxt, viewTable, add;
	private JLabel nameLabel, birthDateLabel, premiumLabel;
	private JTextField name, birthDate;
	private JComboBox premium;
	private Database d;

	private void initComponents() {
		loadObj = new JMenuItem("Object file");
		saveObj = new JMenuItem("Object file");
		loadTxt = new JMenuItem("Text file");
		saveTxt = new JMenuItem("Text file");

		load = new JMenu("Load");
		save = new JMenu("Save");

		file = new JMenu("File");

		load.add(loadObj);
		load.add(loadTxt);

		save.add(saveObj);
		save.add(saveTxt);

		file.add(load);
		file.add(save);

		viewTable = new JMenuItem("View Table");
		add = new JMenuItem("Add");

		bar = new JMenuBar();

		bar.add(file);
		bar.add(viewTable);
		bar.add(add);

		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		String[] choices = { "Yes, I want ScanaBrigo premium with full access", "No, I am gay" };
		premium = new JComboBox(choices);

		nameLabel = new JLabel("Name");
		birthDateLabel = new JLabel("Birth date");
		premiumLabel = new JLabel("Do you want pemium?");

		name = new JTextField(15);
		birthDate = new JTextField(15);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;

		this.add(bar, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;

		this.add(nameLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;

		this.add(name, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;

		this.add(birthDateLabel, c);

		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;

		this.add(birthDate, c);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;

		this.add(premiumLabel, c);

		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;

		this.add(premium, c);

		viewTable.addActionListener(this);
		add.addActionListener(this);
		saveObj.addActionListener(this);
		saveTxt.addActionListener(this);
		loadObj.addActionListener(this);
		loadTxt.addActionListener(this);
	}

	public Window() {
		initComponents();
		d = new Database();
	}

	public static void main(String[] args) {
		Window w = new Window();
		w.setSize(600, 800);
		w.setTitle("ScanaBrigo interesting video platform");
		w.setVisible(true);
	}

	private void tableDisplay() {
		TableDialog td = new TableDialog(this, true, d);
		td.setSize(800, 600);
		td.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(viewTable)) {
			tableDisplay();
		} else if (e.getSource().equals(add)) {
			try {
				DateFactory df = new DateFactory();
				Date date = df.fromString(birthDate.getText());
				Customer c = null;
				switch (premium.getSelectedIndex()) {
				case 0:
					c = new BusinessCustomer(date, name.getText());
					break;
				case 1:
					c = new Customer(date, name.getText());
					break;
				}
				d.add(c);
				tableDisplay();

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(this, "Something went Wrong", "ScanaBrigo", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}

		} else if (e.getSource().equals(loadObj)) {
			String path = JOptionPane.showInputDialog("Filename");
			FileHandler fh = new FileHandler();
			try {
				d = fh.load(path, FileHandler.saveMethod.OBJECT);
				JOptionPane.showMessageDialog(this, "Operation successful", "ScanaBrigo", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "Something went Wrong", "ScanaBrigo", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(loadTxt)) {
			String path = JOptionPane.showInputDialog("Filename");
			FileHandler fh = new FileHandler();
			try {
				d = fh.load(path, FileHandler.saveMethod.TEXT);
				JOptionPane.showMessageDialog(this, "Operation successful", "ScanaBrigo", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "Something went Wrong", "ScanaBrigo", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
		else if (e.getSource().equals(saveObj)) {
			String path = JOptionPane.showInputDialog("Filename");
			FileHandler fh = new FileHandler();
			try {
				fh.save(path, FileHandler.saveMethod.OBJECT,d);
				JOptionPane.showMessageDialog(this, "Operation successful", "ScanaBrigo", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "Something went Wrong", "ScanaBrigo", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
		else if (e.getSource().equals(saveTxt)) {
			String path = JOptionPane.showInputDialog("Filename");
			FileHandler fh = new FileHandler();
			try {
				fh.save(path, FileHandler.saveMethod.TEXT,d);
				JOptionPane.showMessageDialog(this, "Operation successful", "ScanaBrigo", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "Something went Wrong", "ScanaBrigo", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
	}

}
