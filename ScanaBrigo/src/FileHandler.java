import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	public enum saveMethod {
		OBJECT, TEXT
	}

	public FileHandler() {

	}

	public Database load(String path, saveMethod method)
			throws ClassNotFoundException, FileNotFoundException, IOException {
		if (method.equals(saveMethod.OBJECT)) {
			return this.loadObject(path);
		} else {

			return this.loadText(path);
		}

	}

	public void save(String path, saveMethod method, Database d) throws FileNotFoundException, IOException {
		if (method.equals(saveMethod.OBJECT)) {
			this.saveObject(path, d);
		} else {
			this.saveText(path, d);
		}

	}

	private void saveObject(String path, Database d) throws FileNotFoundException, IOException {
		File f = new File(path);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d);
		oos.close();
	}

	private Database loadObject(String path) throws ClassNotFoundException, FileNotFoundException, IOException {
		File f = new File(path);
		FileInputStream fos = new FileInputStream(f);
		ObjectInputStream oos = new ObjectInputStream(fos);
		return (Database) oos.readObject();

	}

	private void saveText(String path, Database d) throws FileNotFoundException, IOException {
		File f = new File(path);
		FileWriter fw = new FileWriter(f);
		fw.write(d.toCsv());
		fw.close();
	}

	private Database loadText(String path) throws FileNotFoundException, IOException {
		Database d = new Database();
		CustomerFactory cf = new CustomerFactory();
		File f = new File(path);
		Scanner s = new Scanner(f);
		while (s.hasNextLine()) {
			d.add(cf.fromCsvLine(s.nextLine()));
		}
		s.close();
		return d;
	}

}
