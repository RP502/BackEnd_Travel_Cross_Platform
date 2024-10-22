package com.java.travel_cross_platform_be.Controller;

import com.java.travel_cross_platform_be.DTOs.BaseResponse;
import com.java.travel_cross_platform_be.DTOs.DTO.Tour.CreateTour;
import com.java.travel_cross_platform_be.DTOs.DTO.Tour.TourDTO;
import com.java.travel_cross_platform_be.Service.Interface.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/tour")
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<List<TourDTO>>> getAllTours() {
        List<TourDTO> tourDTOs = tourService.getAllTours();
        BaseResponse<List<TourDTO>> response = new BaseResponse<>("List of tours", tourDTOs);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<TourDTO>> createTour(@RequestBody CreateTour createTour) {
        TourDTO tourDTO = tourService.createTour(createTour);
        BaseResponse<TourDTO> response = new BaseResponse<>("Tour created", tourDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<TourDTO>> updateTour(@RequestBody CreateTour createTour, @PathVariable Long id) {
        TourDTO tourDTO = tourService.updateTour(createTour, id);
        BaseResponse<TourDTO> response = new BaseResponse<>("Tour updated", tourDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/tour-sizes")
    public ResponseEntity<BaseResponse<List<String>>> getTour(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<String> tourSizes = tourService.getTours(pageable).stream().map(TourDTO::getName).toList();
        BaseResponse<List<String>> response = new BaseResponse<>("List of tour sizes", tourSizes);
        return ResponseEntity.ok(response);
    }
}
