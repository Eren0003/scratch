package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Entity.User;
import com.example.SpringSecurity.Entity.VerficationToken;
import com.example.SpringSecurity.Model.UserModel;
import com.example.SpringSecurity.Repository.UserRepo;
import com.example.SpringSecurity.Repository.VerificationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private VerificationTokenRepo verificationTokenRepo;
    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setRole("USER_ROLE");
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepo.save(user);
        return null;
    }

    @Override
    public void saveVerficationTokenForUser(String token, User user) {
       VerficationToken verficationToken = new VerficationToken(token,user);
       verificationTokenRepo.save(verficationToken);
    }
}
