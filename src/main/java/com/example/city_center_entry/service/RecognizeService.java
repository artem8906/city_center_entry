package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Auto;

import java.io.File;

public class RecognizeService {
    //external service for recognize plate number
    private static final String urlOfRecognizeService = "https://platerecognizer.com/v1/plate-reader";

    //@Inject bean here
    DataService dataService;

    //@Inject bean here
    BarrierService barrierService;

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
        String recohnizedNumber = "BA100KD";

        Auto auto = dataService.get(recohnizedNumber);
        if (auto != null) {
            barrierService.open(auto, dataService.getEntryPoint(gateID));
        } // auto bolo najdene v zozname povolenych, brana sa otvara
        else {
            //VSTUP NEPOVOLEN lebo auto ne bolo najdene v zozname povolenych
            // brana sa zostava zatvorena a informuje o tom
            barrierService.stayClosed();
        }
    }
}
