package com.yinwei.springboot.mapper;

import com.yinwei.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * from sys_user")
    List<User> findAll();

    @Insert("insert into sys_user(username, password, nickname, email, phone, address) VALUES (#{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address});")
    int insert(User user);

    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    Integer deleteByid(@Param("id") Integer id);
}
