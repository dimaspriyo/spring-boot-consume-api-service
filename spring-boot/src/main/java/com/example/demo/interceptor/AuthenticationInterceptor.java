package com.example.demo.interceptor;

import com.example.demo.util.JWTUtil;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    JWTUtil jwtUtil;

    Logger log = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String authorization = request.getHeader("Authorization");
        if(authorization != null && authorization.startsWith("Bearer ")){

            String token = authorization.substring(7);
            if(!jwtUtil.validate(token)){
                throw new JwtException("JWT Token Invalid");
            }
                return true;
        }else{
            throw new JwtException("No JWT Token Found!");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("posthandleee");
        log.info("posthandleee");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("aftercompleeeter");
        log.info("aftercompleeeter");
    }
}
