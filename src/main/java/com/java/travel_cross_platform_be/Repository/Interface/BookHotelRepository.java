package com.java.travel_cross_platform_be.Repository.Interface;

import com.java.travel_cross_platform_be.Model.Entity.BookHotel;
import com.java.travel_cross_platform_be.Model.Entity.BookTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookHotelRepository extends JpaRepository<BookHotel, Long> {
}
