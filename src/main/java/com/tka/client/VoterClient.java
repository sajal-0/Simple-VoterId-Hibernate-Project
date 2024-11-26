package com.tka.client;

import java.util.List;

import java.util.Scanner;

import com.tka.controller.VoterController;
import com.tka.entity.Person;


public class VoterClient {
    public static void main(String[] args) {
    	VoterController con = new VoterController();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- Voter Management Menu -----");
            System.out.println("1. View All Persons");
            System.out.println("2. View Persons by Name");
            System.out.println("3. View Persons by City");
            System.out.println("4. View Persons by Constituency");
            System.out.println("5. Insert New Persons");
            System.out.println("6. Delete a Person");
            System.out.println("7. Update a Person");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printTable(con.allPersons());
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    printTable(con.listByname(name));
                    break;

                case 3:
                    System.out.print("Enter City: ");
                    String city = scanner.next();
                    printTable(con.listByCity(city));
                    break;

                case 4:
                    System.out.print("Enter Constituency: ");
                    String constituency = scanner.next();
                    printTable(con.listByContituency(constituency));
                    break;

                case 5:
                    printTable(con.insertPerson());
                    break;

                case 6:
                    System.out.print("Enter Aadhar Number to Delete: ");
                    int deleteAadhar = scanner.nextInt();
                    printTable(con.deleteCandidate(deleteAadhar));
                    break;

                case 7:
                    System.out.print("Enter Aadhar Number to Update: ");
                    int updateAadhar = scanner.nextInt();
                    printTable(con.updatePerson(updateAadhar));
                    break;

                case 8:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }

  
    private static void printTable(List<Person> persons) {
        if (persons == null || persons.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.printf("%-10s %-15s %-15s %-20s %-15s\n", "Aadhar", "Name", "City", "Constituency", "Voter ID");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Person person : persons) {
            System.out.printf("%-10d %-15s %-15s %-20s %-15s\n",
                    person.getAadhar_no(),
                    person.getName(),
                    person.getAddress().getCityName(),
                    person.getVoterId().getConstituency(),
                    person.getVoterId().getVoter_id());
        }
    
        System.out.println("-------------------------------------------------------------------------------------");
        
    }
}
