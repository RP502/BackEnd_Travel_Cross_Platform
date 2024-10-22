package com.java.travel_cross_platform_be.Model.Entity.Hotel;


import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "travel_hotels_room_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRoomType  extends BaseModel {
    private String name;
    private String description;
    private String note;
    private Long price;
    private Long discount;
    private Long maxPeople;
    private Long maxChildren;
    private Long maxAdults;

    @OneToOne(mappedBy = "roomType")
    private HotelRoom hotelRoom;

}
