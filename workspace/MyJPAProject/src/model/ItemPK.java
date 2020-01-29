package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ITEM database table.
 * 
 */
@Embeddable
public class ItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long ordid;

	private long itemid;

	public ItemPK() {
	}
	public long getOrdid() {
		return this.ordid;
	}
	public void setOrdid(long ordid) {
		this.ordid = ordid;
	}
	public long getItemid() {
		return this.itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ItemPK)) {
			return false;
		}
		ItemPK castOther = (ItemPK)other;
		return 
			(this.ordid == castOther.ordid)
			&& (this.itemid == castOther.itemid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.ordid ^ (this.ordid >>> 32)));
		hash = hash * prime + ((int) (this.itemid ^ (this.itemid >>> 32)));
		
		return hash;
	}
}