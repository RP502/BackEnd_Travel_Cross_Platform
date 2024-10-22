package com.java.travel_cross_platform_be.Model.Entity;


import com.java.travel_cross_platform_be.Model.BaseModel;
import com.java.travel_cross_platform_be.Model.Enum.ERole;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "roles")
@Builder
public class Role extends BaseModel {

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {}

    public Role(ERole name) {
        this.name = name;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
