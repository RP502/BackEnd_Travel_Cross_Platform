package com.java.travel_cross_platform_be.Model.Entity.Tour;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "travel_tours_places")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourPlace extends BaseModel {
    private String name;
    private String description;
    private String location;
    private String status;
    private String content;
    private String note;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;
}
