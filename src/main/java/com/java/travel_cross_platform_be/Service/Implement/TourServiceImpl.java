package com.java.travel_cross_platform_be.Service.Implement;

import com.java.travel_cross_platform_be.Converter.TourConverter;
import com.java.travel_cross_platform_be.DTOs.DTO.Tour.CreateTour;
import com.java.travel_cross_platform_be.DTOs.DTO.Tour.TourDTO;
import com.java.travel_cross_platform_be.Model.Entity.Tour.Tour;
import com.java.travel_cross_platform_be.Repository.Interface.Tour.TourRepository;
import com.java.travel_cross_platform_be.Service.Interface.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final TourConverter tourConverter;
    @Override
    public TourDTO getTourById(Long id) {
        Optional<Tour> tour = tourRepository.findById(id);
        return tour.map(tourConverter::convertToDTO).orElse(null);
    }

    @Override
    public List<TourDTO> getAllTours() {
        List<Tour> tours = tourRepository.findAll();
        if (tours.isEmpty()) {
            return List.of();
        }
        return tourConverter.convertToDTOs(tours);
    }

    @Override
    public List<TourDTO> getTours(Pageable pageable) {
        List<Tour> tours = tourRepository.findAll(pageable).getContent();
        if (tours.isEmpty()) {
            return List.of();
        }
        return tourConverter.convertToDTOs(tours);
    }

    @Override
    public TourDTO createTour(CreateTour createTour) {
        Tour tour = tourConverter.convertToEntity(createTour);
        Tour savedTour = tourRepository.save(tour);
        return tourConverter.convertToDTO(savedTour);
    }

    @Override
    public void deleteTourById(Long id) {
        tourRepository.deleteById(id);
    }

    @Override
    public TourDTO updateTour(CreateTour createTour, Long id) {
        Optional<Tour> tour = tourRepository.findById(id);
        if (tour.isEmpty()) {
            return null;
        }
        Tour updatedTour = tourConverter.convertToEntity(createTour);
        updatedTour.setId(id);
        Tour savedTour = tourRepository.save(updatedTour);
        return tourConverter.convertToDTO(savedTour);
    }
}
