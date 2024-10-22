package com.java.travel_cross_platform_be.Model.Entity.Tour;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "travel_tours_schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourSchedule extends BaseModel {
//    private String date;
    private String time;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String description;
    private String status;
    private String content;
    private String note;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;
}
