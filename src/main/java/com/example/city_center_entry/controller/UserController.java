package com.example.city_center_entry.controller;

import com.example.city_center_entry.entity.UserEntity;
import com.example.city_center_entry.enums.AuthorityType;
import com.example.city_center_entry.model.EntryRequestForm;
import com.example.city_center_entry.repository.StreetEnumRepository;
import com.example.city_center_entry.service.SecurityContextService;
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
    private SecurityContextService securityContextService;

    @GetMapping()
    public String getProfil(ModelMap model) {
        if (!securityContextService.hasAuthority(AuthorityType.USER)) {
            return "redirect:/";
        }
        model.addAttribute("user", securityContextService.getUser());
        return "ziadatel/profil";
    }

    @GetMapping("podat-ziadost")
    public String podatZiadost(ModelMap model) {
        if (!securityContextService.hasAuthority(AuthorityType.USER)) {
            return "redirect:/";
        }

        model.addAttribute("entryRequestForm", securityContextService.getUser().toEntryRequest());
        model.addAttribute("streets", streetEnumRepository.nacitajUlice());
        return "ziadatel/podat-ziadost-form";
    }

    @PostMapping("podat-ziadost")
    public String podatZiadostOdoslat(ModelMap model, EntryRequestForm form) {
        if (!securityContextService.hasAuthority(AuthorityType.USER)) {
            return "redirect:/";
        }
        return "ziadatel/podat-ziadost-form";
    }

    @GetMapping("zoznam-ziadosti")
    public String zoznamZiadosti(ModelMap model){

        return "ziadatel/zoznam-ziadosti";
    }
}