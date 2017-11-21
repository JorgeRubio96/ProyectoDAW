package mx.tec.inscripciones.model;

import java.util.List;

public class Class {
    private int id;
    private int courseId;
    private int teacherId;
    private int classroomId;
    private List<TimeSlot> times;
    
    public Class(int id, int courseId, int teacherId, List<TimeSlot> times) {
        this.id = id;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.times = times;
    }
    
    public Class(int courseId, int teacherId, List<TimeSlot> times) {
        this(-1, courseId, teacherId, times);
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setClassroomId(int classroomId){
        this.classroomId = classroomId;
    }

    public int getClassroomId(){
        return classroomId;
    }
    
    public void setCourseId(int courseId){
        this.courseId = courseId;
    }

    public int getCourseId(){
        return courseId;
    }
    
    public void setTeacherId(int teacherId){
        this.teacherId = teacherId;
    }

    public int getTeacherId(){
        return teacherId;
    }
    
    public void setTimes(List<TimeSlot> times){
        this.times = times;
    }

    public List<TimeSlot> getTimes(){
        return times;
    }
    
}
