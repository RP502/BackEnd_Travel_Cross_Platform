package com.java.travel_cross_platform_be.Model.Entity;

import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "verification_token", nullable = true)
    private String verificationToken;

    @NotNull(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email(message = "Email is not valid")
    @NotNull(message = "Email is required")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull(message = "Phone number is required")
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name= "role", nullable = false)
    private Role role;

    @Column(name = "profile_picture", nullable = true)
    private String profilePicture;

    @Column(name = "cover_picture", nullable = true)
    private String coverPicture;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of( new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
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