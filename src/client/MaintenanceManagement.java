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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author YJ
 */
public class MaintenanceManagement { // read and write to file, manage completion

    PriorityQueueInterface<Maintenance> appointmentQueue;
    ListInter<Maintenance> maintenanceHistory = new ArrList<>(); // use of teammate's ADT to store records
    Facility facility; // reference to Facility class
    Scanner userInput = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

    public MaintenanceManagement() {
        appointmentQueue = new LinkedPriorityQueue<>();
    }

    //display
    public void displayQueue() {

//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("queue.txt"));
//            String line = bufferedReader.readLine();
//            while (line != null) {
//                System.out.println(line);
//                line = bufferedReader.readLine();
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        } catch (IOException e) {
//            System.out.println("Failed to read from file.");
//        }
        System.out.println("                                             Maintenance Appointment Queue\n");
        System.out.printf("%-17s %-20s %-30s %-20s %-25s\n", "   Facility ID", "   Maintenance type", "   Maintenance description", "   Required Date", "   Request Timestamp");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println(appointmentQueue);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        if (appointmentQueue.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            System.out.println("======================");
            System.out.println("Current queue size: " + appointmentQueue.getTotalEntry());
            System.out.println("======================");
        }

    }

    //insert appointment
    public void addAppt() throws ParseException {

        Maintenance maintenance = new Maintenance();

        displayQueue();

        System.out.println("\nAdd an appointment -> ");

        //print available facility here dont hard code if possible
        System.out.println("\n          - List of Facilities -         ");
        System.out.println("-----------------------------------------");
        System.out.println("Badminton Court|B001|B002|B003|B004|B005|");
        System.out.println("Tennis Court   |T001|T002|T003|T004|T005|");

        String facilityID;
        boolean validID;
        do {
            System.out.print("\nFacility ID: ");
            facilityID = userInput.nextLine();

            Facility selectedFacility = new Facility();

            int count = 0;
            for (int i = 0; i < Data.court.filledSize(); i++) {
                if (facilityID == null ? Data.court.get(i) == null : facilityID.equals(Data.court.get(i).getFacilityID())) {
                    count = 1;
                    selectedFacility = Data.court.get(i);
                }
            }
            if (count == 0) {
                System.out.println("\nError. Invalid facility ID.");
                validID = false;
            } else {
                maintenance.setFacility(selectedFacility);
                validID = true;
            }
        } while (validID != true);

        System.out.print("Maintenance type: ");
        maintenance.setMaintenanceType(userInput.nextLine());

        System.out.print("Maintenance description: ");
        maintenance.setMaintenanceDesc(userInput.nextLine());

        String date;
        boolean validDate;
        do {
            System.out.print("Date required (yyyy-mm-dd): ");
            date = userInput.nextLine();
            formatter.setLenient(false);
            try {
                Date requiredDate = formatter.parse(date);
                maintenance.setRequiredDate(requiredDate);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("\nInvalid date format.");
                System.out.println();
                validDate = false;
            }
        } while (validDate != true);

        //set date of making appointment
        GregorianCalendar requestDate = new GregorianCalendar();
        Date now = requestDate.getTime();
        maintenance.setRequestDate(now);

        if (appointmentQueue.enqueue(maintenance)) {
            System.out.println("\nAppointment added successfully!");
//            try {
//                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("queue.txt", true));
//                bufferedWriter.write(maintenance.getFacilityID() + ", " + maintenance.getMaintenanceType() + ", " + maintenance.getMaintenanceDesc() + ", " + maintenance.getRequiredDate() + ", " + maintenance.getRequestDate());
//            } catch (IOException e) {
//                System.out.println("Failed to write to file.");
//            }
        }

        pressAnyKeyToContinue();
    }

