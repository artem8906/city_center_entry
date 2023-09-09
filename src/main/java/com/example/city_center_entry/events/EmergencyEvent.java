package com.example.city_center_entry.events;

import org.springframework.context.ApplicationEvent;

public class EmergencyEvent extends ApplicationEvent {

        public EmergencyEvent(Object source) {
            super(source);
        }
}
