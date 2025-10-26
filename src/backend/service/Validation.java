/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.service;


public class Validation {

    public Validation() {
    }
    public static boolean isValidName(String name)
    { return name.matches("^[A-Za-z ]+$");
    }
    
    public static boolean isValidId(String name)
    { return name.matches("^\\d+$");
    }

}
