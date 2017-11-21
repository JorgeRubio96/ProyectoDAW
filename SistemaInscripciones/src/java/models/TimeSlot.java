/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author inspiron
 */
import java.sql.Time;

public class TimeSlot {
    private Time startTime;
    private Time endTime;
    private String day;

    public TimeSlot(String startTime, String endTime, String day) {
        startTime += ":00";
        endTime += ":00";
        this.startTime = Time.valueOf(startTime);
        this.endTime = Time.valueOf(endTime);
        this.day = day;
    }
}
