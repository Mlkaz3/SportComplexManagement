/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author winnieyap
 */
public class SportComplexSystem implements Serializable {
    public static EquipmentManagement equipmentManagement = new EquipmentManagement();
    public static MaintenanceManagement maintenanceMgmt = new MaintenanceManagement();
    public static UsageManagement usageManagement = new UsageManagement();
    public static FacilityManagement facilityManagement = new FacilityManagement();
    public static void main(String[] args) throws ParseException {
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

    private static void Facility() throws ParseException {
        int ch = 0;
        boolean invalidInput;
        do {
            invalidInput = false;
            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("***************************************************");
            System.out.println("*               Facility Management               *");
            System.out.println("*                                                 *");
            System.out.println("*    [1] View available Court                     *");
            System.out.println("*    [2] Add Court                                *");
            System.out.println("*    [3] Remove Court                             *");
            System.out.println("*    [4] Add Reservation                          *");
            System.out.println("*    [5] Remove Reservation                       *");
            System.out.println("*    [6] Back                                     *");
            System.out.println("*                                                 *");
            System.out.println("***************************************************");
            System.out.println();
            try {
                System.out.print("Please select your choice: ");
                ch = input.nextInt();
                System.out.println("");

                switch (ch) {
                    case 1 -> {
                        System.out.println();
                        facilityManagement.displayCourt();

                    }
                    case 2 -> {
                        System.out.println();
                        facilityManagement.addCourt();
                    }
                    case 3 -> {
                        System.out.println();
                        facilityManagement.removeCourt();

                    }
                    case 4 -> {
                        System.out.println();
                        facilityManagement.addReservation();

                    }
                    case 5 -> {
                        System.out.println();
                        facilityManagement.checkOut();

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

    public static void EquipmentManagementMenu() throws ParseException {
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
                System.out.println("*    [2] Clear All Broken Equipment               *");
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
                        equipmentManagement.clearAll();
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
                System.out.println("*    [1] Manage appointments                      *");
                System.out.println("*    [2] Manage maintenance                       *");
                System.out.println("*    [3] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                        manageAppointments();
                    }
                    case 2 -> {
                        manageMaintenance();
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
                System.out.println("Error. Please enter an integer value within 1 and 7.");
            }

        } while (ch != 3);
    }

    public static void manageAppointments() throws ParseException {

        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*               Manage Appointments               *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] View appointments                        *");
                System.out.println("*    [2] Add appointment                          *");
                System.out.println("*    [3] Cancel appointment                       *");
                System.out.println("*    [4] Edit Appointment                         *");
                System.out.println("*    [5] Clear all appointments                   *");
                System.out.println("*    [6] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                        maintenanceMgmt.displayQueue();
                        pressEnterKeyToContinue();
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
                        maintenanceMgmt.clearAll();
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
                System.out.println("Error. Please enter an integer value within 1 and 3.");
            }

        } while (ch != 6);
    }

    public static void manageMaintenance() throws ParseException {

        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                Manage Maintenance               *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] Commence a maintenance                   *");
                System.out.println("*    [2] Complete a maintenance                   *");
                System.out.println("*    [3] View report                              *");
                System.out.println("*    [4] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                        maintenanceMgmt.serveFront();
                    }
                    case 2 -> {
                        maintenanceMgmt.completeMaintenance();
                    }
                    case 3 -> {
                        maintenanceMgmt.viewReport();
                    }
                    case 4 -> {

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

    private static void UsageManagementMenu() throws ParseException {
        int ch = 0;
        do {

            Scanner input = new Scanner(System.in);
            try {

                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                Usage Management                 *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] Booking                                  *");
                System.out.println("*    [2] Overview                                 *");
                System.out.println("*    [3] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                        booking();
                    }

                    case 2 -> {
                        usageManagement.overview();

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

    public static void booking() throws ParseException {
        int ch = 0;
        usageManagement.displayReservation();
        int row = usageManagement.getRow();
        do {
            Scanner in = new Scanner(System.in);
            try {
                if (row == -1) {
                    pressEnterKeyToContinue();
                    break;
                }
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                    Booking                      *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] View Booking Details                     *");
                System.out.println("*    [2] Update Booking                           *");
                System.out.println("*    [3] Delete Booking                           *");
                System.out.println("*    [4] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();
                System.out.print("Please select your choice: ");
                ch = in.nextInt();

                switch (ch) {
                    case 1 -> {
                        viewBooking(row);
                        System.out.println("");
                    }
                    case 2 -> {
                        usageManagement.updateBooking(row);
                        System.out.println("");
                    }
                    case 3 -> {
                        usageManagement.deleteBooking(row);
                        System.out.println("");
                        ch = 4;
                    }
                    case 4 -> {
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 4.");
            }

        } while (ch != 4);

    }

    public static void viewBooking(int row) {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                  View Booking                   *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] View Booking Description                 *");
                System.out.println("*    [2] View Booker Profile                      *");
                System.out.println("*    [3] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();
                System.out.print("Please select your choice: ");
                ch = input.nextInt();
                switch (ch) {
                    case 1 -> {
                        usageManagement.displayBookingDetails(row);
                        pressEnterKeyToContinue();
                    }
                    case 2 -> {
                        usageManagement.filterBookerRecord(row);
                        pressEnterKeyToContinue();
                    }
                    case 3 -> {
                        System.out.println();
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

    public static void pressEnterKeyToContinue() {
        System.out.print("\nPress Enter Key to Continue.");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

}
