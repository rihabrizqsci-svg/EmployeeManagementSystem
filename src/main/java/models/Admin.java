/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package models;

public class Admin extends User {

    // Constructor
    public Admin(int id, String username, String password) {
        super(id, username, password);
    }

    // Overriding Method
    @Override
    public void login() {
        System.out.println("Admin logged in successfully.");
    }

    // Admin Methods
    public void addEmployee() {
        System.out.println("Employee added.");
    }

    public void deleteEmployee() {
        System.out.println("Employee deleted.");
    }

    public void generateReport() {
        System.out.println("Report generated.");
    }
}

