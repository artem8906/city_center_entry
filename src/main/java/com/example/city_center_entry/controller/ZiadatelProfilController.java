package com.example.city_center_entry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ziadatel")
public class ZiadatelProfilController {

    @GetMapping()
    public String getProfil(){
        return "ziadatel/profil";
    }
}
