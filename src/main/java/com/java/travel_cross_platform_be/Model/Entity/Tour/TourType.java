package com.java.travel_cross_platform_be.Model.Entity.Tour;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "travel_tours_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourType extends BaseModel {
    private String name;
    private Long discount;
    private Long price;

    @OneToOne(mappedBy = "tourType")
    private Tour tour;
}
