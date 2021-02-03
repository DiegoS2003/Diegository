import java.util.ArrayList;
import java.io.Serializable;
public class Database extends ArrayList<Customer> implements Serializable {
	public Database() {
		super();
	}

	public String toCsv() {
		String temp = "";
		for (int i = 0; i < this.size(); i++) {
			temp += this.get(i).toCsvLine() + "\n";
		}
		return temp;
	}
}
