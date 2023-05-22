package in.ineuron.model;

import java.util.Arrays;

public class Product {
	private Integer pid;
	private String pname;
	private Double price;
	private String[] types;

	public Integer getPid() {
		System.out.println("Product.getPid()");
		return pid;
	}

	public void setPid(Integer pid) {
		System.out.println("Product.setPid()");
		this.pid = pid;
	}

	public String getPname() {
		System.out.println("Product.getPname()");
		return pname;
	}

	public void setPname(String pname) {
		System.out.println("Product.setPname()");
		this.pname = pname;
	}

	public Double getPrice() {
		System.out.println("Product.getPrice()");
		return price;
	}

	public void setPrice(Double price) {
		System.out.println("Product.setPrice()");
		this.price = price;
	}

	public String[] getTypes() {
		System.out.println("Product.getTypes()");
		return types;
	}

	public void setTypes(String[] types) {
		System.out.println("Product.setTypes()");
		this.types = types;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", types=" + Arrays.toString(types)
				+ "]";
	}
}