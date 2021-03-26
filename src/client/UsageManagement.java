/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedList;
import entity.ReservationRecord;
import entity.User;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author winnie <winnieyap20@gmail.com>
 */
public class UsageManagement {

    LinkedList<ReservationRecord> reservationRecord;

    public UsageManagement(LinkedList<ReservationRecord> reservationRecord) {
        this.reservationRecord = reservationRecord;
    }

    public UsageManagement() {
        this.reservationRecord = null;
    }

    public void viewBooking(int row) {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                  View Booking                   *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] View Booking Item                        *");
                System.out.println("*    [2] View Booker Profile                      *");
                System.out.println("*    [3] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 ->
                        //called a function named booking item which sort all the booking item X -->bookingItem()
                        System.out.println("");
                    case 2 -> {
                        //display booker profile with it's booking --> bookerProfile()
                        System.out.println("");

                    }
                    case 3 -> {
                        //back so do ntg
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

    public void updateBooking(int row) {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                  Update Booking                 *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] Extension of booking duration            *");
                System.out.println("*    [2] Modify booking facility/equipment        *");
                System.out.println("*    [3] Update booker information                *");
                System.out.println("*    [4] Alter booking time                       *");
                System.out.println("*    [5] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                        //extension 
                        extendBooking(reservationRecord, row);
                        System.out.println("");
                    }
                    case 2 -> {
                        //modify item
                        System.out.println("");

                    }
                    case 3 -> {
                        //update booker
                        updateBooker(row);
                        System.out.println();

                    }
                    case 4 -> {
                        //alter reservation time
                        System.out.println();

                    }
                    case 5 -> {
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

        } while (ch != 5);
    }

    public void deleteBooking(int row) {
        Scanner input = new Scanner(System.in);
        String deletion;
        //cancel facilities booking at position row
        System.out.println("Deleting this booking...");
        System.out.println("Are you sure you want to permanently delete this booking? (Yes/No)");
        System.out.print("-> ");

        deletion = input.next();
        switch (deletion.toLowerCase()) {
            case "yes" -> {
                reservationRecord.removeAt(row);
                System.out.println(reservationRecord);
            }
            case "no" -> {
                System.out.println("The record is remain in the table.");
            }
            default -> {
                System.out.println("Wrong command.");
            }

        }
    }

    public void updateBooker(int row) {
        Scanner input = new Scanner(System.in);
        //Update booker information
        //get the object to update
        ReservationRecord currentRecord = reservationRecord.getEntry(row);
        User currentUser = currentRecord.getUser();

        System.out.println("double confirm entry: " + currentRecord);

        String user_update;

        System.out.println("Before updation: " + reservationRecord.getEntry(row));
        System.out.println("User Info:" + reservationRecord.getEntry(row).getUser());

        System.out.println("Name: ");
        user_update = input.next();
        currentUser.setUserName(user_update);
        System.out.println("User ID: ");
        user_update = input.next();
        currentUser.setUserID(user_update);
        System.out.println("User Category: ");
        user_update = input.next();
        currentUser.setUserCategory(user_update);
        System.out.println("User Contact: ");
        user_update = input.next();
        currentUser.setUserTel(user_update);
        currentRecord.setUser(currentUser);

        //update with replace
        reservationRecord.replace(row, currentRecord);
        System.out.println("After updation: " + reservationRecord.getEntry(row));
        System.out.println("User Info:" + reservationRecord.getEntry(row).getUser());
        System.out.println("Booker Info Successfully Update.");
    }

    public void extendBooking(LinkedList<ReservationRecord> reservationRecord, int row) {

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        DateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Scanner input = new Scanner(System.in);
        long next_starttime = 0;

    }

}
