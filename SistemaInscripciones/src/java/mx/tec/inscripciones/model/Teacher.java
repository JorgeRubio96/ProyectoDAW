package mx.tec.inscripciones.model;

import mx.tec.inscripciones.PasswordStorage;

public class Teacher {
    private int id;
    private String nomina;
    private String firstName;
    private String lastName;
    private String email;
    
    public Teacher(int id, String nomina, String firstName, String lastName, String email) {
        this.id = id;
        this.nomina = nomina;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
        
    public Teacher(String nomina, String firstName, String lastName, String email) {
        this(-1, nomina, firstName, lastName, email);
    }
    
    public int getId() {
        return id;
    }

    public String getNomina() {
        return nomina;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNomina(String nomina) {
        this.nomina = nomina;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
