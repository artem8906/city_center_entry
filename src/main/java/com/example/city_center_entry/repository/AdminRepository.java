package com.example.city_center_entry.repository;

import com.example.city_center_entry.entity.AdminEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminRepository {
    List<AdminEntity> admins;

    public AdminRepository(){
        this.admins = new ArrayList<>();
        AdminEntity admin = new AdminEntity();
        admin.setId(1);
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setName("Marek Benka");
        admins.add(admin);
    }

    public List<AdminEntity> getAll() {
        return admins;
    }

    public AdminEntity getById(int id) {
        return admins.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
    }

    public AdminEntity getByLoginAndPassword(String login, String password){
        return admins.stream().filter(it -> it.getLogin().equals(login) && it.getPassword().equals(password)).findFirst().orElse(null);
    }
}
