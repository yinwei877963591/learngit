package com.yinwei.springboot.controller;

import com.yinwei.springboot.entity.User;
import com.yinwei.springboot.mapper.UserMapper;
import com.yinwei.springboot.serives.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //新增和修改
    @PostMapping
    public boolean save(@RequestBody User user) {
        //新增或更新
        return userService.saveUser(user);
    }

    //查询所有数据
    @GetMapping
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }

    //删除数据
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteByid(id);
    }

    //分页查询
    //接口路径：/user/page？pageNum=1&pageSize=10
    //@RequestParam接收
    //limit第一个参数 = （pageNum - 1） * pageSize
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String username){
        pageNum = (pageNum - 1) * pageSize;
        username = "%" + username + "%";
        List<User> data = userMapper.selectPage(pageNum, pageSize, username);
        Integer total = userMapper.selectTotal(username);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
