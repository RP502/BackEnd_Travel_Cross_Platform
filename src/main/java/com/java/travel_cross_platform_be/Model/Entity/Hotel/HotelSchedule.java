package com.java.travel_cross_platform_be.Model.Entity.Hotel;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "travel_hotels_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelSchedule extends BaseModel {
    private String date;
    private String time;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String description;
    private String status;
    private String content;
    private String note;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
