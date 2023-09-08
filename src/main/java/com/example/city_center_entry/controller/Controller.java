package com.example.city_center_entry.controller;

import com.example.city_center_entry.entity.Car;
import com.example.city_center_entry.service.NotificationService;
import com.example.city_center_entry.service.RequestService;
import org.springframework.web.bind.annotation.*;

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
    public String addCarByAdmin(@PathVariable Car car) {
        requestService.approve(car);
        return "admin";
    }

    @PostMapping("/addNewCar")
    public String requestForAddingNewCar(@PathVariable Car car) {
        notificationService.notifyAdminAboutNewRequestForAddCar(car);
        return "main";
    }

}
