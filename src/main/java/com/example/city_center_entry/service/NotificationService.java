package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Auto;
import com.example.city_center_entry.entity.Entry;


public class NotificationService {

    public void notifyAdminAboutNewRequestForAddCar(Auto auto) {
        //notify admin about request for add new car
    }

    public void notifyEntry(Entry entry) {
        //notify owner about entry and obligation to pay a bill

    }

    public void notifyLongDurationStay(Entry entry) {
        //if car was more then particular time in city center, it notify user and admin and may send a fee for it
//        if ( entry.getDateOfExit().getTime() - entry.getDateOfEntry().getTime())  > // send message }
    }

    public void notifyChangeInOutPoint(Entry entry) {
        //notify if auto in and out using different entry points and may send a fee for it
            if (entry.getPointExit()!=entry.getPointEntry()) return;// send message
    }

    public void notifyPolice(Entry entry) {
        //notify police
    }


}
