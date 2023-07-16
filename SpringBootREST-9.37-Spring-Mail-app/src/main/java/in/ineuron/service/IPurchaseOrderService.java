package in.ineuron.service;



public interface IPurchaseOrderService {

	public String purchaseOrder(String[] items, double[] prices, String[] toEmails);
}