    //send for maintenance, set maintenance ID
    public void serveFront() {

        Maintenance maintenance = new Maintenance();
        char ch = 0;
        displayQueue();

        if (appointmentQueue.isEmpty()) {
            System.out.println("\nThere is nothing to be removed from queue.");
        } else {

            System.out.println("\nCommence maintenance for the first appointment? (Y/N)");

            boolean validInput = true;
            do {
                try {
                    ch = userInput.next().charAt(0);
                    userInput.nextLine();

                    switch (Character.toUpperCase(ch)) {
                        case 'Y' -> {

                            String maintenanceID = maintenance.getMaintenanceID();
                            maintenance.setMaintenanceID(maintenanceID);

                            int i;
                            for (i = 0; i < Data.court.filledSize(); i++) {
                                if (maintenance.getFacility() == null ? Data.court.get(i) == null : maintenance.getFacility().equals(Data.court.get(i))) {
                                    int index = i;
                                }
                                Data.court.get(i).setStatus(false);
                            }

                            GregorianCalendar startDate = new GregorianCalendar();
                            Date now = startDate.getTime();
                            maintenance.setStartDate(now);

                            maintenance = appointmentQueue.dequeue();
                            maintenanceHistory.add(maintenance);

                            System.out.println("\nFacility is currently undergoing maintenance!");
                            break;
                        }
                        case 'N' -> {
                            break;
                        }
                        default -> {
                            System.out.println();
                            System.out.println("Error. Please select a correct choice.");
                            System.out.println();
                            validInput = true;
                            break;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Error. Please enter Y or N only.");
                    validInput = true;
                }
            } while (validInput != true);
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
            System.out.println("\nCancel an appointment -> ");

            boolean remove;
            boolean valid;

            do {
                int position = 0;
                do {
                    System.out.print("\nEnter your choice: ");
                    String num = userInput.nextLine();

                    try {
                        position = Integer.parseInt(num);
                        if (position <= 0 || position > appointmentQueue.getTotalEntry()) {
                            valid = false;
                            System.out.println("\nError. Appointment not found.");
                        } else {
                            valid = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\nError. Invalid input.");
                        valid = false;
                    }
                } while (valid != true);

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

        if (appointmentQueue.isEmpty()) {
            System.out.println("\nThere is nothing to be edited in the queue.");

        } else {
            System.out.println("\nEdit an appointment -> ");

            boolean valid;
            int position = 0;
            do {
                System.out.print("\nEnter your choice: ");
                String choice = userInput.nextLine();

                try {
                    position = Integer.parseInt(choice);
                    if (position <= 0 || position > appointmentQueue.getTotalEntry()) {
                        valid = false;
                        System.out.println("\nError. Appointment not found.");
                    } else {
                        valid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nError. Invalid input.");
                    valid = false;
                }
            } while (valid != true);

            maintenance = appointmentQueue.getElement(position);

            System.out.println();
            System.out.println("[1] Facility ID             :" + maintenance.getFacility().getFacilityID());
            System.out.println("[2] Maintenance type        :" + maintenance.getMaintenanceType());
            System.out.println("[3] Maintenance description :" + maintenance.getMaintenanceDesc());
            System.out.println("[4] Required date           :" + formatter.format(maintenance.getRequiredDate()));
            System.out.println("[5] Done");

            int num = 0;
            do {
                do {
                    System.out.print("\nSelect a field to edit: ");
                    String field = userInput.nextLine();

                    try {
                        num = Integer.parseInt(field);
                        valid = true;
                    } catch (NumberFormatException e) {
                        System.out.println("\nError. Invalid input.");
                        valid = false;
                    }
                } while (valid != true);

                switch (num) {
                    case 1 -> {

                        String newID;
                        boolean validID;
                        do {
                            System.out.print("\nNew facility ID: ");
                            newID = userInput.nextLine();

                            Facility selectedFacility = new Facility();

                            int count = 0;
                            for (int i = 0; i < Data.court.filledSize(); i++) {
                                if (newID == null ? Data.court.get(i) == null : newID.equals(Data.court.get(i).getFacilityID())) {
                                    count = 1;
                                    selectedFacility = Data.court.get(i);
                                }
                            }
                            if (count == 0) {
                                System.out.println("\nError. Invalid facility ID.");
                                validID = false;
                            } else {
                                maintenance.setFacility(selectedFacility);
                                System.out.println("\nFacility ID updated!");
                                validID = true;
                            }
                        } while (validID != true);
                        break;
                    }
                    case 2 -> {
                        System.out.print("\nNew maintenance type: ");
                        String newType = userInput.nextLine();
                        maintenance.setMaintenanceType(newType);
                        System.out.println("\nMaintenance type updated!");
                        break;
                    }
                    case 3 -> {
                        System.out.print("\nNew maintenance description: ");
                        String newDesc = userInput.nextLine();
                        maintenance.setMaintenanceDesc(newDesc);
                        System.out.println("\nMaintenance description updated!");
                        break;
                    }
                    case 4 -> {
                        String date;
                        boolean validDate;
                        do {
                            System.out.print("\nNew date required (yyyy-mm-dd): ");
                            date = userInput.nextLine();
                            formatter.setLenient(false);
                            try {
                                Date requiredDate = formatter.parse(date);
                                maintenance.setRequiredDate(requiredDate);
                                System.out.println("\nDate required updated!");
                                validDate = true;
                            } catch (ParseException e) {
                                System.out.println("\nInvalid date format.");
                                validDate = false;
                            }
                        } while (validDate != true);
                        break;
                    }
                    case 5 -> {
                        break;
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        break;
                    }
                }
            } while (num != 5);
        }
        pressAnyKeyToContinue();
    }
    //manage completed maintenance (write endDate, set status = true, calcDuration & cost)

    public void manageCompletion() {

        //Maintenance maintenance = new Maintenance();
        printHistory();
        
        System.out.println("\n[1] Complete a maintenance");
        System.out.println("[2] View Report");
        
        
//        GregorianCalendar endDate = new GregorianCalendar();
//        Date now = endDate.getTime();
//        maintenance.setEndDate(now);
//        facility.setStatus(true);
//        maintenance.calcDuration();
//        maintenance.calcCost();
    }

    public void printHistory() {
        System.out.println("                                                Maintenance History\n");
        System.out.printf("%-17s %-20s %-30s %-20s %-25s\n", "   Facility ID", "   Maintenance type", "   Maintenance description", "   Required Date", "   Request Timestamp");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println(maintenanceHistory);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        if (maintenanceHistory.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            System.out.println("======================");
            System.out.println("Total records: " + maintenanceHistory.getfilledSize());
            System.out.println("======================");
        }
    }

    public static void pressAnyKeyToContinue() {
        System.out.print("\nPress Enter key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

}

//    private boolean validID(String facilityID) {
//        return (facilityID.charAt(0) == 'B' || facilityID.charAt(0) == 'T') && facilityID.length() == 4;
//    }
//            if (validID(facilityID) == false) {
//                System.out.println("\nError. Invalid facility ID.");
//            } else {
//                maintenance.setFacilityID(facilityID);
//            }
