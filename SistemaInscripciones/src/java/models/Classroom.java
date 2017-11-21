package models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author inspiron
 */
public class Classroom {
    private String code;
    private String building;
    private int number;

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
    
    public void setBuilding(String build){
        this.building = build;
    }

    public String getBuilding(){
        return this.building;
    }
    
    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }
}
