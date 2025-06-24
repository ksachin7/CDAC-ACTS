package com.telicom.ticket_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telicom.ticket_management.dto.TicketUpdateDTO;
import com.telicom.ticket_management.entity.Ticket;
import com.telicom.ticket_management.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

//	No Need for @Autowired in Spring 4.3+: If a class has only one constructor, Spring injects it automatically.
	private final TicketService tktService;
	
	public TicketController(TicketService tktService) {
		this.tktService= tktService;
	}

	@PostMapping
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket tkt){
		return ResponseEntity.status(201).body(tktService.createTicket(tkt));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody TicketUpdateDTO tkt){
		return ResponseEntity.ok(tktService.updateTicket(id, tkt));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteTicket(@PathVariable Long id){
		tktService.deleteTicket(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable Long id){
		return ResponseEntity.ok(tktService.getTicketById(id));
	}
	
	@GetMapping("/open")
	public ResponseEntity<List<Ticket>> getOpenTickets(){
		return ResponseEntity.ok(tktService.getOpenTickets());
	}
}
