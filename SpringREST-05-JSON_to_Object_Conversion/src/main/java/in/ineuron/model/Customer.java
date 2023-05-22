package in.ineuron.model;

public class Customer {

	private Integer id;
	private String firstName;
	private String lastName;
	private Boolean active;

	static {
		System.out.println("class loading...............");
	}

	public Customer() {
		System.out.println("Customer.Customer()--zero arg contrsuctor");
	}

	public Integer getId() {
		System.out.println("Customer.getId()");
		return id;
	}

	public void setId(Integer id) {
		System.out.println("Customer.setId()");
		this.id = id;
	}

	public String getFirstName() {
		System.out.println("Customer.getFirstName()");
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("Customer.setFirstName()");
		this.firstName = firstName;
	}

	public String getLastName() {
		System.out.println("Customer.getLastName()");
		return lastName;
	}

	public void setLastName(String lastName) {
		System.out.println("Customer.setLastName()");
		this.lastName = lastName;
	}

	public Boolean getActive() {
		System.out.println("Customer.getActive()");
		return active;
	}

	public void setActive(Boolean active) {
		System.out.println("Customer.setActive()");
		this.active = active;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active
				+ "]";
	}

}
