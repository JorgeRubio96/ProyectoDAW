package mx.tec.inscripciones.model;

import mx.tec.inscripciones.PasswordStorage;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    
    public User(int id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
        
    public User(String firstName, String lastName, String username, String password) 
            throws PasswordStorage.CannotPerformOperationException{
        this(-1, firstName, lastName, username, PasswordStorage.createHash(password));
    }
    
    public int getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password)
            throws PasswordStorage.CannotPerformOperationException {
        this.password = PasswordStorage.createHash(password);
    }
}
