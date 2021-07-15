package com.lmdd.demo.config;


import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
//    @ResponseBody //注释后走的是
    public String login(@RequestParam("username") String name, @RequestParam("password") String password, Model model, HttpServletRequest request){
        System.out.println(request.getParameter("l"));
        System.out.println(Locale.getDefault());
        if("admin".equals(name)&&"123456".equals(password)){
            return "redirect:/main.html";
//           redirect:/main.html   --- localhost:8081/lmdd/main.html
//           redirect:main.html   --- localhost:8081/lmdd/user/main.html
        }
        model.addAttribute("error",true);
        return "index";
    }
}
