package com.example.city_center_entry.entity;

import java.util.Date;

public class Bill {
    private final double amount;
    private final Date dateOfCreation;

    public Bill(double amount) {
        this.amount = amount;
        this.dateOfCreation = new Date();
    }
}
