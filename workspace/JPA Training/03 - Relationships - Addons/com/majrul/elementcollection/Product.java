package com.majrul.elementcollection;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PRODUCT")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int id;
	
	@Column(length=20)
	private String name;
	private double price;
	
	@Lob
	@Basic(fetch = FetchType.LAZY) //need to run InstrumentTask(build.xml) to make this work
	private byte[] image;

	//Collection of Value types
	@ElementCollection
	@CollectionTable(name = "TBL_PRODUCT_TAGS")
	@Column(length=15)
	private Set<String> tags;

	public Set<String> getTags() {
		return tags;
	}
	
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
