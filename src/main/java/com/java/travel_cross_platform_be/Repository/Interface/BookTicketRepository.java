package com.java.travel_cross_platform_be.Repository.Interface;

import com.java.travel_cross_platform_be.Model.Entity.BookTicket;
import com.java.travel_cross_platform_be.Model.Entity.BookTour;
import com.java.travel_cross_platform_be.Model.Entity.Tour.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTicketRepository extends JpaRepository<BookTicket, Long> {
}
