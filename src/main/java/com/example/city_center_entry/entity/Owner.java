package com.example.city_center_entry.entity;

import lombok.Data;

@Data
public class Owner {
    private String name;
    private String adress;
    private String phoneNumber;
    private String email;

    public String getEmail() {
        return email;
    }

    public Owner(String name) {
        this.name = name;
    }
}
