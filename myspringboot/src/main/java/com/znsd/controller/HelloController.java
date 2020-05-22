package com.znsd.controller;

import com.znsd.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private User user;

    @GetMapping("/show")
    public String show(Model model){
        System.out.println("this is first springboot laosu");
        System.out.println(user);
        model.addAttribute("uid","123456789");
        model.addAttribute("name","Jerry");
        return "show";
    }
    @GetMapping("/hello")
    public String getInfo(Model model){
        System.out.println("this is first springboot jsp");
        model.addAttribute("name","测试数据");
        return "index";
    }
}
