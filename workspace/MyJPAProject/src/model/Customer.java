package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long custid;

	private String address;

	private BigDecimal area;

	private String city;

	private Object comments;

	private BigDecimal creditlimit;

	private String name;

	private String phone;

	private BigDecimal repid;

	@Column(name="\"STATE\"")
	private String state;

	private String zip;

	//bi-directional many-to-one association to Ord
	@OneToMany(mappedBy="customer")
	private List<Ord> ords;

	public Customer() {
	}

	public long getCustid() {
		return this.custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Object getComments() {
		return this.comments;
	}

	public void setComments(Object comments) {
		this.comments = comments;
	}

	public BigDecimal getCreditlimit() {
		return this.creditlimit;
	}

	public void setCreditlimit(BigDecimal creditlimit) {
		this.creditlimit = creditlimit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getRepid() {
		return this.repid;
	}

	public void setRepid(BigDecimal repid) {
		this.repid = repid;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<Ord> getOrds() {
		return this.ords;
	}

	public void setOrds(List<Ord> ords) {
		this.ords = ords;
	}

	public Ord addOrd(Ord ord) {
		getOrds().add(ord);
		ord.setCustomer(this);

		return ord;
	}

	public Ord removeOrd(Ord ord) {
		getOrds().remove(ord);
		ord.setCustomer(null);

		return ord;
	}

}