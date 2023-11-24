package com.example.MyBatis.Serive;

import com.example.MyBatis.Exception.UserNotFoundException;
import com.example.MyBatis.Mapper.UsersMapper;
import com.example.MyBatis.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired
    private UsersMapper usersMapper;

    public Users findUser(String username){
        Users user = usersMapper.findUsers(username);
        if(user != null) {
            return usersMapper.findUsers(username);
        }else{
            throw new UserNotFoundException();
        }
    }
}
