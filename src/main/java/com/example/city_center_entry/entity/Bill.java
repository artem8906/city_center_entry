package com.example.city_center_entry.entity;

import java.util.Calendar;
import java.util.Date;

public class Bill {
    private final double amount;
    private final Date dateOfCreation;

    private final Date dateOfExpiration;

    public Bill(double amount) {
        this.amount = amount;
        this.dateOfCreation = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCreation);
        calendar.add(Calendar.DAY_OF_MONTH, 15);
        dateOfExpiration = calendar.getTime();
    }
}
