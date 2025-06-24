package com.telicom.ticket_management.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.telicom.ticket_management.dto.TicketUpdateDTO;
import com.telicom.ticket_management.entity.Ticket;
import com.telicom.ticket_management.enums.Status;
import com.telicom.ticket_management.exception.TicketNotFoundException;
import com.telicom.ticket_management.repository.TicketRepository;

@Service
public class TicketService {
	private final TicketRepository tktRepository;
	
	public TicketService(TicketRepository tktRepository) {
		this.tktRepository=tktRepository;
	}
	
	public Ticket createTicket(Ticket tkt) {
		tkt.setStatus(Status.OPEN);
		tkt.setCreateDateTime(LocalDateTime.now());
		return tktRepository.save(tkt);
	}
	
	public Ticket updateTicket(Long id, TicketUpdateDTO tktDTO) {
		Ticket tkt=tktRepository.findById(id).orElseThrow(()-> new TicketNotFoundException(id));
		
	    if (tktDTO.getStatus() == Status.RESOLVED) {
	        if (tktDTO.getResolutionDetails() == null || tktDTO.getResolutionDetails().isBlank()) {
	            throw new IllegalArgumentException("Resolution details must be provided when status is RESOLVED.");
	        }
	        if (tktDTO.getResolutionDateTime() == null) {
	        	tktDTO.setResolutionDateTime(LocalDateTime.now()); // auto-fill if allowed
	        }
	    }

		tkt.setStatus(tktDTO.getStatus());
		tkt.setResolutionDetails(tktDTO.getResolutionDetails());
		tkt.setResolutionDateTime(tktDTO.getResolutionDateTime());
		
		return tktRepository.save(tkt);
	}
	
	public void deleteTicket(Long id) {
		if(!tktRepository.existsById(id))
			throw new TicketNotFoundException(id);
		tktRepository.deleteById(id);
	}
	
	public Ticket getTicketById(Long id) {
		return tktRepository.findById(id).orElseThrow(()->new TicketNotFoundException(id));
	}
	
	public List<Ticket> getOpenTickets(){
		return tktRepository.findAllByStatus(Status.OPEN);
	}
}
