package eclipse_workspace.day7.person;

public class Address {
    private String street;
    private String city;
    private String state;
    private int pincode;

    public Address(String street, String city, String state, int pincode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " - " + pincode;
    }
}
