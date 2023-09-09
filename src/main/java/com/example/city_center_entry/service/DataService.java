package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Car;
import com.example.city_center_entry.entity.EmergencyEntry;
import com.example.city_center_entry.entity.Entry;
import com.example.city_center_entry.entity.PointEntryExit;
import org.springframework.stereotype.Component;

import java.util.*;

@Component

public class DataService {

    private final Map<String, Car> repository = new HashMap<>();

    private final List<Entry> listOfClosedEntryes = new ArrayList<>();

    private final List<Entry> listOfOpenEntryes = new ArrayList<>();

    private final List<Entry> listOfEmergencyEntryes = new ArrayList<>();

    private final List<PointEntryExit> pointEntryExitList = new ArrayList<>();
    private final Map<String, Double> priceList = new HashMap<>();

    //fill list for simulate data
    {
        pointEntryExitList.add(new PointEntryExit(0));
        pointEntryExitList.add(new PointEntryExit(1));
        pointEntryExitList.add(new PointEntryExit(2));
        pointEntryExitList.add(new PointEntryExit(3));
        priceList.put("4b", 5.0);
        priceList.put("4f", 30.0);
        priceList.put("4d", 15.0);
        listOfClosedEntryes.add(new Entry(new Car("BA100LS", "MV SK", "4a"), new Date(), pointEntryExitList.get(1)));
        listOfClosedEntryes.add(new Entry(new Car("BA200LS", "MV SK", "4a"), new Date(), pointEntryExitList.get(1)));
        listOfClosedEntryes.add(new Entry(new Car("BA300LS", "MV SK", "4a"), new Date(), pointEntryExitList.get(1)));
        Car car1 = new Car("BA100LS", "MV SK", "4a");
        Car car2 = new Car("BA200LS", "MV SK", "4a");
        Car car3 = new Car("BA300LS", "MV SK", "4a");
        Car car4 = new Car("BA400LS", "MV SK", "4a");
        repository.put(car1.getLisencePlate(), car1);
        repository.put(car2.getLisencePlate(), car2);
        repository.put(car3.getLisencePlate(), car3);
        repository.put(car4.getLisencePlate(), car4);
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

    public Map<String, Car> getRepository() {
        return repository;
    }

    public List<Entry> getListOfClosedEntryes() {
        return listOfClosedEntryes;
    }

    public List<Entry> getListOfOpenEntryes() {
        return listOfOpenEntryes;
    }

    public List<Entry> getListOfEmergencyEntryes() {
        return listOfEmergencyEntryes;
    }

    public List<PointEntryExit> getPointEntryExitList() {
        return pointEntryExitList;
    }
}
