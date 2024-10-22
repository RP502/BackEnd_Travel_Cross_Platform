package com.java.travel_cross_platform_be.Model.Entity.Hotel;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "travel_hotels_feedback_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelFeedbackImage extends BaseModel {
    private String url;
    private String status;
    private String content;
    private String note;

    @ManyToOne
    @JoinColumn(name = "hotel_feedback_id")
    private HotelFeedback hotelFeedback;

}
