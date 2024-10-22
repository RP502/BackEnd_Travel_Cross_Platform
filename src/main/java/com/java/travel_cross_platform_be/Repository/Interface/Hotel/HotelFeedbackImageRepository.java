package com.java.travel_cross_platform_be.Repository.Interface.Hotel;

import com.java.travel_cross_platform_be.Model.Entity.Hotel.Hotel;
import com.java.travel_cross_platform_be.Model.Entity.Hotel.HotelFeedbackImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelFeedbackImageRepository extends JpaRepository<HotelFeedbackImage, Long> {
}
