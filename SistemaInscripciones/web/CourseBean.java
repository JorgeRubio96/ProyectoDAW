/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author avm
 */
import java.io.Serializable;

public class CourseBean implements Serializable {
  
  private String codigo;
  private String nombre;
  private boolean honores;
  
  //Constructor default del bean
  public CourseBean(){
    nombre= "";
    codigo= "";
    honores= false;
  }

  //get para nombre
  public String getNombre(){
    return nombre;
  }
  
  //get para codigo
  public String getCodigo(){
    return codigo;
  }
  
  //get para honores
  public boolean getHonores(){
    return honores;
  }
  
  //set para nombre
  //@param: String n -> el nuevo nombre
  public void setNombre(String n){
    nombre= n;
  }
  
  //set para codigo
  //@param: String c -> el nuevo codigo
  public void setCodigo(String c){
    codigo= c;
  }
  
  //set para honores
  //@param: boolean h -> el nuevo valor de honores
  public void setHonores(boolean h){
    honores= h;
  }
  
}
