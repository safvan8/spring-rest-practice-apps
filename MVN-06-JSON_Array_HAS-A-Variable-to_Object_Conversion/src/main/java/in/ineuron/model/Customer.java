package in.ineuron.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Target Object
public class Customer {

	private Integer id;
	private String customerName;

	// HAS A varible
	private Address address;
	// array
	private String[] languages;

	static {
		System.out.println("Customer class loading...............");
	}

	public Customer() {
		System.out.println("Customer object instantiated");
	}

	public void setId(Integer id) {
		System.out.println("Customer.setId()");
		this.id = id;
	}

	public void setCustomerName(String customerName) {
		System.out.println("Customer.setCustomerName()");
		this.customerName = customerName;
	}

	public void setAddress(Address address) {
		System.out.println("Customer.setAddress()");
		this.address = address;
	}

	public void setLanguages(String[] languages) {
		System.out.println("Customer.setLanguages()");
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", address=" + address + ", languages="
				+ Arrays.toString(languages) + "]";
	}
}
