package com.java.travel_cross_platform_be.Repository.Interface.Ticket;

import com.java.travel_cross_platform_be.Model.Entity.Ticket.Ticket;
import com.java.travel_cross_platform_be.Model.Entity.Ticket.TicketSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketScheduleRepository extends JpaRepository<TicketSchedule, Long> {
}
