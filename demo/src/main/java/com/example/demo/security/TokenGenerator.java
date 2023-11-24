package com.example.demo.security;

import com.example.demo.document.User;
import com.example.demo.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;

@Component
public class TokenGenerator {

    @Autowired
    JwtEncoder accessTokenEncoder;
    @Autowired
    @Qualifier("jwtRefreshTokenEncoder")
    JwtEncoder refreshTokenEncoder;
    private String createAccessToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Instant now = Instant.now();
        JwtClaimsSet claimSet = JwtClaimsSet.builder()
                .issuer("myapp")
                .issuedAt(now)
                .expiresAt(now.plus(5,ChronoUnit.MINUTES))
                .subject(user.getId())
                .build();
        return accessTokenEncoder.encode(JwtEncoderParameters.from(claimSet)).getTokenValue();
    }
    private String createRefreshToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Instant now = Instant.now();
        JwtClaimsSet claimSet = JwtClaimsSet.builder()
                .issuer("myapp")
                .issuedAt(now)
                .expiresAt(now.plus(30,ChronoUnit.DAYS))
                .subject(user.getId())
                .build();
        return accessTokenEncoder.encode(JwtEncoderParameters.from(claimSet)).getTokenValue();
    }
    public TokenDTO createToken (Authentication authentication){
        if(!(authentication.getPrincipal() instanceof User user)){
            throw new BadCredentialsException(
                    MessageFormat
                            .format("principle {0} is not of user type",authentication.getPrincipal())
            );
        }
        TokenDTO tokenDTO = TokenDTO.builder()
                .userId(user.getId())
                .accessToken(createAccessToken(authentication))
                .refreshToken(createRefreshToken(authentication))
                .build();
        String refreshToken ;
        if(authentication.getCredentials() instanceof Jwt jwt){
            Instant now = Instant.now();
            Instant expireAt = jwt.getExpiresAt();
            Duration duration = Duration.between(now,expireAt);
            long dayUntilExpiration = duration.toDays();
            if(dayUntilExpiration > 7){
                refreshToken = createRefreshToken(authentication);
            }else{
                refreshToken = jwt.getTokenValue();
            }
        }else{
            refreshToken = createRefreshToken(authentication);
        }

        return tokenDTO;
    }
}
