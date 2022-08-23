package com.example.code.model.entities;

import com.example.code.model.modelUtils.UserRole;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "user_info")
public class UserInfo extends BaseEntity{
    @Column(unique = true)
    private String username;
    private String password;
    private UserRole userRole;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList;

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
}
