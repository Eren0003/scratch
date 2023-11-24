package com.example.SpringSecurity.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class VerficationToken {
    private static final int EXPIRATION_TIME = 10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String token;
    private Date expirationTime;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId",
    nullable = false,
    foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private User user;

   public VerficationToken(String token ,User user){
       super();
       this.token = token;
       this.user = user;
       this.expirationTime = calculateExpirationTime(EXPIRATION_TIME);
   }
   public VerficationToken(String token){
       super();
       this.token = token;
       this.expirationTime = calculateExpirationTime(EXPIRATION_TIME);
   }

    private Date calculateExpirationTime(int expirationTime) {
       Calendar calendar = Calendar.getInstance();
       calendar.setTimeInMillis(new Date().getTime());
       calendar.add(Calendar.MINUTE,expirationTime);
       return new Date(calendar.getTime().getTime());
    }
}
