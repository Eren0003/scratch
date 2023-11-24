package com.example.security.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "security")
public class Security {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name="user_name")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="user_role")
    private String userRole;
    @Column(name= "active")
    private boolean active;
}
