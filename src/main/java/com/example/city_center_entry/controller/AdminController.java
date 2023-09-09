package com.example.city_center_entry.controller;

import com.example.city_center_entry.entity.EntryRequestEntity;
import com.example.city_center_entry.enums.AuthorityType;
import com.example.city_center_entry.repository.EntryRequestRepository;
import com.example.city_center_entry.service.SecurityContextService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("spravca")
@AllArgsConstructor
public class AdminController {

    private EntryRequestRepository entryRequestRepository;
    private SecurityContextService securityContextService;

    @GetMapping
    public String getProfil(ModelMap model) {
        if (!securityContextService.hasAuthority(AuthorityType.ADMIN)) {
            return "redirect:/";
        }
        model.addAttribute("requests", entryRequestRepository.getAll());
        return "spravca/profil";
    }
}
