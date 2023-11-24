package com.example.ExceptionHandling.Service;

import com.example.ExceptionHandling.Dto.UserRequest;
import com.example.ExceptionHandling.Entity.User;
import com.example.ExceptionHandling.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest request){
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .gender(request.getGender())
                .mobileNumber(request.getMobileNumber())
                .build();
        return repository.save(user);
    }

    public User findUserById(int id) {
        return repository.findById(id).get();
    }
}
