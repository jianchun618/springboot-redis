package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


/*
 * 组合注解@RestController=@Controller+ @ResponseBody
 * 加在控制器类上表明当前类是控制器对象，并且返回json
 *
 * springboot默认的视图层模板不是jsp  thymeleaf
 * */
@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/queryAll")
    public String queryAll(HttpSession session) {
        List<User> users = userService.queryAll();
        session.setAttribute("users",users);
        return "index";
    }

    @RequestMapping("/save")
    public void save() {
        User us = new User(1, "superboy", "2222222222");
        userService.save(us);
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
