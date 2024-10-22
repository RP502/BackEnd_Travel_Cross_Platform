package com.java.travel_cross_platform_be.Model.Entity;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Entity.Hotel.Hotel;
import com.java.travel_cross_platform_be.Model.Entity.Tour.Tour;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "travel_book_hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookHotel extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id") // Khóa ngoại tới User
    private TravelUser user;

    @ManyToOne
    @JoinColumn(name = "hotel_id") // Khóa ngoại tới Hotel
    private Hotel hotel;

    private LocalDateTime bookingDate; // Ngày đặt
    private Integer quantity; // Số lượng người tham gia
    private String status; // Tình trạng đặt (VD: "confirmed", "pending", "cancelled")
}
