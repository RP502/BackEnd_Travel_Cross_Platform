package com.java.travel_cross_platform_be.Model.Entity.Tour;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "travel_tours_feedback_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourFeedbackImage extends BaseModel {
    private String url;
    private String status;
    private String content;
    private String note;

    @ManyToOne
    @JoinColumn(name = "tour_feedback_id")
    private TourFeedback tourFeedback;
}
