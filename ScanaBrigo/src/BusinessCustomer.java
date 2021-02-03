import java.io.Serializable;

public class BusinessCustomer extends Customer implements Serializable {

	public BusinessCustomer(Date birth, String fullName) {
		super(birth, fullName);
	}

	@Override
	public String toCsvLine() {
		return "BusinessCustomer," + super.birth.toCsvLine() + "," + super.fullName;

	}
}
