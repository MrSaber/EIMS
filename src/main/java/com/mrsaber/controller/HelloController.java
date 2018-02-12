package com.mrsaber.controller;

import com.mrsaber.mapper.UserMapper;
import com.mrsaber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class HelloController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login.do")
    public Boolean login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user =new User();
        user.setUser_name(username);
        user.setUser_password(password);

        User cUser = userMapper.get(user);
        if(cUser==null)
        {
            response.sendRedirect("/web/index.html");
            return false;
        }

        session.setAttribute("user",cUser);
        switch (cUser.getUser_role())
        {
            case 3:response.sendRedirect("/web/admin.html");break;
            case 1:response.sendRedirect("/web/shenhe.html");break;
            case 2:response.sendRedirect("/web/chakan.html");break;
        }
        return true;
    }

    @RequestMapping("/logout.do")
    public Boolean Login(HttpServletRequest request,HttpServletResponse response)
    {
        request.getSession().setAttribute("isLogin","false");
        try {
            response.sendRedirect("/web/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
