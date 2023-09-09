package com.example.city_center_entry.listeners;

import com.example.city_center_entry.entity.EmergencyEntry;
import com.example.city_center_entry.events.EmergencyEvent;
import com.example.city_center_entry.service.BarrierService;
import com.example.city_center_entry.service.DataService;
import com.example.city_center_entry.service.RecognizeService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.io.File;

public class EmergencyListener implements ApplicationListener<EmergencyEvent> {

    //@Inject
    BarrierService barrierService;

    //@Inlect
    DataService dataService;

    //@Inject
    RecognizeService recognizeService;

        @Override
        public void onApplicationEvent(EmergencyEvent emergencyEvent) {
            barrierService.openInEmergencyCase();
            File file = null; int idBarrier = 0;//request here image from camera system
            EmergencyEntry emergencyEntry = new EmergencyEntry(recognizeService.recognize(file, idBarrier), dataService.getEntryPoint(idBarrier));
            dataService.addEmergencyEntry(emergencyEntry);

        }

}
