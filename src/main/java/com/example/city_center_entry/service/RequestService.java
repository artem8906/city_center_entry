package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Car;
import com.example.city_center_entry.entity.Owner;
import org.springframework.stereotype.Component;

@Component
public class RequestService {

    //@Inject
    DataService dataService;

    //@Inject
    NotificationService notificationService;


    public void approve(Car car) {
        dataService.addNewAuto(car);
    }

    public void refuse(Car car) {
        notificationService.notifyRefuseRequest(car);
    }

    public void sendBackToUser(Owner owner) {
        notificationService.notifyAboutUncompleteDoc(owner.getEmail());
    }
}
