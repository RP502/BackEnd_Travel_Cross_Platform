package com.java.travel_cross_platform_be.Model.Entity.Tour;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "travel_vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourVehicle extends BaseModel {
    private String name;
    private String description;
    private String type;
    private String model;
    private String plateNumber;
    private String color;
    private String fuelType;
    private String transmission;

    @OneToOne(mappedBy = "vehicle")
    private Tour tour;
}
