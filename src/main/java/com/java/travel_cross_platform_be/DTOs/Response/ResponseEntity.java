package com.java.travel_cross_platform_be.DTOs.Response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseEntity {
    private String message;
    private HttpStatus status;
    private Object data;
}