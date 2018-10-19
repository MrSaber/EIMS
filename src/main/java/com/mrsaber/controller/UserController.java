package com.mrsaber.controller;

import com.mrsaber.mapper.UserMapper;
import com.mrsaber.model.User;
import com.mrsaber.security.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("u")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RoleCheck(level = {3})
    @RequestMapping("/add.do")
    public String add(User user) {
        try {
            userMapper.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "添加成功";
    }

    @RoleCheck(level = {3})
    @RequestMapping("/del.do")
    public String del(Integer userId) {
        try {
            User user = new User();
            user.setUser_id(userId);
            userMapper.del(user);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "删除成功";
    }

    @RoleCheck(level = {3})
    @RequestMapping("/update.do")
    public String update(User user) {
        try {
            userMapper.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "更新成功";
    }

    @RequestMapping("/getAll.do")
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @RequestMapping("/get.do")
    public User get(User user) {
        return userMapper.get(user);
    }
}
