/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


public class Employee extends User {

    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String username, String password,
                String department, double salary) {

    super(id, username, password);

    this.department = department;
    this.salary = salary;

    }

    // Getters and Setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Overriding
    @Override
    public void login() {
        System.out.println("Employee logged in successfully.");
    }

    // Employee Methods
    public void requestLeave() {
        System.out.println("Leave requested.");
    }

    public void viewSalary() {
        System.out.println("Salary: " + salary);
    }
}
