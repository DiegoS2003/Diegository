
public class DateFactory {
	public DateFactory() {

	}

	public Date fromString(String ddmmyyyy) throws NumberFormatException, ArrayIndexOutOfBoundsException {
		String[] a = ddmmyyyy.split("/");
		return new Date(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));

	}
}
