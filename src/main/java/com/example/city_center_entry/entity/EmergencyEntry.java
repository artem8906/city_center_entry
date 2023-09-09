package com.example.city_center_entry.entity;

import java.util.Date;

public class EmergencyEntry extends Entry{


    public EmergencyEntry(Car car, PointEntryExit pointEntry) {
        super(car, new Date(), pointEntry);
    }
}
