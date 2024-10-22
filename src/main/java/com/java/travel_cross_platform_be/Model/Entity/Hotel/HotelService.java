package com.java.travel_cross_platform_be.Model.Entity.Hotel;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "travel_hotels_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelService extends BaseModel {
    private String name;
    private String description;
    private String status;
    private String content;
    private String note;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
