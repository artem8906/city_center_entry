package com.example.city_center_entry.repository;

import com.example.city_center_entry.entity.EntryRequestEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntryRequestRepository {
    private static int autoincremment = 1;
    private List<EntryRequestEntity> requests;

    private EntryRequestRepository() {
        requests = new ArrayList<>();
    }

    public List<EntryRequestEntity> getAllByUserId(int userId) {
        return requests.stream().filter(it -> it.getUser().getId() == userId).collect(Collectors.toList());
    }

    public EntryRequestEntity save(EntryRequestEntity entity) {
        entity.setId(autoincremment);
        autoincremment++;
        requests.add(entity);
        return entity;
    }
}
