package com.example.city_center_entry.controller;

import com.example.city_center_entry.entity.Car;
import com.example.city_center_entry.entity.Entry;
import com.example.city_center_entry.service.DataService;
import com.example.city_center_entry.service.NotificationService;
import com.example.city_center_entry.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class Controller {

    //    @Inject bean here
    RequestService requestService;


    //    @Inject bean here
    NotificationService notificationService;

    //@Inject

    DataService dataService;

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

    @GetMapping("/entries")
    public List<Entry> allClosedEntries() {
        return dataService.getListOfClosedEntryes();
    }

    @GetMapping("/allowedCars")
    public Map<String, Car> allAllowedCars() {
        return dataService.getRepository();
    }

}
