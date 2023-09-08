package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Car;
import com.example.city_center_entry.entity.Entry;

import java.io.File;
import java.util.Date;

public class RecognizeService {
    //external service for recognize plate number
    private static final String urlOfRecognizeService = "https://platerecognizer.com/v1/plate-reader";

    //@Inject bean here
    DataService dataService;

    //@Inject bean here
    BarrierService barrierService;

    //@Inject bean here
    BillService billService;

    //    REQUEST
//# Get an image
//    curl -o /tmp/car.jpg https://platerecognizer.com/static/demo.jpg
//# Call the API
//    curl -F 'upload=@/tmp/car.jpg'   -H 'Authorization: Token 123456'   https://platerecognizer.com/v1/plate-reader
//    RESPONSE
//    {"filename": "car.jpg",
//            "results": [{
//        "box": {
//            "xmin": 12, "ymin": 84, "ymax": 168, "xmax": 380},
//        "plate": "123456",
//                "score": 0.90 }]
//    }
    // recognize plate number from image file send by camera with id of gate
    public void recognize(File file, int gateID) {
        String recognizedNumber = "BA100KD";

        Car car = dataService.get(recognizedNumber);

        if (car != null) { //autu vstup povoleny
            if (dataService.getOpenEntry(recognizedNumber)==null) { //vstup do centra
            barrierService.openForEntry(car, dataService.getEntryPoint(gateID)); // brana sa otvara
        }
            else { //vystup z centra
            Entry entry = dataService.getOpenEntry(recognizedNumber);
            entry.setDateOfExit(new Date());
            entry.setPointExit(dataService.getEntryPoint(gateID));
            dataService.addClosedEntry(entry);
            barrierService.openForExit();
            billService.createAndSendBill(entry.getAuto());
        }
        }
        else {
            //VSTUP NEPOVOLEN lebo auto ne bolo najdene v zozname povolenych
            // brana sa zostava zatvorena a informuje o tom
            barrierService.stayClosed();
        }
    }
}
