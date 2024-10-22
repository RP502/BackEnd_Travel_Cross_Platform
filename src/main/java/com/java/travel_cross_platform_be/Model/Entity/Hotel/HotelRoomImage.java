package com.java.travel_cross_platform_be.Model.Entity.Hotel;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "travel_hotels_rooms_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRoomImage extends BaseModel {
    private String url;
    private String status;
    private String content;
    private String note;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private HotelRoom room;
}
