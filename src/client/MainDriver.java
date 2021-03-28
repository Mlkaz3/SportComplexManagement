/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedList;
import entity.Equipment;
import entity.Facility;
import entity.ReservationRecord;
import entity.User;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author winnieyap
 */
public class MainDriver implements Serializable {

    public static EquipmentManagement equipmentManagement = new EquipmentManagement();
    public static MaintenanceManagement maintenanceMgmt = new MaintenanceManagement();
    public static UsageManagement usageManagement = new UsageManagement();
    public static FacilityManagement facilityManagement = new FacilityManagement();

    public static void main(String[] args) throws ParseException {

        //hard code faciliies
        Facility badmintonCourt1 = new Facility("B001", "Badmintion Court 1", "Badmintion", true);
        Facility badmintonCourt2 = new Facility("B002", "Badmintion Court 2", "Badmintion", true);
        Facility badmintonCourt3 = new Facility("B003", "Badmintion Court 3", "Badmintion", true);
        Facility badmintonCourt4 = new Facility("B004", "Badmintion Court 4", "Badmintion", true);
        Facility badmintonCourt5 = new Facility("B005", "Badmintion Court 5", "Badmintion", true);
        Facility tennisCourt1 = new Facility("T001", "Tennis Court 1", "Tennis", true);
        Facility tennisCourt2 = new Facility("T002", "Tennis Court 2", "Tennis", true);
        Facility tennisCourt3 = new Facility("T003", "Tennis Court 3", "Tennis", true);
        Facility tennisCourt4 = new Facility("T004", "Tennis Court 4", "Tennis", true);
        Facility tennisCourt5 = new Facility("T005", "Tennis Court 5", "Tennis", true);

        facilityManagement.add(badmintonCourt1);
        facilityManagement.add(badmintonCourt2);
        facilityManagement.add(badmintonCourt3);
        facilityManagement.add(badmintonCourt4);
        facilityManagement.add(badmintonCourt5);

        facilityManagement.add(tennisCourt1);
        facilityManagement.add(tennisCourt2);
        facilityManagement.add(tennisCourt3);
        facilityManagement.add(tennisCourt4);
        facilityManagement.add(tennisCourt5);

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
//        ReservationRecord record1 = new entity.ReservationRecord((Date) myFormatObj.parse("27/03/2021 19:01"), user, equipment);
//        ReservationRecord record2 = new entity.ReservationRecord((Date) myFormatObj.parse("27/03/2021 20:12"), user1, equipment2);
//        ReservationRecord record3 = new entity.ReservationRecord((Date) myFormatObj.parse("27/03/2021 23:37"), user2, equipment3);
//        ReservationRecord record4 = new entity.ReservationRecord((Date) myFormatObj.parse("27/03/2021 18:40"), user3, equipment3);
//        ReservationRecord record5 = new entity.ReservationRecord((Date) myFormatObj.parse("27/03/2021 07:01"), user4, equipment3);

//        usageManagement.addReservation(record1);
//        usageManagement.addReservation(record2);
//        usageManagement.addReservation(record3);
//        usageManagement.addReservation(record4);
//        usageManagement.addReservation(record5);
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
                        overview();

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

    public static void overview() {
        System.out.println("");
        System.out.println("");
        System.out.println("*".repeat(135));
        System.out.println("Summary");
        LinkedList<ReservationRecord> equipment = usageManagement.filterEquipmentRecord();
        LinkedList<ReservationRecord> facility = usageManagement.filterFacilitiesRecord();
        System.out.println("\nBorrow Record for Equipment");
        if (equipment.getLength() == 0) {
            System.out.println("--------------------------------");
            System.out.println("No equipment booking record yet");
            System.out.println("--------------------------------");
        } else {
            usageManagement.displayHeading();
            System.out.println(equipment);
        }
        System.out.println("\nBorrow Record for Facility");
        if (facility.getLength() == 0) {
            System.out.println("------------------------------");
            System.out.println("No facility booking record yet");
            System.out.println("------------------------------");
        } else {
            usageManagement.displayHeading();
            System.out.println(facility);
        }
        System.out.println("*".repeat(135));
        System.out.println("");
        System.out.println("");
        pressEnterKeyToContinue();

    }

    public static void pressEnterKeyToContinue() {
        System.out.print("\nPress Enter Key to Continue.");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

}
