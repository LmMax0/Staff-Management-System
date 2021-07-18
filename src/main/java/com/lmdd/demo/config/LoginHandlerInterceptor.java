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
        if ( "/lmdd/main.html".equals(uri) && session == null){ //没有登录
            response.sendRedirect(request.getContextPath()+"/index.html");
            return false;
        }

        return true;
    }


}
