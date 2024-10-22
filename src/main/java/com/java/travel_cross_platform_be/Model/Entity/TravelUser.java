package com.java.travel_cross_platform_be.Model.Entity;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Entity.Hotel.HotelFeedback;
import com.java.travel_cross_platform_be.Model.Entity.Ticket.TicketFeedback;
import com.java.travel_cross_platform_be.Model.Entity.Tour.TourFeedback;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "travel_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelUser extends BaseModel {

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @NotNull(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Email(message = "Email is not valid")
    @NotNull(message = "Email is required")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "verification_token", nullable = true)
    private String verificationToken;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "verification_expiration")
    private LocalDateTime verificationCodeExpiresAt;


    @NotNull(message = "Phone number is required")
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "nationality", nullable = true)
    private String nationality;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "gender", nullable = true)
//    @Enumerated(EnumType.STRING)  // Lưu enum dưới dạng chuỗi
//    private Gender gender;
    private String gender;

    @Column(name = "enabled", nullable = false)
    @ColumnDefault("false")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "profile_picture", nullable = true)
    private String profilePicture;

    @Column(name = "cover_picture", nullable = true)
    private String coverPicture;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookTour> bookings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookHotel> bookHotels;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookTicket> bookTickets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TourFeedback> tourFeedbacks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelFeedback> hotelFeedbacks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TicketFeedback> ticketFeedbacks;

}