package com.cdac.acts.Restaurents;
import com.cdac.acts.Restaurents.Customer;

public class Item {
	private int itemCode;
	private String itemName;
	private double price;
	private int qty;

	public Item() {}

	public Item(int itemCode, String itemName, double price, int qty) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Item{" +
				"itemCode=" + itemCode +
				", itemName='" + itemName + '\'' +
				", price=" + price +
				", qty=" + qty +
				'}';
	}

	public int getItemCode() {
		return itemCode;
	}


	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	private String arrayToString(Object array, int len) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for (int i = 0; i < len; i++) {
			if (i > 0) {
				buffer.append(", ");
			}
			if (array instanceof double[]) {
				buffer.append(((double[]) array)[i]);
			}
			if (array instanceof int[]) {
				buffer.append(((int[]) array)[i]);
			}
			if (array instanceof Object[]) {
				buffer.append(((Object[]) array)[i]);
			}
		}
		buffer.append("]");
		return buffer.toString();
	}

}
