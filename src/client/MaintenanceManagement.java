/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedPriorityQueue;
import adt.PriorityQueueInterface;
import entity.Facility;
import entity.Maintenance;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author YJ
 */
public class MaintenanceManagement { //read and write to file

    PriorityQueueInterface<Maintenance> appointmentQueue;
    //Reference to andrew's list adt
    Facility facility;
    Scanner userInput = new Scanner(System.in);

    public MaintenanceManagement() {
        appointmentQueue = new LinkedPriorityQueue<>();
    }

    //display
    public void displayQueue() {
        System.out.println("                                            Maintenance Appointment Queue\n");
        System.out.printf("%-10s %-15s %-25s %-20s %-30s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Required Date | ", "Request Timestamp");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println(appointmentQueue);
        System.out.println("");

        if (appointmentQueue.isEmpty()) {
            System.out.println("The queue is currently empty.");
        }
    }

    //insert appointment
    public void addAppt() throws ParseException {
        Maintenance maintenance = new Maintenance();

        displayQueue();

        System.out.println("\nAdd an appointment - ");
        
        //print available facility here
            
        System.out.print("\nFacility ID: ");
        maintenance.setFacilityID(userInput.nextLine());
        
        System.out.print("Maintenance type: ");
        maintenance.setMaintenanceType(userInput.nextLine());
        
        System.out.print("Maintenance description: ");
        maintenance.setMaintenanceDesc(userInput.nextLine());
        
        System.out.print("Date required (yyyy-mm-dd): ");
        String date = userInput.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date requiredDate = format.parse(date);
        maintenance.setRequiredDate(requiredDate);

        //set date of making appointment
        GregorianCalendar requestDate = new GregorianCalendar();
        Date now = requestDate.getTime();
        maintenance.setRequestDate(now);

        if (appointmentQueue.enqueue(maintenance)) {
            System.out.println("\nAppointment added successfully!");
        }

        pressAnyKeyToContinue();
    }

    //serve appointment
    public void serveFront() {
        Maintenance maintenance = new Maintenance();
        char ch;
        displayQueue();

        if (appointmentQueue.isEmpty()) {
            System.out.println("\nThere is nothing to be removed from queue.");

        } else {

            System.out.println("\nCommence maintenance for the first appointment? (Y/N)");

            do {
                ch = userInput.next().charAt(0);

                switch (Character.toUpperCase(ch)) {
                    case 'Y':
                        appointmentQueue.dequeue();
                        //write to andrew's list
                        //......
                        GregorianCalendar startDate = new GregorianCalendar();
                        Date now = startDate.getTime();
                        maintenance.setStartDate(now);
                        facility.setStatus(false);

                        System.out.println("Facility is currently undergoing maintenance!");

                        break;
                    case 'N':
                        break;
                    default:
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        System.out.println();
                        break;
                }
            } while (ch != 'N');

            pressAnyKeyToContinue();
        }
    }

    //cancel appointment
    public void cancelAppt() throws ParseException {
        Maintenance maintenance = new Maintenance();

        displayQueue();

        if (appointmentQueue.isEmpty()) {
            System.out.println("\nThere is nothing to be removed from queue.");

        } else {
            System.out.println("\nCancel an appointment - ");
            
            boolean remove = false;
            
            do {

                System.out.print("\nEnter your choice: ");
                int position = userInput.nextInt();
                
                maintenance = appointmentQueue.getElement(position);
                
                remove = appointmentQueue.remove(maintenance);
  
                if (remove == true) {
                    System.out.println("\nAppointment is cancelled.");
                } else {
                    System.out.println("\nPlease ensure all the information of the appointment is entered correctly.");
                }

            } while (remove != true);

        }
        pressAnyKeyToContinue();
    }

    //edit appointment details
    public void editAppt() {
        Maintenance maintenance = new Maintenance();
        //no idea how to do yet
    }

    //manage completed maintenance (write endDate, set status = true, calcDuration & cost)
    public void manageCompletion() {
        Maintenance maintenance = new Maintenance();
        
        GregorianCalendar endDate = new GregorianCalendar();
        Date now = endDate.getTime();
        maintenance.setEndDate(now);
        facility.setStatus(true);
        maintenance.calcDuration();
        maintenance.calcCost();
    }

    //ARE THESE NECCESSARY? --->
    //sort in descending order
    public void sortDesc() {
        appointmentQueue.desc();
        System.out.println(appointmentQueue);
        //turn back
    }

    public void sortAsc() {

    }

    //check the position of element in the queue
    private void checkPosition() {

    }

    //check element at the front of the queue
    private void checkFront() {

    }

    public static void pressAnyKeyToContinue() {
        System.out.println("\nPress Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}

//        System.out.println("[1] Check position");
//        System.out.println("[2] Check front");
//        System.out.println("[3] Check length of queue");
//        System.out.println("[4] Back");
//        
//        System.out.println("Get position of maintenance 1: " + appointmentQueue.getPosition(maintenance));
//        System.out.println("Queue is empty: " + appointmentQueue.isEmpty());
//        System.out.println("Total elements in queue: " + appointmentQueue.getTotalEntry());
//        System.out.println("Element at front: " + appointmentQueue.getFront());
