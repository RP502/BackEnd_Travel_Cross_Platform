package com.java.travel_cross_platform_be.Service.Interface;

import com.java.travel_cross_platform_be.DTOs.DTO.Tour.CreateTour;
import com.java.travel_cross_platform_be.DTOs.DTO.Tour.TourDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TourService {
    TourDTO getTourById(Long id);
    List<TourDTO> getAllTours();
    List<TourDTO> getTours(Pageable pageable);
    TourDTO createTour(CreateTour createTour);
    void deleteTourById(Long id);
    TourDTO updateTour(CreateTour createTour, Long id);
}
