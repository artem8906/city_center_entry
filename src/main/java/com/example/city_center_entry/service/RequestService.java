package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Auto;
import com.example.city_center_entry.entity.Owner;
import org.springframework.web.bind.annotation.RestController;


public class RequestService {

    //@Inject
    DataService dataService;

    //@Inject
    NotificationService notificationService;


    public void approve(Auto auto) {
        dataService.addNewAuto(auto);
    }

    public void refuse(Auto auto) {
        notificationService.notifyRefuseRequest(auto);
    }

    public void sendBackToUser(Owner owner) {
        notificationService.notifyAboutUncompleteDoc(owner.getEmail());
    }
}
