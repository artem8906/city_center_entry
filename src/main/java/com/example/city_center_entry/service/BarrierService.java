package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Car;
import com.example.city_center_entry.entity.Entry;
import com.example.city_center_entry.entity.PointEntryExit;

import java.util.Date;

public class BarrierService {

   // @Inject for bean here
    DataService dataService;
    public void openForEntry(Car car, PointEntryExit entryIn) {
        dataService.addOpenEntry(new Entry(car, new Date(), entryIn));
        open();
    }

    public void openForExit() {
        open();
    }

    public void open() {
        //brana sa otvara
    }

    public void openInEmergencyCase() {
        //im emergency case after contact with operator gate will open and

    }

    public void stayClosed() {
        //brana informuje ze auto ne bolo najdeno v zozname povolenych
    }
}
