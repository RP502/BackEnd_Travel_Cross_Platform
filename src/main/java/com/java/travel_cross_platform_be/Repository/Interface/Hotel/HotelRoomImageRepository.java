package com.java.travel_cross_platform_be.Repository.Interface.Hotel;

import com.java.travel_cross_platform_be.Model.Entity.Hotel.Hotel;
import com.java.travel_cross_platform_be.Model.Entity.Hotel.HotelRoom;
import com.java.travel_cross_platform_be.Model.Entity.Hotel.HotelRoomImage;
import com.java.travel_cross_platform_be.Model.Entity.Hotel.HotelRoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomImageRepository extends JpaRepository<HotelRoomType, Long> {
}
