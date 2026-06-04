/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.Reportable;

public class HRManager extends Employee implements Reportable {

    // Constructor
    public HRManager(int id, String username, String password,
                     String department, double salary) {

        super(id, username, password, department, salary);
    }

    // Overriding Method
    @Override
    public void login() {
        System.out.println("HR Manager logged in successfully.");
    }

    // Interface Method
    @Override
    public void generateReport() {
        System.out.println("HR Report Generated.");
    }

    // HR Methods
    public void manageAttendance() {
        System.out.println("Attendance Managed.");
    }

    public void approveLeave() {
        System.out.println("Leave Approved.");
    }
}

/**
 *
 * @author hp
 */

    

