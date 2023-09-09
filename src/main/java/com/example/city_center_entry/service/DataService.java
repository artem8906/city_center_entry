package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Car;
import com.example.city_center_entry.entity.EmergencyEntry;
import com.example.city_center_entry.entity.Entry;
import com.example.city_center_entry.entity.PointEntryExit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataService {

    private final Map<String, Car> repository = new HashMap<>();

    private final List<Entry> listOfClosedEntryes = new ArrayList<>();

    private final List<Entry> listOfOpenEntryes = new ArrayList<>();

    private final List<Entry> listOfEmergencyEntryes = new ArrayList<>();

    private final List<PointEntryExit> pointEntryExitList = new ArrayList<>();
    private final Map<String, Double> priceList = new HashMap<>();

    //fill list of all entry point
    {
        pointEntryExitList.add(new PointEntryExit(0));
        pointEntryExitList.add(new PointEntryExit(1));
        pointEntryExitList.add(new PointEntryExit(2));
        pointEntryExitList.add(new PointEntryExit(3));
        priceList.put("4b", 5.0);
        priceList.put("4f", 30.0);
        priceList.put("4d", 15.0);

    }
    //add new auto to list allowed to entry
    public Car addNewAuto (Car car) {
        return repository.put(car.getLisencePlate(), car);
    }

    //remove auto from list of allowed to entry
    public Car removeAuto (Car car) {
        return repository.remove(car.getLisencePlate());
    }
    //change lisence plate in list of allowed to entry
    public void changeAuto (String oldPlate, String newPlate, String newOwner, String aimOfEntry) {
        repository.put(oldPlate, new Car(newPlate, newOwner, aimOfEntry));
    }

    // add list of cars to list of allowed cars
    public void addFewCars(List<Car> list) {
        for (Car car : list) {
            repository.put(car.getLisencePlate(), car);
        }
    }

    // get auto from allowed list if exist, if no - return null
    public Car get(String plate) {
        return repository.get(plate);
    }
    //when auto enters it adds entry to list
    public void addOpenEntry(Entry entry) {
        listOfOpenEntryes.add(entry);
    }
    //if auto already entered it return entry, if no - return null
    public Entry getOpenEntry(String lisencePlate) {
        return listOfOpenEntryes.stream().
                filter(e -> e.getAuto().getLisencePlate().equals(lisencePlate))
                .findFirst()
                .get();

    }

    // return PointEntry based on ID
    public PointEntryExit getEntryPoint(int gateID) {
        return pointEntryExitList.get(gateID);
    }

    public void addClosedEntry(Entry entry) {
        listOfClosedEntryes.add(entry);
    }

    public Map<String, Double> getPriceList() {
        return priceList;
    }

    public void addEmergencyEntry(EmergencyEntry emergencyEntry) {
    listOfEmergencyEntryes.add(emergencyEntry);
    }
}
