package com.java.travel_cross_platform_be.DTOs.DTO.Tour;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreateTour {
    private String name;
    private String description;
    private Long cost;
    private Integer quantity;
    private String status;
    private String content;
    private Long vehicleId;
    private Long tourTypeId;
    private Long vehicleTypeId;
    private List<TourPharaDTO> tourPharas;
    private List<TourScheduleDTO> tourSchedules;
    private List<TourPlaceDTO> tourPlaces;
    private List<TourImageDTO> tourImages;
    private List<TourVideoDTO> tourVideos;
}
