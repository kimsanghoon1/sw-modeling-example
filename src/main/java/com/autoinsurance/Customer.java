/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: uengine
 * License Type: Purchased
 */
package com.autoinsurance;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Customer")
public class Customer implements Serializable {
	public Customer() {
	}
	
	@Column(name="Id", nullable=false, length=19)	
	@Id	
	@GeneratedValue(generator="COM_AUTOINSURANCE_CUSTOMER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_AUTOINSURANCE_CUSTOMER_ID_GENERATOR", strategy="native")	
	private Long id;
	
	@Column(name="FirstName", nullable=true, length=255)	
	private String firstName;
	
	@OneToMany(mappedBy="customer", targetEntity=com.autoinsurance.Vehicle.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set vehicles = new java.util.HashSet();
	
	public void setFirstName(String value) {
		this.firstName = value;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	private void setId(long value) {
		setId(new Long(value));
	}
	
	private void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getORMID() {
		return getId();
	}
	
	public void setVehicles(java.util.Set value) {
		this.vehicles = value;
	}
	
	public java.util.Set getVehicles() {
		return vehicles;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
