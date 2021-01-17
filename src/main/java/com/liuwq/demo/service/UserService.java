package com.liuwq.demo.service;

import com.liuwq.demo.entity.User;
import com.liuwq.demo.vo.ResponseVo;

public interface UserService {
    /**
     * 注册
     */
    ResponseVo register(User user);

    /**
     * 登录
     */
    ResponseVo login(String username, String password);
}
