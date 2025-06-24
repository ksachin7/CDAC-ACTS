package com.telicom.ticket_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telicom.ticket_management.entity.Ticket;
import com.telicom.ticket_management.enums.Status;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

	List<Ticket> findAllByStatus(Status status);

}
