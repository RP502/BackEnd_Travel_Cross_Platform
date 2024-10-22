package com.java.travel_cross_platform_be.DTOs.DTO.Tour;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TourScheduleDTO {
//    private String date;
    private String time;
    private String startDate;
    private String endDate;
    private String location;
    private String description;
    private String status;
    private String content;
    private String note;
}
