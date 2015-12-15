package controllers;

import java.util.ArrayList;
import java.util.List;

import dto.TicketDTO;
import models.LogTicket;
import play.mvc.Controller;

public class Tickets extends Controller{
	
	public static void index(){
		int moduleId=1;
		 try{
		 moduleId = Integer.parseInt( params.get("id"));
		 }catch(Exception e){
			 
		 }

		 
		
		 
		render(moduleId);
	}
	
	
	public static void loadDetails(){
		
		System.out.println("Testing details");
		List<LogTicket> listLogs = LogTicket.findAll();
		 
		 List<TicketDTO> dtoList = new ArrayList<TicketDTO>();
		 
		 for(LogTicket ticket : listLogs){
			 
			 TicketDTO dto = new TicketDTO();
			 
			 dto.setId(ticket.getId());
			 
			 dto.setCustomer(ticket.getCustomer().getCustomerName());
			 
			 dto.setAssigned(ticket.getAssignedTo().fullname);
			 
			 dto.setStatus(ticket.getTicketStatus().getStatus());
			 
			 dto.setTitle(ticket.getTitle());
			 
			 dtoList.add(dto);
			 
			 
		 }
		 
		 
		 
			renderJSON( dtoList);
	}
	
	

}
