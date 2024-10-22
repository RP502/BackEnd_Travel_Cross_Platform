package com.java.travel_cross_platform_be.Model.Entity.Tour;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "travel_tours_feedbacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourFeedback extends BaseModel {
    private String content;
    private String note;
    private String status;
    private String type;
    private Long rate;

    @ManyToOne
    @JoinColumn(name = "user_id") // Khóa ngoại tới User
    private TravelUser user;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @OneToMany(mappedBy = "tourFeedback", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TourFeedbackImage> tourFeedbackImages;

}
