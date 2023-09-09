package com.example.city_center_entry.repository;

import com.example.city_center_entry.entity.UserEntity;
import com.example.city_center_entry.enums.TypeOfPerson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private List<UserEntity> users;

    public UserRepository() {
        users = new ArrayList<>();
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setLogin("login");
        user.setPassword("password");
        user.setTypeOfPerson(TypeOfPerson.FYZICKA_OSOBA);
        user.setName("Tedy Kooreal");
        user.setIdentifier("1518112");
        user.setPhone("0948789875");
        user.setEmail("t@t.t");
        user.setEcv("AA487A");
        user.setWeightOfCar(2.5f);
        user.setFactoryBrand("Škoda škoda");
        users.add(user);
    }

    public UserEntity getByLoginAndPassword(String login, String password) {
        return users.stream().filter(it -> it.getLogin().equals(login) && it.getPassword().equals(password)).findFirst().orElse(null);
    }

    public boolean userExistById(int id) {
        return getUserById(id) != null;
    }

    public UserEntity getUserById(int id) {
        return users.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
    }

    public List<UserEntity> getAll;


}
