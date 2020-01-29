package ex01.xml;

import java.util.Date;

public class CD {

	private int id;
	private String title;
	private String artist;
	private Date purchaseDate;
	private double cost;
	
	public CD(String title, String artist, Date purchaseDate, double cost) {
		this.title = title;
		this.artist = artist;
		this.purchaseDate = purchaseDate;
		this.cost = cost;
	}
	public CD() {
	}
	
	public String getArtist() {
		System.out.println("getArtist()");
		return artist;
	}
	public void setArtist(String artist) {
		System.out.println("setArtist()");
		this.artist = artist;
	}
	public double getCost() {
		System.out.println("getCost()");
		return cost;
	}
	public void setCost(double cost) {
		System.out.println("setCost()");
		this.cost = cost;
	}
	public int getId() {
		System.out.println("getId()");
		return id;
	}
	public void setId(int id) {
		System.out.println("setId()");
		this.id = id;
	}
	public Date getPurchaseDate() {
		System.out.println("getPurchaseDate()");
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		System.out.println("setPurchaseDate()");
		this.purchaseDate = purchaseDate;
	}
	public String getTitle() {
		System.out.println("getTitle()");
		return title;
	}
	public void setTitle(String title) {
		System.out.println("setTitle()");
		this.title = title;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", title=" + title + ", artist=" + artist
				+ ", cost=" + cost + ", purchaseDate=" + purchaseDate + "]";
	}
}
