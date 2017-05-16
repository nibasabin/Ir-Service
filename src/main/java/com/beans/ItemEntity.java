package com.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class ItemEntity implements Serializable{

	private static final long serialVersionUID = 5585503187390864060L;
	private String description;
	private String type;
	private Integer price;
	private String image;
	
	public ItemEntity(){
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}


}
