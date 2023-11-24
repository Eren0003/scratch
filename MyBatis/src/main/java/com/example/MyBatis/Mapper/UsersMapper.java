package com.example.MyBatis.Mapper;

import com.example.MyBatis.Model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from users")
    List<Users> findAll();
    @Insert("insert into users(username,salary,id) values (#{username},#{salary},#{id})")
    void addUser(Users user);
    @Select("select * from users where username = #{username}")
    Users findUsers(String username);
    @Update("update users set salary =#{salary} where username = #{username}")
    void updateSalary(Users user);
    @Update("update users set username = #{username} where id = #{id}")
    void updateUsername(Users user);
    @Delete("delete from users where id = #{id}")
    void deleteUser(int id);
}
