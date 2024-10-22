package com.java.travel_cross_platform_be.Model.Entity.Hotel;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Entity.BookHotel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "travel_hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel extends BaseModel {
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private Double price;
    private String status;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelService> hotelServices;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelImage> hotelImages;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelVideo> hotelVideos;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelFeedback> hotelFeedbacks;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelSchedule> hotelSchedules;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelRoom> hotelRooms;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookHotel> bookHotels;
}
