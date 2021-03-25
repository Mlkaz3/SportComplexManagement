/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ArrList;
import adt.LinkedPriorityQueue;
import adt.ListInter;
import adt.PriorityQueueInterface;
import entity.Facility;
import entity.Maintenance;
import java.io.IOException;
import static java.lang.Character.isDigit;
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
                    case 'Y' -> {
                        appointmentQueue.dequeue();
                        ListInter<Maintenance> maintenanceHistory = new ArrList<>();
                        //maintenanceHistory.add(appointmentQueue.dequeue());
                        GregorianCalendar startDate = new GregorianCalendar();
                        Date now = startDate.getTime();
                        maintenance.setStartDate(now);
                        facility.setStatus(false);

                        System.out.println("Facility is currently undergoing maintenance!");
                    }
                    case 'N' -> {
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        System.out.println();
                    }
                }
            } while (ch != 'N');

            pressAnyKeyToContinue();
        }
    }

    //cancel appointment
    public void cancelAppt() throws ParseException {

        Maintenance maintenance;

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
                    System.out.println("Error. Invalid selection.");
                }

            } while (remove != true);

        }
        pressAnyKeyToContinue();
    }

    //edit appointment details
    public void editAppt() throws ParseException {

        Maintenance maintenance;

        displayQueue();

        System.out.println("\nEdit an appointment - ");

        if (appointmentQueue.isEmpty()) {
            System.out.println("\nThere is nothing to be edited in the queue.");

        } else {

            System.out.print("\nEnter your choice: ");
            String choice = userInput.nextLine();
            int position = Integer.parseInt(choice); //do try catch for this

            maintenance = appointmentQueue.getElement(position);

            System.out.println("\n[1] Facility ID");
            System.out.println("[2] Maintenance type");
            System.out.println("[3] Maintenance description");
            System.out.println("[4] Required date");
            System.out.println("[5] Done");

            int num;
            do {
                System.out.print("\nSelect a field to edit: ");
                String field = userInput.nextLine();
                num = Integer.parseInt(field); //do try catch for this

                switch (num) {
                    case 1 -> {
                        String newID;
                        do {
                            System.out.print("\nNew facility ID: ");
                            newID = userInput.nextLine();
                            
                            if (validID(newID) == false) {
                                System.out.println("Invalid facility ID.");
                            } else {
                                maintenance.setFacilityID(newID);
                                System.out.println("\nFacility ID updated!");
                            }
                        } while (validID(newID) != true);
                        break;
                    }
                    case 2 -> {
                        System.out.print("New maintenance type: ");
                        String newType = userInput.nextLine();
                        maintenance.setMaintenanceType(newType);
                        userInput.nextLine();
                        break;
                    }
                    case 3 -> {
                        System.out.print("New maintenance description: ");
                        String newDesc = userInput.nextLine();
                        maintenance.setMaintenanceDesc(newDesc);
                        userInput.nextLine();
                        break;
                    }
                    case 4 -> {
                        System.out.print("New date required (yyyy-mm-dd): ");
                        String date = userInput.nextLine();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                        Date requiredDate = format.parse(date);
                        maintenance.setRequiredDate(requiredDate);
                        break;
                    }
                    case '5' -> {
                        break;
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        System.out.println();
                        break;
                    }
                }
            } while (num != 5);
        }
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

    public static void pressAnyKeyToContinue() {
        System.out.println("\nPress Enter key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

    public static boolean validID(String facilityID) {
        return !(facilityID.charAt(0) == 'B' && facilityID.charAt(0) == 'T' && facilityID.length() == 4); //
    }
}

//ARE THESE NECCESSARY? --->
//sort in descending order
//    public void sortDesc() {
//        appointmentQueue.desc();
//        System.out.println(appointmentQueue);
//        //turn back
//    }
//
//    public void sortAsc() {
//
//    }
//
//    //check the position of element in the queue
//    private void checkPosition() {
//
//    }
//
//    //check element at the front of the queue
//    private void checkFront() {
//
//    }
