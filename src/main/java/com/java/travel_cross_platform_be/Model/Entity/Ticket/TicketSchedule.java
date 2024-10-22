package com.java.travel_cross_platform_be.Model.Entity.Ticket;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Entity.Tour.Tour;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "travel_tickets_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketSchedule extends BaseModel {
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
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
}
