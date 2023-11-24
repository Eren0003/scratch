package com.example.MyBatis.Control;

import com.example.MyBatis.Exception.UserNotFoundException;
import com.example.MyBatis.Mapper.UsersMapper;
import com.example.MyBatis.Model.Users;
import com.example.MyBatis.Serive.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class Controller {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ApplicationService service;
    @GetMapping("/all")
    public List<Users> getAll(){
        return usersMapper.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<List<Users>> addUsers(@RequestBody Users user){
        usersMapper.addUser(user);
        return new ResponseEntity<List<Users>>(usersMapper.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findUser/{username}")
    public ResponseEntity<Users> findUser(@PathVariable(value = "username") String username){
//        Users user = usersMapper.findUsers(username);
//        if(user != null) {
//            return new ResponseEntity<Users>(usersMapper.findUsers(username),HttpStatus.OK);
//        }else{
//            throw new UserNotFoundException();
//        }
        try {
            return new ResponseEntity<Users>(service.findUser(username), HttpStatus.OK);
        }
        catch(Exception e){
            throw new UserNotFoundException();
        }
    }
    @PutMapping("/update/salary")
    public List<Users> updateSalary(@RequestBody Users user){
         usersMapper.updateSalary(user);
         return usersMapper.findAll();
    }
    @PutMapping("/update/username")
    public List<Users> updateUsername(@RequestBody Users user){
        usersMapper.updateUsername(user);
        return usersMapper.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public List<Users> deleteUser (@PathVariable(value = "id") int id){
        usersMapper.deleteUser(id);
        return usersMapper.findAll();
    }
}
