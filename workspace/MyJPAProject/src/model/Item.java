package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPK id;

	private BigDecimal actualprice;

	private BigDecimal itemtot;

	private BigDecimal prodid;

	private BigDecimal qty;

	//bi-directional many-to-one association to Ord
	@ManyToOne
	@JoinColumn(name="ORDID")
	private Ord ord;

	public Item() {
	}

	public ItemPK getId() {
		return this.id;
	}

	public void setId(ItemPK id) {
		this.id = id;
	}

	public BigDecimal getActualprice() {
		return this.actualprice;
	}

	public void setActualprice(BigDecimal actualprice) {
		this.actualprice = actualprice;
	}

	public BigDecimal getItemtot() {
		return this.itemtot;
	}

	public void setItemtot(BigDecimal itemtot) {
		this.itemtot = itemtot;
	}

	public BigDecimal getProdid() {
		return this.prodid;
	}

	public void setProdid(BigDecimal prodid) {
		this.prodid = prodid;
	}

	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public Ord getOrd() {
		return this.ord;
	}

	public void setOrd(Ord ord) {
		this.ord = ord;
	}

}