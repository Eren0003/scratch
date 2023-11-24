package com.example.SpringSecurity.Repository;

import com.example.SpringSecurity.Entity.VerficationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepo extends JpaRepository<VerficationToken,Long> {
}
