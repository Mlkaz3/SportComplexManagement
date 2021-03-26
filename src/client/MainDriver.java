/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.Equipment;
import entity.Facility;
import entity.Maintenance;
import entity.ReservationRecord;
import entity.User;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author winnieyap
 */
public class MainDriver {

    public static EquipmentManagement equipmentManagement = new EquipmentManagement();
    public static MaintenanceManagement maintenanceMgmt = new MaintenanceManagement();
    public static UsageManagement usageManagement = new UsageManagement();

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

        User user = new User("Tan Pei Ling", "19119", "Student", "0123456789");
        User user1 = new User("Ting Tin Tin", "19109", "Alumni", "0123456781");
        User user2 = new User("Phea Lee Mai", "18119", "Student", "0123456782");
        User user3 = new User("Lim Siew Mooi", "20119", "Student", "0123456783");
        User user4 = new User("Kenneth", "20109", "Student", "0123456783");

        Equipment equipment = new Equipment("001", "Yoonex", true, 12.00, "Shelf0123", "badminton racquet");
        Equipment equipment1 = new Equipment("002", "Adidas", true, 12.00, "Shelf0122", "squash racquet");
        Equipment equipment2 = new Equipment("003", "MsiaB", true, 12.00, "Shelf0121", "tennis ball");
        Equipment equipment3 = new Equipment("004", "Nike", true, 12.00, "Shelf0120", "badminton racquet");

        DateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        ReservationRecord record1 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 02:01"), (Date) myFormatObj.parse("02/02/2021 03:01"), user, equipment);
        ReservationRecord record2 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 03:11"), (Date) myFormatObj.parse("02/02/2021 04:12"), user1, equipment2);
        ReservationRecord record3 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 10:13"), (Date) myFormatObj.parse("02/02/2021 11:37"), user2, equipment3);
        ReservationRecord record4 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 05:01"), (Date) myFormatObj.parse("02/02/2021 06:00"), user3, equipment3);
        ReservationRecord record5 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 07:01"), (Date) myFormatObj.parse("02/02/2021 10:01"), user4, equipment3);

        usageManagement.addReservation(record1);
        usageManagement.addReservation(record2);
        usageManagement.addReservation(record3);
        usageManagement.addReservation(record4);
        usageManagement.addReservation(record5);

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
                System.out.println("*    [1] View Appointments                        *");
                System.out.println("*    [2] Add Appointment                          *");
                System.out.println("*    [3] Cancel Appointment                       *");
                System.out.println("*    [4] Edit Appointment                         *");
                System.out.println("*    [5] Commence a maintenance                   *");
                System.out.println("*    [6] Complete a maintenance                   *");
                System.out.println("*    [7] View report                              *");
                System.out.println("*    [8] Back                                     *");
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
                        maintenanceMgmt.serveFront();
                    }
                    case 6 -> {
                        maintenanceMgmt.completeMaintenance();
                    }
                    case 7 -> {
                        maintenanceMgmt.viewReport();
                    }
                    case 8 -> {

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

        } while (ch != 8);
    }

//    public static void manageAppt() {
//
//        int ch = 0;
//        do {
//            Scanner input = new Scanner(System.in);
//            try {
//                System.out.println();
//                System.out.println("***************************************************");
//                System.out.println("*               Manage Appointments               *");
//                System.out.println("*                                                 *");
//                System.out.println("*    [1] Send for maintenance                     *");
//                System.out.println("*    [2] Manage completion                        *");
//                System.out.println("*    [3] Back                                     *");
//                System.out.println("*                                                 *");
//                System.out.println("***************************************************");
//                System.out.println();
//
//                System.out.print("Please select your choice: ");
//                ch = input.nextInt();
//
//                switch (ch) {
//                    case 1 ->
//                        maintenanceMgmt.serveFront();
//                    case 2 -> {
//                        System.out.println();
//                        maintenanceMgmt.manageCompletion();
//                    }
//                    case 3 -> {
//                    }
//                    default -> {
//                        System.out.println();
//                        System.out.println("Error. Please select a correct choice.");
//                    }
//                }
//            } catch (InputMismatchException e) {
//                System.out.println();
//                System.out.println("Error. Please enter an integer value within 1 and 3.");
//            }
//
//        } while (ch != 3);
//    }
    private static void UsageManagementMenu() throws ParseException {
        usageManagement.displayReservation();
        //print out the record == Today's record
        int row = usageManagement.getRow();
        usageManagement.displayBookingDetails(row);
        //and read row 
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
                    case 1 -> {
                        //called viewBooking() function in Usage Management
                        usageManagement.viewBooking(row);
                        System.out.println("");
                    }

                    case 2 -> {
                        //called updateBooking() function in Usage Management
                        usageManagement.updateBooking(row);
                        System.out.println("");

                    }
                    case 3 -> {
                        //called deleteBooking() function in Usage Management which pass in the row number and 
                        usageManagement.deleteBooking(row);
                        System.out.println("");

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
