import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date extends GregorianCalendar implements Serializable {
	public Date(int d, int m, int y) {
		super(y, m, d);
	}

	@Override
	public String toString() {
		return getProp(Calendar.DATE) + "/" + getProp(Calendar.MONTH) + "/" + getProp(Calendar.YEAR);
	}

	public String toCsvLine() {
		return getProp(Calendar.DATE) + "," + getProp(Calendar.MONTH) + "," + getProp(Calendar.YEAR);
	}

	private String getProp(int type) {
		return String.valueOf(super.get(type));
	}
}
