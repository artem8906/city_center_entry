package com.example.city_center_entry.controller;

import com.example.city_center_entry.entity.Auto;
import com.example.city_center_entry.service.DataService;
import com.example.city_center_entry.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import com.example.city_center_entry.service.RequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class Controller {

//    @Inject bean here
    RequestService requestService;



    //    @Inject bean here
    NotificationService notificationService;

    //start page
    @GetMapping
    public String main() {
        return "main";
    }

    //pre admina
    //level of security - admin
    //zobrazi vsetky vstupy podla datumu a/alebo auta s filtrom
    @GetMapping("/admin")
    public String admin() {
        //all entryes for particular date with filters by car, by date, by during stay and sorting
        return "admin";
    }

    //level of security - admin
    @PostMapping("/addByAdmin")
    public String addCarByAdmin(@PathVariable Auto auto) {
        requestService.approve(auto);
        return "admin";
    }

    @PostMapping("/addNewCar")
    public String requestForAddingNewCar(@PathVariable Auto auto) {
        notificationService.notifyAdminAboutNewRequestForAddCar(auto);
        return "main";
    }

    //level of security - admin
    //pre admina
    //pridava vela aut naraz bez schvalenia na zaklade range of ECV (relevantno pre sanitki, policajtov a td)
    @PostMapping("/addFewCars")
    public String addFewCarsByAdmin(String rangeOfLicensePlate, String owner) {
        dataService.addFewCars(Auto.createFewAutos(rangeOfLicensePlate, owner));
        return "admin";
    }
}
