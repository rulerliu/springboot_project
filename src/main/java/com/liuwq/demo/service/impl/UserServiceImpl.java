package com.liuwq.demo.service.impl;

import com.liuwq.demo.dao.UserMapper;
import com.liuwq.demo.entity.User;
import com.liuwq.demo.enums.ResponseEnum;
import com.liuwq.demo.enums.RoleEnum;
import com.liuwq.demo.service.UserService;
import com.liuwq.demo.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     */
   @Override
   public ResponseVo register(User user){
//       userMapper.countByEmail();
       //username不能重复

       int countByUsername = userMapper.countByUsername(user.getUsername());
       int countByEmail = userMapper.countByEmail(user.getEmail());


       if(countByUsername>0){
           return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
       }
       if(countByEmail>0){
           return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
       }
//设置管理员身份
       user.setRole(RoleEnum.ADMIN.getCode());

//       System.out.println("user.getPassword()="+user.getPassword());
//       System.out.println("user.getPassword().getBytes(StandardCharsets.UTF_8)="+user.getPassword().getBytes(StandardCharsets.UTF_8));
//       System.out.println("DigestUtils="+DigestUtils.md5DigestAsHex(
//               user.getPassword().getBytes(StandardCharsets.UTF_8)
//       ));

       //MD5摘要算法(Spring自带) 密码加密
       user.setPassword(DigestUtils.md5DigestAsHex(
               user.getPassword().getBytes(StandardCharsets.UTF_8)
       ));

       int resultCount = userMapper.insertSelective(user);
       if (resultCount == 0) {
           return ResponseVo.error(ResponseEnum.ERROR);
       }
       return ResponseVo.success();

    };

    /**
     * 登录
     */
    public ResponseVo<User> login(String username, String password){
        User user =  userMapper.selectByUsername(username);

        if(user!=null){
            if(user.getPassword().equalsIgnoreCase(
                    DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)
            ))){
                user.setPassword("");
                return ResponseVo.success(user);
            }

            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);

    };
}
