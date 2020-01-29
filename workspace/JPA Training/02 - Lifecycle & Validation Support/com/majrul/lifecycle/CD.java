package com.majrul.lifecycle;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "CD2")
public class CD {

	@Id
	@GeneratedValue
	private int id;

	private String title;
	private String artist;

	@Column(name="purchase_date")
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;

	private double cost;

	public CD() {
	}

	public CD(String title, String artist, Date purchaseDate, double cost) {
		this.title = title;
		this.artist = artist;
		this.purchaseDate = purchaseDate;
		this.cost = cost;
	}

	@PrePersist
	public void beforeInsert() {
		System.out.println("@PrePersist");
	}
	
	@PostPersist
	public void afterInsert() {
		System.out.println("@PostPersist");
	}

	@PreUpdate
	public void beforeUpdate() {
		System.out.println("@PreUpdate");
	}
	
	@PostUpdate
	public void afterUpdate() {
		System.out.println("@PostUpdate");
	}
	@PreRemove
	public void beforeDelete() {
		System.out.println("@PreRemove");
	}
	
	@PostRemove
	public void afterDelete() {
		System.out.println("@PostRemove");
	}
	
	@PostLoad
	public void afterSelect() {
		System.out.println("@PostLoad");
	}
		
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", title=" + title + ", artist=" + artist
				+ ", purchaseDate=" + purchaseDate + ", cost=" + cost + "]";
	}
}
