package eclipse_workspace.day6.emp;

public class Address {
	private String country;
	private int pincode;
	private  String city;
	private String state;
	

	public String toString() {
		return "Address [country=" + country + ", pincode=" + pincode + ", city=" + city + ", state=" + state + "]";
	}


	public Address(String country, int pincode, String city, String state) {
		this.country = country;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
	}
	
	

}
