package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Auto;
import com.example.city_center_entry.entity.Entry;
import com.example.city_center_entry.entity.PointEntryExit;

import java.util.Date;

public class BarrierService {

   // @Inject for bean here
    DataService dataService;
    public void openForEntry(Auto auto, PointEntryExit entryIn) {
        dataService.addOpenEntry(new Entry(auto, new Date(), entryIn));
        open();
    }

    public void openForExit() {
        open();
    }

    public void open() {
        //brana sa otvara
    }

    public void stayClosed() {
        //brana informuje ze auto ne bolo najdeno v zozname povolenych
    }
}
