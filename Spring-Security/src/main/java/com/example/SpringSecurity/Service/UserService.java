package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Entity.User;
import com.example.SpringSecurity.Model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerficationTokenForUser(String token, User user);
}
