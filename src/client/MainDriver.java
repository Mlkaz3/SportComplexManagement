/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.Facility;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author winnieyap
 */
public class MainDriver {

    public static EquipmentManagement equipmentManagement = new EquipmentManagement();
    public static MaintenanceManagement maintenanceMgmt = new MaintenanceManagement();

    public static void main(String[] args) throws ParseException {

        //hard code faciliies
        Facility badmintonCourt1 = new Facility("B001", "Badmintion Court 1", "Badmintion", true);
        Facility badmintonCourt2 = new Facility("B002", "Badmintion Court 2", "Badmintion", true);
        Facility badmintonCourt3 = new Facility("B003", "Badmintion Court 3", "Badmintion", true);
        Facility badmintonCourt4 = new Facility("B004", "Badmintion Court 4", "Badmintion", true);
        Facility badmintonCourt5 = new Facility("B005", "Badmintion Court 5", "Badmintion", true);
        Facility tennisCourt1 = new Facility("T001", "Tennie Court 1", "Tennis", true);
        Facility tennisCourt2 = new Facility("T002", "Tennie Court 2", "Tennis", true);
        Facility tennisCourt3 = new Facility("T003", "Tennie Court 3", "Tennis", true);
        Facility tennisCourt4 = new Facility("T004", "Tennie Court 4", "Tennis", true);
        Facility tennisCourt5 = new Facility("T005", "Tennie Court 5", "Tennis", true);

        Data.court.add(badmintonCourt1);
        Data.court.add(badmintonCourt2);
        Data.court.add(badmintonCourt3);
        Data.court.add(badmintonCourt4);
        Data.court.add(badmintonCourt5);

        Data.court.add(tennisCourt1);
        Data.court.add(tennisCourt2);
        Data.court.add(tennisCourt3);
        Data.court.add(tennisCourt4);
        Data.court.add(tennisCourt5);

        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO TARUC SPORT COMPLEX");
        System.out.println("");
        MainPage();

    }

    public static void MainPage() throws ParseException {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*               TARUC SPORTS COMPLEX              *");
                System.out.println("*                MANAGEMENT SYSTEM                *");
                System.out.println("*                                                 *");
                System.out.println("*    Select an Option                             *");
                System.out.println("*    [1] Facilities Management                    *");
                System.out.println("*    [2] Equipment Management                     *");
                System.out.println("*    [3] Maintenance Management                   *");
                System.out.println("*    [4] Usage Management                         *");
                System.out.println("*    [5] Exit                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 ->
                        Facility();
                    case 2 -> {
                        System.out.println();
                        EquipmentManagementMenu();
                    }
                    case 3 -> {
                        System.out.println();
                        MaintenanceManagementMenu();
                    }
                    case 4 -> {
                        System.out.println();
                        UsageManagementMenu();
                    }
                    case 5 -> {
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 5.");
            }

        } while (ch != 5);
    }

    private static void Facility() {
        int ch = 0;
        boolean invalidInput;
        do {
            invalidInput = false;
            Scanner input = new Scanner(System.in);

            System.out.println("\nFACILITIES");
            System.out.println("----------");
            System.out.println("1 - View available room");
            System.out.println("2 - Add Court");
            System.out.println("3 - Remove Court");
            System.out.println("4 - Add Reservation");
            System.out.println("5 - Remove Court");
            System.out.println("6 - Quit");
            try {
                System.out.print("Please select your choice: ");
                ch = input.nextInt();
                System.out.println("");

                switch (ch) {
                    case 1 -> {
                        //display function to be code in facility management class

                    }
                    case 2 -> {
                        //add court

                    }
                    case 3 -> {

                    }
                    case 4 -> {

                    }
                    case 5 -> {

                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        System.out.println();
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 3");
                System.out.println();
                invalidInput = true;
            }
        } while (ch != 6 || invalidInput);
    }

    public static void EquipmentManagementMenu() {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*               Equipment Management              *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] View Equipment                           *");
                System.out.println("*    [2] Borrow Equipment                         *");
                System.out.println("*    [3] Return Equipment                         *");
                System.out.println("*    [4] Stock Management                         *");
                System.out.println("*    [5] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                        System.out.println();
                        equipmentManagement.displayStack();
                    }
                    case 2 -> {
                        System.out.println();
                        equipmentManagement.borrowEquipment();
                    }
                    case 3 -> {
                        System.out.println();
                        equipmentManagement.returnEquipment();
                    }
                    case 4 -> {
                        System.out.println();
                        stockManagementMenu();
                    }
                    case 5 -> {
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 5.");
            }

        } while (ch != 5);
    }

    public static void stockManagementMenu() {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                 Stock Management                *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] Stock In                                 *");
                System.out.println("*    [2] Clear All Equipment                      *");
                System.out.println("*    [3] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                        System.out.println();
                        equipmentManagement.stockIn();
                    }
                    case 2 -> {
                        System.out.println();
                        equipmentManagement.stockOut();
                    }
                    case 3 -> {
                    }

                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 3.");
            }

        } while (ch != 3);
    }

    public static void MaintenanceManagementMenu() throws ParseException {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*              Maintenance Management             *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] View Appointments                        *");
                System.out.println("*    [2] Add Appointment                          *");
                System.out.println("*    [3] Cancel Appointment                       *");
                System.out.println("*    [4] Edit Appointment                         *");
                System.out.println("*    [5] Manage Appointments                      *");
                System.out.println("*    [6] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                        maintenanceMgmt.displayQueue();
                        MaintenanceManagement.pressAnyKeyToContinue();
                    }
                    case 2 -> {
                        maintenanceMgmt.addAppt();
                    }
                    case 3 -> {
                        maintenanceMgmt.cancelAppt();
                    }
                    case 4 -> {
                        maintenanceMgmt.editAppt();
                    }
                    case 5 -> {
                        manageAppt();
                    }
                    case 6 -> {

                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 5.");
            }

        } while (ch != 6);
    }

    public static void manageAppt() {

        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*               Manage Appointments               *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] Send for maintenance                     *");
                System.out.println("*    [2] Manage completion                        *");
                System.out.println("*    [3] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 ->
                        maintenanceMgmt.serveFront();
                    case 2 -> {
                        System.out.println();
                        maintenanceMgmt.manageCompletion();
                    }
                    case 3 -> {
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 3.");
            }

        } while (ch != 3);
    }

    private static void UsageManagementMenu() {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                  Usage Management               *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] View Booking                             *");
                System.out.println("*    [2] Update Booking                           *");
                System.out.println("*    [3] Delete Booking                           *");
                System.out.println("*    [4] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 ->
                        
                        System.out.println("");
                    case 2 -> {
                        System.out.println();
                        maintenanceMgmt.manageCompletion();
                    }
                    case 3 -> {
                        
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 3.");
            }

        } while (ch != 4);
    }

}
