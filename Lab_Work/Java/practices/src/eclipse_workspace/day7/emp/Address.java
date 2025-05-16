package eclipse_workspace.day7.emp;

public class Address {
	private String street;
	private String city;
	private String state;
	private String country;
	private int pincode;

	public Address(String street, String city, String state, String country, int pincode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country= country;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address{" +
				"street='" + street + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				", pincode=" + pincode +
				'}';
	}
}
