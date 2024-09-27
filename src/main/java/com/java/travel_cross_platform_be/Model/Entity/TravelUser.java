package com.java.travel_cross_platform_be.Model.Entity;

import com.java.travel_cross_platform_be.Model.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "travel_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelUser extends BaseModel implements UserDetails {

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

    @Column(name= "role", nullable = true)
//    @Enumerated(EnumType.STRING)  // Lưu enum dưới dạng chuỗi
//    private Role role;
    private String role;

    @Column(name = "profile_picture", nullable = true)
    private String profilePicture;

    @Column(name = "cover_picture", nullable = true)
    private String coverPicture;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}