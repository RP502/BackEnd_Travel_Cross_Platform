package com.java.travel_cross_platform_be.Model.Entity.Ticket;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Entity.Tour.Tour;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "travel_tickets_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketImage extends BaseModel {
    private String url;
    private String status;
    private String content;
    private String note;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
}
