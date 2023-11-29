package com.mycompany.resturantmanagementsystem_employeemodule;

/**
 *
 * @author Ahmed Ayman
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ManageCustomer {
     File customerFile = new File("customers.txt");
    public void addCustomer() {    
        try {
            try (FileWriter fileWriter = new FileWriter(customerFile, true)) {
                Scanner scanner = new Scanner(System.in);
                
                System.out.println("Enter customer ID: ");
                String newCustomerId = scanner.nextLine();
                if (!customerExists(newCustomerId)) {
                    System.out.println("Enter customer name: ");
                    String newCustomerName = scanner.nextLine();

                    System.out.println("Enter customer contact number: ");
                    String newCustomerContactNumber = scanner.nextLine();

                    if (newCustomerContactNumber.length() >= 4 && newCustomerContactNumber.length() <= 15) {
                        fileWriter.write(newCustomerId + "," + newCustomerName + "," + newCustomerContactNumber + "\n");

                        System.out.println("Customer added successfully!");
                    } else {
                        System.out.println("Contact number must be between 4 and 15 characters. Customer not added.");
                    }
                } else {
                    System.out.println("Customer with the same ID already exists. Cannot add a duplicate customer.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private boolean customerExists(String newCustomerId) {
        try {
            try (FileReader fileReader = new FileReader(customerFile)) {
                Scanner scanner = new Scanner(fileReader);
                
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] fields = line.split(",");
                    String existingCustomerId = fields[0];
                    
                    if (existingCustomerId.equals(newCustomerId)) {
                        fileReader.close();
                        return true;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
     public void deleteCustomer() {
        try {
            File Temporary = new File("temporary.txt");

            FileWriter fileWriter;
            boolean customerFound;
            try (FileReader fileReader = new FileReader(customerFile)) {
                fileWriter = new FileWriter(Temporary);
                Scanner inputScanner = new Scanner(System.in);
                System.out.println("Enter customer ID to delete:");
                String customerIdDelete = inputScanner.next();
                customerFound = false;
                try (Scanner scanner = new Scanner(fileReader)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] fields = line.split(",");
                        String existingCustomerId = fields[0];
                        
                        if (existingCustomerId.equals(customerIdDelete)) {
                            customerFound = true;
                            System.out.println("Customer found and deleted.");
                        } else {
                            fileWriter.write(line + "\n");
                        }
                    }
                }
                fileReader.close();
            }
            fileWriter.close();

            if (!customerFound) {
                System.out.println("Customer with specified ID does not exist.");
            } else {
                customerFile.delete();
                Temporary.renameTo(customerFile);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
     
     public void updateCustomer(String oldCustomer, String newCustomer){
        String content = "";
        String line;
        try {
            try (Scanner update = new Scanner(customerFile);
                 Scanner input = new Scanner(System.in)) {
                System.out.println("Enter old customer name: ");
                oldCustomer = input.nextLine();

                System.out.println("Enter new customer name: ");
                
                newCustomer = input.nextLine();

                while(update.hasNextLine()){
                    line = update.nextLine();
                    String[] data = line.split(",");
                    for(int i=0;i<data.length;i++){
                        if(data[i].contains(oldCustomer) || oldCustomer.equals(String.valueOf(data[i]))){
                            content += newCustomer +",";
                        }
                        else
                            content += data[i] + ",";
                    }
                    content += "\n";
                }
                update.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            try (FileWriter filler = new FileWriter(customerFile, false)) {
                filler.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
     }
     
     public String customerSearch(String customerName){
          String line;
        String result = "";
        try {
              try (Scanner input = new Scanner(customerFile);
                   Scanner IDInput = new Scanner(System.in)) {
                  System.out.println("Enter customer ID you want to search: ");
                  String customerInput = IDInput.next();

                  while (input.hasNextLine()) {
                      line = input.nextLine();
                      String[] data = line.split(",");
                      int id = Integer.parseInt(data[0]);
                      if (customerName.equals(String.valueOf(id)) || data[1].contains(customerInput)) {
                          for (int i = 0; i < data.length; i++) {
                              result += data[i];
                          }
                          return result;
                      }
                  } }
            return null;
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
     
     public void customerList(){
         try {
             try (Scanner input = new Scanner(customerFile)) {
                 while (input.hasNextLine()) {
                     String line = input.nextLine();
                     String[] data = line.split(",");
                     // Assuming data[] contains information in the order: ID, Name, ContactNumber
                     int id = Integer.parseInt(data[0]);
                     String name = data[1];
                     String contactNumber = data[2];
                     
                     // Process or display the information as needed
                     System.out.println("Customer ID: " + id);
                     System.out.println("Name: " + name);
                     System.out.println("Contact Number: " + contactNumber);
                     System.out.println("===================================");
                     System.out.println();
                 }
                 input.close();
             }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}   