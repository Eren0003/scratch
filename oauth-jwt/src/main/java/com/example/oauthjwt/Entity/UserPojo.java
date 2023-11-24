package com.example.oauthjwt.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class UserPojo {
    @Id
    private String username;
    private String password;
    private Collection<GrantedAuthority> listOfGrantedAuthority;
}
