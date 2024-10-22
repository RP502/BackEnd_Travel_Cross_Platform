package com.java.travel_cross_platform_be.Model.Entity.Hotel;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "travel_hotels_rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRoom extends BaseModel {
    private String name;
    private String description;
    private String note;
    private Long price;
    private Long discount;
    private String status;
    private String content;
    private String url;
    private String type;
    private String bedType;
    private String bedSize;
    private String view;
    private String roomSize;
    private String roomCapacity;
    private String roomFacilities;
    private String roomServices;
    private String roomAmenities;
    private String roomMedia;
    private String roomFoodDrink;
    private String roomBathroom;
    private String roomOutdoors;
    private String roomActivities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
    private HotelRoomType roomType;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelRoomImage> hotelRoomImages;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
