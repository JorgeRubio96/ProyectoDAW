package mx.tec.inscripciones.model;

import java.sql.Time;

public class TimeSlot {
    int id;
    private Time startTime;
    private Time endTime;
    private String day;
    private int classroomId;

    public TimeSlot(int id, Time startTime, Time endTime, String day, int classroomId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.classroomId = classroomId;
    }
    
    public TimeSlot(String startTime, String endTime, String day, int classroomId) {
        this(-1, Time.valueOf(startTime), Time.valueOf(endTime), day, classroomId);
    }
    
    public Time getStartTime() {
        return startTime;
    }
    
    public Time getEndTime() {
        return endTime;
    }
    
    public String getDay() {
        return day;
    }
    
    public int getClassroomId() {
        return classroomId;
    }
   
    
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    
    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }
    
}
