package com.java.travel_cross_platform_be.DTOs.DTO.Tour;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TourPlaceDTO {
    private String name;
    private String description;
    private String location;
    private String status;
    private String content;
    private String note;
}
