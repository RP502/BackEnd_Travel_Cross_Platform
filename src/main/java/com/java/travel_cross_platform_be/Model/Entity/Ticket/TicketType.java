package com.java.travel_cross_platform_be.Model.Entity.Ticket;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Entity.Tour.Tour;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "travel_tickets_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketType extends BaseModel {
    private String name;
    private Long discount;
    private Long price;

    @OneToOne(mappedBy = "ticketType")
    private Ticket ticket;

}
