package com.java.travel_cross_platform_be.DTOs.DTO.Tour;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TourDTO {
    private String id;
    private String name;
    private String image;
    private String type;
    private Long evaluation;
    private Long evaluationCount;
    private Long booking;
    private Long price;
    private Long sale;
    private boolean isWhislist;
}
