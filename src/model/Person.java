/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author aitor
 */

public class Person {
        
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;
    private final SimpleStringProperty weakness;
    private final SimpleStringProperty endure;
    
    public Person(String fName, String lName, String email, String weakness, String endure) { //derrigortuta nago, ezta? public jartzera beste pakete batetik sortuko dudalako?
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
        this.weakness = new SimpleStringProperty(weakness);
        this.endure = new SimpleStringProperty(endure);
    }
    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String fName) {
        lastName.set(fName);
    }
    public String getEmail() {
        return email.get();
    }
    public void setEmail(String fName) {
        email.set(fName);
    }

    public void setWeakness(String fName) {
        weakness.set(fName);
    }
    
    public String getWeakness() {
        return weakness.get();
    }
    
    public void setEndure(String fName) {
        endure.set(fName);
    }
    
    public String getEndure() {
        return endure.get();
    }
}