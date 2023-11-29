package com.mycompany.resturantmanagementsystem_employeemodule;

/**
 *
 * @author Ahmed Ayman
 */
public class EmployeeInfo {
    private static String id;
    private String employeeName;
    private String contactNumber;
    private String employeePosition;
    private double hourlyRate;
    
    EmployeeInfo(String id, String employeeName, String contactNumber, String employeePosition, double hourlyRate){
        EmployeeInfo.id = id;
        this.employeeName = employeeName;
        this.contactNumber = contactNumber;
        this.employeePosition = employeePosition;
        this.hourlyRate = hourlyRate; // Salary per hour
    }
    public static String getID() {
        return id;
    }
    public static void setID(String id) {
        EmployeeInfo.id = id;
    }
    
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    
    public void setContactNuumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    public String getContactNumber(){
        return contactNumber;
    }
    
    public void setEmployeePosition(String employeePosition){
        this.employeePosition = employeePosition;
    }
    public String getEmployeePosition(){
        return employeePosition;
    }
    
    public void setHourlyRate(double hourlyRate){
        this.hourlyRate = hourlyRate;
    }
    public double getHourlyRate(){
        return hourlyRate;
    }
}