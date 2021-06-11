package com.app.attndrmobile.edetail;

public class EventDetail
{
    String eventName;
    String speakerName;
    String location;
    String date;
    String time;

    public EventDetail(String eventName, String speakerName, String location, String date, String time)
    {
        this.eventName = eventName;
        this.speakerName = speakerName;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    public String getEventName() {
        return eventName;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
