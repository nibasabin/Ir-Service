package com.endpoint.manager;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ItemObject2 implements Serializable {

	private static final long serialVersionUID = 3219436977433972296L;
	private int itemNo;
	private int itemId;
	private  String itemName;
	private  String itemDescription;
	private  int itemQuantity;
	private  int itemUnitPrice;

	@Override
	public String toString() {
		return "ItemObject [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", itemQuantity=" + itemQuantity + ", itemUnitPrice=" + itemUnitPrice + "]";
	}
	public ItemObject2()
	{
		this.itemNo=0;
		this.itemId=0;
		this.itemName="itemName";
		this.itemDescription="itemDescription";
		this.itemQuantity=0;
		this.itemUnitPrice=0;
	}
	public ItemObject2(int itemId,String itemName,String itemDescription, int itemQuantity,int itemUnitPrice)
	{
		this.itemId=itemId;
		this.itemName=itemName;
		this.itemDescription=itemDescription;
		this.itemQuantity=itemQuantity;
		this.itemUnitPrice=itemUnitPrice;
	}

	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity2) {
		this.itemQuantity = itemQuantity2;
	}

	public int getItemUnitPrice() {
		return itemUnitPrice;
	}

	public void setItemUnitPrice(int itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}
}
