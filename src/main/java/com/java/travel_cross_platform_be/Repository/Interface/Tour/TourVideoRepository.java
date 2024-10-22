package com.java.travel_cross_platform_be.Repository.Interface.Tour;

import com.java.travel_cross_platform_be.Model.Entity.Tour.Tour;
import com.java.travel_cross_platform_be.Model.Entity.Tour.TourVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourVideoRepository extends JpaRepository<TourVideo, Long> {
}
