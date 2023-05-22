package in.ineuron.model;

// Dependent object of Customer
public class Address {

	private String street;
	private String city;
	private String state;

	static {
		System.out.println("Address class loading...............");
	}

	public Address() {
		System.out.println("Address object instantiated");
	}

	public void setStreet(String street) {
		System.out.println("Address.setStreet()");
		this.street = street;
	}

	public void setCity(String city) {
		System.out.println("Address.setCity()");
		this.city = city;
	}

	public void setState(String state) {
		System.out.println("Address.setState()");
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + "]";
	}

}
