package com.liuwq.demo.controller;

import com.liuwq.demo.entity.User;
import com.liuwq.demo.service.UserService;
import com.liuwq.demo.vo.ResponseVo;
import form.UserLoginForm;
import form.UserRegisterForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseVo register(@RequestBody UserRegisterForm userForm){
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userService.register(user);
       // return ResponseVo.success(0,"成功");
    }

    @PostMapping("login")
    public ResponseVo<User> login(@RequestBody UserLoginForm userForm){
        return userService.login(userForm.getUsername(),userForm.getPassword());
    }
}
