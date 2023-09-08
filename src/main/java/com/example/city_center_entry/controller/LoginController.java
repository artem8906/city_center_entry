package com.example.city_center_entry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping
    public String loginPage(ModelMap model) {
        return "login";
    }

    @GetMapping("/ziadatel/login")
    public String loginZiadatel(ModelMap model){
        return "redirect:/ziadatel";
    }

    @GetMapping("/spravca/login")
    public String loginSpravca(ModelMap model){
        return "redirect:/spravca";
    }
}
