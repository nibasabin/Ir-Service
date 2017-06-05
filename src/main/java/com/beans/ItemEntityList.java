package com.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ItemEntityList implements Serializable {

	private static final long serialVersionUID = 5763478037966261478L;
	@XmlAttribute
	private List<ItemEntity> itemEntityList;

	public List<ItemEntity> getItemEntityList() {
		return itemEntityList;
	}

	public void setItemEntityList(List<ItemEntity> itemEntityList) {
		this.itemEntityList = itemEntityList;
	}
	

}
