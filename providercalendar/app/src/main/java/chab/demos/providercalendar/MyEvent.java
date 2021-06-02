package chab.demos.providercalendar;

import java.util.Calendar;

class MyEvent {
    public MyEvent(long id, String title, String organizer, Calendar calendar, String timeZ){
        this.id = id;
        this.title = title;
        this.orgenizer = organizer;
        this.event_begin = calendar;
        this.timeZ = timeZ;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrgenizer() {
        return orgenizer;
    }

    public void setOrgenizer(String orgenizer) {
        this.orgenizer = orgenizer;
    }

    public Calendar getEvent_begin() {
        return event_begin;
    }

    public void setEvent_begin(Calendar event_begin) {
        this.event_begin = event_begin;
    }
    public String getTimeZ() {
        return timeZ;
    }

    public void setTimeZ(String timeZ) {
        this.timeZ = timeZ;
    }

    public String getDate(){
        return event_begin.getTime().toString();
    }

    private long id;
    private String title;
    private String orgenizer;
    private String timeZ;
    Calendar event_begin;


}
