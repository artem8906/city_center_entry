package com.example.city_center_entry.controller;

import com.example.city_center_entry.model.EntryRequestForm;
import com.example.city_center_entry.repository.StreetEnumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ziadatel")
@AllArgsConstructor
public class UserController {

    private StreetEnumRepository streetEnumRepository;

    @GetMapping()
    public String getProfil() {
        return "ziadatel/profil";
    }

    @GetMapping("podat-ziadost")
    public String podatZiadost(ModelMap model) {
        EntryRequestForm requestForm = new EntryRequestForm();
        model.addAttribute("entryRequestForm", requestForm);
        model.addAttribute("streets", streetEnumRepository.nacitajUlice());
        return "ziadatel/podat-ziadost-form";
    }

    @PostMapping("podat-ziadost")
    public String podatZiadostOdoslat(ModelMap model, EntryRequestForm form) {
        return "ziadatel/podat-ziadost-form";
    }
}