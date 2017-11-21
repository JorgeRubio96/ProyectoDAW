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
public class Class {
    private String classroom, course, teacher;
    private TimeSlot time;
    
    public void setClassroom(String classroom){
        this.classroom = classroom;
    }

    public String getClassroom(){
        return this.classroom;
    }
    
    public void setCourse(String course){
        this.course = course;
    }

    public String getCourse(){
        return this.course;
    }
    
    public void setTeacher(String teacher){
        this.teacher = teacher;
    }

    public String getTeacher(){
        return this.teacher;
    }
    
    public void setTime(TimeSlot time){
        this.time = time;
    }

    public TimeSlot getTime(){
        return this.time;
    }
    
}
