package org.springmvc.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Address.check", query = "from Address where street=? and city=? and country =? and pincode =?")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String street;
	private String city;
	private String country;
	private String pincode;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public boolean equals(Object obj){
		
		Address add = (Address) obj;
		if(this.street.equalsIgnoreCase(add.street)&&this.city.equalsIgnoreCase(add.city)&&
				this.country.equalsIgnoreCase(add.country)&&this.pincode.equalsIgnoreCase(add.pincode))
		return true;
		
		return false;
	}
}
