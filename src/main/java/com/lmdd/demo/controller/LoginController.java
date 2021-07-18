package com.lmdd.demo.controller;


import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
//    @ResponseBody //注释后走的是
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpServletRequest request) {

        System.out.println(request.getParameter("l"));
        System.out.println(Locale.getDefault());
        if("admin".equals(username) && "123456".equals(password)){
            request.getSession().setAttribute("loginUser",username);
            return "redirect:/main.html";
//           redirect:/main.html   --- localhost:8081/lmdd/main.html
//           redirect:main.html   --- localhost:8081/lmdd/user/main.html
        }
        model.addAttribute("error",true);
        return "index";
    }

}
