package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class LogTicket extends Model{
	
	@ManyToOne
	Customer customer;   

	@ManyToOne
	StatusTicket ticketStatus;
   
	@ManyToOne
	User assignedTo;	
	
	@ManyToOne
	User createdBy;
	
	String title;
	
	String comment;

	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public StatusTicket getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(StatusTicket ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
   

}
