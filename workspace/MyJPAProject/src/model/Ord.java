package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ORD database table.
 * 
 */
@Entity
@NamedQuery(name="Ord.findAll", query="SELECT o FROM Ord o")
public class Ord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long ordid;

	private String commplan;

	@Temporal(TemporalType.DATE)
	private Date orderdate;

	@Temporal(TemporalType.DATE)
	private Date shipdate;

	private BigDecimal total;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="ord")
	private List<Item> items;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTID")
	private Customer customer;

	public Ord() {
	}

	public long getOrdid() {
		return this.ordid;
	}

	public void setOrdid(long ordid) {
		this.ordid = ordid;
	}

	public String getCommplan() {
		return this.commplan;
	}

	public void setCommplan(String commplan) {
		this.commplan = commplan;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getShipdate() {
		return this.shipdate;
	}

	public void setShipdate(Date shipdate) {
		this.shipdate = shipdate;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setOrd(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setOrd(null);

		return item;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}