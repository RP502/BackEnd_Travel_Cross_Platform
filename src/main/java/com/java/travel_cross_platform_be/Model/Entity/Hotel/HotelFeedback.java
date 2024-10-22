package com.java.travel_cross_platform_be.Model.Entity.Hotel;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "travel_hotels_feedbacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelFeedback extends BaseModel {
    private String content;
    private String note;
    private String status;
    private String type;
    private String rate;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "user_id") // Khóa ngoại tới User
    private TravelUser user;

    @OneToMany(mappedBy = "hotelFeedback", cascade = CascadeType.ALL)
    private List<HotelFeedbackImage> hotelFeedbackImages;



}
