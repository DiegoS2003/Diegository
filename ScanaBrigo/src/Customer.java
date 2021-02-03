import java.io.Serializable;

public class Customer implements Serializable {
	protected Date birth;
	protected String fullName;

	public Customer(Date birth, String fullName) {
		this.birth = birth;
		this.fullName = fullName;
	}

	public String toCsvLine() {
		return "Customer," + birth.toCsvLine() + "," + fullName;

	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
