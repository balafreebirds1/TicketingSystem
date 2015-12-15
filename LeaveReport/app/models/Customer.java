package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Customer extends Model {
	
	String customerName;
	
	

	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	@Override
	public String toString() {
		return customerName ;
	}
	
	

}
