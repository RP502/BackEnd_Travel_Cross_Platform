package com.java.travel_cross_platform_be.DTOs;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private String message;
    private T data;
}
