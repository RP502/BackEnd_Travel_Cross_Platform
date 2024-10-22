package com.java.travel_cross_platform_be.Converter;

import com.java.travel_cross_platform_be.DTOs.DTO.Tour.*;
import com.java.travel_cross_platform_be.Model.Entity.Tour.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TourConverter {

    public TourDTO convertToDTO(Tour tour) {
        Long evaluationAverage = (long) tour.getTourFeedbacks().stream().mapToLong(TourFeedback::getRate).average().orElse(0);
        Long evaluationCount = tour.getTourFeedbacks().stream().mapToLong(TourFeedback::getRate).sum();
        return TourDTO.builder()
                .id(tour.getId().toString())
                .name(tour.getName())
                .image(tour.getTourImages().get(0).getUrl())
                .type(tour.getTourType().getName())
                .evaluation(evaluationAverage)
                .evaluationCount(evaluationCount)
                .booking((long) tour.getBookings().size())
                .price(tour.getCost())
                .sale(tour.getTourType().getDiscount())
                .isWhislist(true)
                .build();
    }

    public List<TourDTO> convertToDTOs(List<Tour> tours) {
        return tours.stream().map(this::convertToDTO).toList();
    }

    public Tour convertToEntity(CreateTour createTour) {
        return Tour.builder()
                .name(createTour.getName())
                .description(createTour.getDescription())
                .cost(createTour.getCost())
                .quantity(createTour.getQuantity())
                .status(createTour.getStatus())
                .content(createTour.getContent())
                .tourImages(convertTourImageToEntities(createTour.getTourImages()))
                .tourSchedules(convertTourScheduleToEntities(createTour.getTourSchedules()))
                .tourPharas(convertTourPharaToEntities(createTour.getTourPharas()))
                .tourPlaces(convertTourPlaceToEntities(createTour.getTourPlaces()))
                .build();
    }

    public TourPlaceDTO convertTourPlaceToDTO(TourPlace tourPlace) {
        return TourPlaceDTO.builder()
                .name(tourPlace.getName())
                .content(tourPlace.getContent())
                .build();
    }

    public List<TourPlaceDTO> convertTourPlaceToDTOs(List<TourPlace> tourPlaces) {
        return tourPlaces.stream().map(this::convertTourPlaceToDTO).toList();
    }

    public TourPlace convertTourPlaceToEntity(TourPlaceDTO tourPlaceDTO) {
        return TourPlace.builder()
                .name(tourPlaceDTO.getName())
                .content(tourPlaceDTO.getContent())
                .build();
    }

    public List<TourPlace> convertTourPlaceToEntities(List<TourPlaceDTO> tourPlaceDTOs) {
        return tourPlaceDTOs.stream().map(this::convertTourPlaceToEntity).toList();
    }

    public TourPharaDTO convertTourPharaToDTO(TourPhara tourPhara) {
        return TourPharaDTO.builder()
                .title(tourPhara.getTitle())
                .content(tourPhara.getContent())
                .build();
    }

    public List<TourPharaDTO> convertTourPharaToDTOs(List<TourPhara> tourPharas) {
        return tourPharas.stream().map(this::convertTourPharaToDTO).toList();
    }

    public TourPhara convertTourPharaToEntity(TourPharaDTO tourPharaDTO) {
        return TourPhara.builder()
                .title(tourPharaDTO.getTitle())
                .content(tourPharaDTO.getContent())
                .build();
    }

    public List<TourPhara> convertTourPharaToEntities(List<TourPharaDTO> tourPharaDTOs) {
        return tourPharaDTOs.stream().map(this::convertTourPharaToEntity).toList();
    }

    public TourImage convertTourImageToEntity(TourImageDTO tourImageDTO) {
       return TourImage.builder()
               .url(tourImageDTO.getUrl())
               .note(tourImageDTO.getNote())
               .content(tourImageDTO.getContent())
               .status(tourImageDTO.getStatus())
               .build();
    }

    public List<TourImage> convertTourImageToEntities(List<TourImageDTO> tourImageDTOs) {
        return tourImageDTOs.stream().map(this::convertTourImageToEntity).toList();
    }

    public TourScheduleDTO convertTourScheduleToDTO (TourSchedule tourSchedule) {
        return TourScheduleDTO.builder()
                .time(tourSchedule.getTime())
                .startDate(tourSchedule.getStartDate().toString())
                .endDate(tourSchedule.getEndDate().toString())
                .build();
    }

    public List<TourScheduleDTO> convertTourScheduleToDTOs(List<TourSchedule> tourSchedules) {
        return tourSchedules.stream().map(this::convertTourScheduleToDTO).toList();
    }

    public TourSchedule convertTourScheduleToEntity(TourScheduleDTO tourScheduleDTO) {
        return TourSchedule.builder()
                .time(tourScheduleDTO.getTime())
                .startDate(LocalDateTime.parse(tourScheduleDTO.getStartDate()))
                .endDate(LocalDateTime.parse(tourScheduleDTO.getEndDate()))
                .build();
    }

    public List<TourSchedule> convertTourScheduleToEntities(List<TourScheduleDTO> tourScheduleDTOs) {
        return tourScheduleDTOs.stream().map(this::convertTourScheduleToEntity).toList();
    }

}
