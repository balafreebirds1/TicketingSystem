package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class StatusTicket extends Model {
	
	String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return status ;
	}
	
	
	

}
