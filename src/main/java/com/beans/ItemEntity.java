package com.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ItemEntity implements Serializable{

	private static final long serialVersionUID = 5585503187390864060L;
	private Integer id;
	private Integer typeId;
	private String type;
	private String category;
	private Double price;
	private String description;
	private String image;
	private Boolean newItem;
	private Boolean usedItem;
	private String sellerName;
	private Boolean itemSold;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getNewItem() {
		return newItem;
	}
	public void setNewItem(Boolean newItem) {
		this.newItem = newItem;
	}
	public Boolean getUsedItem() {
		return usedItem;
	}
	public void setUsedItem(Boolean usedItem) {
		this.usedItem = usedItem;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Boolean getItemSold() {
		return itemSold;
	}
	public void setItemSold(Boolean itemSold) {
		this.itemSold = itemSold;
	}

	
	
}
