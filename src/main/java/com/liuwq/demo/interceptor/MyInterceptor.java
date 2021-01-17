package com.liuwq.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("==========jin  ru pre  handle ====");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html;charset=UTF-8");//这句话是解决乱码的
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            return false;
        }

        Object user = redisTemplate.opsForValue().get(token);
        if (user == null) {
            return false;
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("================= jin ru  after ===============");
    }

}