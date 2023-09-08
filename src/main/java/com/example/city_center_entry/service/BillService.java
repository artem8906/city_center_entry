package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Bill;
import com.example.city_center_entry.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class BillService {
    //@Inject bean be here
    DataService dataService;

    //@Inject bean be here
    NotificationService notificationService;

    public List<Bill> createAndSendBill(Car car) {
        List<Bill> billList = new ArrayList<>();
        for (String d : car.getAimOfEntry()) {
            billList.add(new Bill(dataService.getPriceList().get(d)));
        }
        return billList;


    }


}
