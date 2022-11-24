package com.yinwei.springboot.serives;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinwei.springboot.entity.User;
import com.yinwei.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public boolean saveUser(User user) {
//        if(user.getId() == null) {    //mybatis-plus提供的方法，表示插入数据
//            return save(user);
//        } else {
//            return updateById(user);
//        }
        return saveOrUpdate(user);
    } 

//    @Autowired
//    private UserMapper userMapper;

//    public int save(User user) {//user没有ID，则表示是新增
//        if(user.getId() == null){
//            return userMapper.insert(user);
//        } else {//否则是更新
//            return userMapper.update(user);
//        }
//    }
}
