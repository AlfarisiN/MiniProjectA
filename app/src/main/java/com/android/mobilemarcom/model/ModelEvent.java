package com.android.mobilemarcom.model;

/**
 * Created by Irfan Naufal Ridi on 24/10/2018.
 */

public class ModelEvent {

    String eventCode,eventName,eventStartDate,eventStatus;

    public ModelEvent(String eventCode, String eventName, String eventStartDate, String eventStatus) {
        this.eventCode = eventCode;
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventStatus = eventStatus;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }
}
