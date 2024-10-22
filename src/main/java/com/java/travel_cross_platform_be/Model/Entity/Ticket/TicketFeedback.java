package com.java.travel_cross_platform_be.Model.Entity.Ticket;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Entity.Tour.Tour;
import com.java.travel_cross_platform_be.Model.Entity.Tour.TourFeedbackImage;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "travel_tickets_feedbacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketFeedback extends BaseModel {
    private String content;
    private String note;
    private String status;
    private String type;
    private String rate;

    @ManyToOne
    @JoinColumn(name = "user_id") // Khóa ngoại tới User
    private TravelUser user;

    @ManyToOne
    @JoinColumn(name = "ticket_id") // Khóa ngoại tới Ticket
    private Ticket ticket;

    @OneToMany(mappedBy = "ticketFeedback", fetch = FetchType.LAZY)
    private List<TicketFeedbackImage> ticketFeedbackImages;
}
