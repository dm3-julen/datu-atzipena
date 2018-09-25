/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;

/**
 *
 * @author aitor
 */
public class GestionListaEnMemoria {
    
 //  
    
    public static ObservableList<Person> cargarDatos(){
        
        return FXCollections.observableArrayList(
            new Person("Deviljho", "Wyvern Bruto", "Dragon","Dragon, Rayo, Hielo","-"),
            new Person("Lagiacrus", "Leviathan", "Rayo","Fuego","Rayo"),
            new Person("Nargacuga", "Wivern Volador", "-","Fuego, Rayo","-"),
            new Person("Nergigante", "Dragon Anciano", "-","Rayo, Dragon","Fuego"),
            new Person("Gore Magala", "????", "Dragon","Dragon","-")
        );
    }     
    
//    public static void añadirDato(ObservableList<Person> lista, Person persona){
//        
//        lista.add(persona);
//    }      
//    
    
}
