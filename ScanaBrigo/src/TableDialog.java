import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableDialog extends JDialog implements ActionListener {
	private JTable jt;
	private DefaultTableModel dft;
	private JScrollPane sp;
	private JButton jb;
	private Database d;

	private void initComponents() {
		Object[][] data = {};
		String[] columnNames = { "#", "Full Name", "Birth Date","Premium" };
		dft = new DefaultTableModel(data, columnNames);
		jt = new JTable(dft);
		sp = new JScrollPane(jt);
		jb = new JButton("Delete");
		this.setLayout(new GridLayout(1, 2));
		this.add(sp);
		this.add(jb);
		update();
		jb.addActionListener(this);
	}

	private void update() {
		dft.setRowCount(0);
		for (int i = 0; i < d.size(); i++) {
			String premium="N";
			if(d.get(i) instanceof BusinessCustomer) {
				premium="Y";
			}
			Object[] row = { i + 1, d.get(i).getFullName(), d.get(i).getBirth().toString(), premium};
			dft.addRow(row);
		}
	}

	public TableDialog(JFrame f, boolean modal, Database d) {
		super(f, modal);
		this.d = d;
		initComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jb)) {
			try {
				int n = Integer.parseInt(JOptionPane.showInputDialog("Record ID:"));
				this.d.remove(n - 1);
				update();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Something went Wrong", "ScanaBrigo", JOptionPane.ERROR_MESSAGE);
				update();
				ex.printStackTrace();
			}
		}

	}

}