package com.java.travel_cross_platform_be.DTOs.DTO.Tour;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TourImageDTO {
    private String url;
    private String status;
    private String content;
    private String note;
}
