package com.lmdd.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        登录拦截器~~~
        String uri = request.getRequestURI();
        System.out.println(uri);
        System.out.println("登录拦截器~~~");
        HttpSession session = request.getSession(false);
        try {
            if (session != null && session.getAttribute("loginUser") != null) { //有登录
                return true;
            }else {
                response.sendRedirect("index.html");
                return false;
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        return false;
    }


}
