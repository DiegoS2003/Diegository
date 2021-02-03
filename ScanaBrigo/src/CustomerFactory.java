
public class CustomerFactory {
	public CustomerFactory() {

	}

	public Customer fromCsvLine(String line) {
		// String type, int d, int m, int y, String fullName
		String[] el = line.split(",");
		Date d = new Date(Integer.parseInt(el[1]), Integer.parseInt(el[2]), Integer.parseInt(el[3]));
		if (el[0].equals("Customer")) {
			return new Customer(d, el[4]);
		}

		return new BusinessCustomer(d, el[4]);

	}

}
