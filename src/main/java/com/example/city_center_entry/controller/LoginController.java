package com.example.city_center_entry.controller;

import com.example.city_center_entry.enums.AuthorityType;
import com.example.city_center_entry.model.LoginForm;
import com.example.city_center_entry.service.SecurityContextService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginController {

    private SecurityContextService securityContextService;

    @GetMapping
    public String loginPage(ModelMap model) {
        if (securityContextService.hasAuthority(AuthorityType.ADMIN)) {
            return "redirect:/spravca";
        } else if (securityContextService.hasAuthority(
                AuthorityType.USER)) {
            return "redirect:/ziadatel";
        }
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        securityContextService.logout();
        return "redirect:/";
    }

    @GetMapping("/ziadatel/login")
    public String loginZiadatel(ModelMap model) {
        model.addAttribute("role", "ziadatel");
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/ziadatel/login")
    public String loginZiadatel(ModelMap model, HttpServletResponse response, LoginForm loginForm) {
        model.addAttribute("role", "ziadatel");
        try {
            securityContextService.login(AuthorityType.USER, loginForm.getLogin(), loginForm.getPassword());
            return "redirect:/ziadatel";
        } catch (Exception e) {
            // TODO: 9. 9. 2023 throw errors
            e.printStackTrace();
        }
        return "login";
    }

    @GetMapping("/spravca/login")
    public String loginSpravca(ModelMap model) {
        model.addAttribute("role", "spravca");
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/spravca/login")
    public String loginSpravca(ModelMap model, HttpServletResponse response, LoginForm loginForm) {
        model.addAttribute("role", "ziadatel");
        try {
            securityContextService.login(AuthorityType.ADMIN, loginForm.getLogin(), loginForm.getPassword());

            return "redirect:/spravca";
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: 9. 9. 2023 throw error
        }
        return "login";
    }
}
