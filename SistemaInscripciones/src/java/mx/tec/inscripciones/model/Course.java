/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tec.inscripciones.model;

import java.util.List;

/**
 *
 * @author inspiron
 */
public class Course {
    private int id;
    private String code;
    private String title;
    private int dependId;
    private boolean honors;
    
    public Course(int id, String code, String title, int dependId, boolean honors) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.dependId = dependId;
        this.honors = honors;
    }
    
    public Course(String code, String title, int dependId, boolean honors) {
        this(-1, code, title, dependId, honors);
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
    
    public void setDepend(int dependId){
        this.dependId = dependId;
    }

    public int getDepend(){
        return dependId;
    }
    
    public boolean getHonors() {
        return honors;
    }

    public void getHonors(boolean honors) {
        this.honors = honors;
    }

    public void setGroupNumber(boolean honors) {
        this.honors = honors;
    }
}
