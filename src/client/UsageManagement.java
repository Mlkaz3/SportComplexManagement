/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedList;
import entity.Equipment;
import entity.ReservationRecord;
import entity.User;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author winnie <winnieyap20@gmail.com>
 */
public class UsageManagement {

    LinkedList<ReservationRecord> reservationRecord;
    Scanner input = new Scanner(System.in);
    

    public UsageManagement() {
        this.reservationRecord = new LinkedList<>();
    }

    public void addReservation(ReservationRecord record) {
//        //checking to ensure the duration does not more than 2 hours 
//        if (record.getReservationDuration() > 2) {
//            return "The maximum hour to use an equipment/facilities is 2 hours only";
//        } else {
//           
//        }
//
//        return "Booking added successfully.";
        reservationRecord.addLast(record);

    }

    public void displayReservation() {
        System.out.println("");
        System.out.println("Today's Bookings");
        System.out.println(String.format("%-2s %-40s %-15s %-20s %-20s %-20s %-10s", "No.",
                "Booking", "Status", "From", "To", "Date", "UserID"));
        //System.out.println(reservationRecord);

        Iterator<ReservationRecord> iterator = reservationRecord.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public void viewBooking(int row) {
        int ch = 0;
        do {
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
                    case 1 -> {
                        displayBookingItem(row);
                    }
                    case 2 -> {
                        //display booker profile with it's booking --> bookerProfile()
                        filterBookerRecord(row);

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

    public void updateBooking(int row) throws ParseException {
        int ch = 0;
        do {
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
                        alterBookingDateTime(row);
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

    //success
    public void extendBooking(LinkedList<ReservationRecord> reservationRecord, int row) throws ParseException {
        DecimalFormat df = new DecimalFormat("#.####"); //4sf
        df.setRoundingMode(RoundingMode.FLOOR);
        DateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Scanner input = new Scanner(System.in);
        long next_starttime = 0;

        ReservationRecord currentRecord = reservationRecord.getEntry(row); //record to be alter
        LinkedList<ReservationRecord> bookingitems; //is the list of items that have l;
        bookingitems = filterRecord(reservationRecord, currentRecord);
        LinkedList<ReservationRecord> sortedBookings = SortDateTime(bookingitems); //sorted list

        int new_row = sortedBookings.getPosition(currentRecord); //get the current booking to update in sortedBookings
        ReservationRecord comingBooking; //refer to next booking
        double diff_hours = 0.0;
        double extend_duration;
        String end_time;
        Date endDate;

        boolean loop = false;
        System.out.println("Extension");
        do {
            System.out.print("New End Time(dd/MM/yyyy HH:mm) :");
            end_time = input.nextLine();
            endDate = (Date) myFormatObj.parse(end_time);

            long datediff = endDate.getTime() - currentRecord.getReservationEndTime().getTime();
            if ((datediff / (1000 * 60 * 60)) % 24 > 2) {
                System.out.println("Maximum time allow to extend is only 2 hours.");
            } else if (new_row + 1 <= sortedBookings.getLength()) { //there is a next row
                comingBooking = sortedBookings.getEntry(new_row + 1);
                //System.out.println("compare updatedate with next reservation " + endDate.compareTo(comingBooking.getReservationStartTime()));
                if (endDate.compareTo(comingBooking.getReservationStartTime()) > 0) {
                    System.out.println("The updation is clash with next booking");
                } else {
                    loop = true;
                }
            } else {
                loop = true;
            }

        } while (loop == false);

        System.out.println("Booking successfully extended.");
        //here need to update booking table/record
        currentRecord.setReservationEndTime(endDate);
        reservationRecord.replace(row, currentRecord);
    }

    public int getRow() {
        //enable staff to choose a row to perform actions
        int row = 0;
        do {
            try {
                System.out.print("Please select a row to perform actions: ");
                row = input.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Not an valid choice, please try again.");
                if (input.next().isEmpty()) {
                    break;
                }
            }
        } while (row < 1 || row > reservationRecord.getLength()); //validate the row input, make sure it is not larger than the list size
        return row;
    }

    private void displayBookingItem(int row) {
        ReservationRecord currentRecord = reservationRecord.getEntry(row); //record to be alter
        LinkedList<ReservationRecord> bookingitems; //is the list of items that have l;
        bookingitems = filterRecord(reservationRecord, currentRecord);
        bookingitems = SortDateTime(bookingitems);
        System.out.println(bookingitems);
    }

    private static LinkedList<ReservationRecord> filterRecord(LinkedList<ReservationRecord> reservationRecord, ReservationRecord currentRecord) {
        LinkedList<ReservationRecord> bookingitems = new LinkedList<>(); //is the list of items that have l;
        Iterator<ReservationRecord> newiterator = reservationRecord.getIterator();
        String booking_item; //booking exact item (to sort a list based on the item) 
        String type = currentRecord.getReservationType(); //get the type
        if ("Facilities".equals(type)) {
            //get the booking items
            booking_item = currentRecord.getFacilities().getFacilityID();

            while (newiterator.hasNext()) {
                ReservationRecord record = newiterator.next();

                if (record.getFacilities().getFacilityID() == booking_item) {
                    bookingitems.addFirst(record);
                }
            }
        } else {
            booking_item = currentRecord.getEquipments().getEquipmentID();

            while (newiterator.hasNext()) {
                ReservationRecord record = newiterator.next();

                if (record.getEquipments().getEquipmentID() == booking_item) {
                    bookingitems.addFirst(record);
                }
            }
        }
        return bookingitems;
    }

    public LinkedList<ReservationRecord> filterBookerRecord(int row) {
        LinkedList<ReservationRecord> bookerRecord = new LinkedList<>(); //list to store the booking record for user 
        Iterator<ReservationRecord> newiterator = reservationRecord.getIterator();
        ReservationRecord currentRecord = reservationRecord.getEntry(row);
        String user_id = currentRecord.getUser().getUserID();

        while (newiterator.hasNext()) {
            ReservationRecord record = newiterator.next();

            if (record.getUser().getUserID() == null ? user_id == null : record.getUser().getUserID().equals(user_id)) {
                bookerRecord.addFirst(record);
            }
        }

        return bookerRecord;
    }

    public Equipment getBookingEquipment(String id) {
        //System.out.println("id" + id);
        Equipment bookingitem = new Equipment();
        //get the booking item by searching 
        Iterator<ReservationRecord> itemIterator = reservationRecord.getIterator();
        while (itemIterator.hasNext()) {
            ReservationRecord record = itemIterator.next();
            //System.out.println("looping through" + record.getEquipments());
            if (record.getReservationID() == null ? id == null : record.getReservationID().equals(id)) {
                //System.out.println("id match");
                //System.out.println(record.getReservationID());
                //System.out.println(record.getEquipments());
                bookingitem = record.getEquipments();
                break;
            }
        }
        return bookingitem;
    }

    private static LinkedList<ReservationRecord> SortDateTime(LinkedList<ReservationRecord> toSortList) {
        //Node current will point to head  
        ReservationRecord current;
        ReservationRecord next;
        ReservationRecord temp;
        LinkedList<ReservationRecord> SortedList = toSortList;
        SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for (int i = 1; i < SortedList.getLength() + 1; i++) {
            for (int j = 1; j < SortedList.getLength() + 1; j++) {
                current = SortedList.getEntry(i);
                next = SortedList.getEntry(j);
                if (current.getReservationStartTime().compareTo(next.getReservationStartTime()) < 0) {
                    temp = SortedList.getEntry(j);
//                    SortedList.replace(j, SortedList.getEntry(i));
//                    SortedList.replace(i, temp);
                    SortedList.swap(i, j);
                }
            }
        }
        return SortedList;
    }

    public void displayBookingDetails(int row) {
        System.out.println("");

        System.out.println("-".repeat(80));
        System.out.println("Booking #" + reservationRecord.getEntry(row).getReservationID() + " Details");
        System.out.println("-".repeat(80));

        System.out.println("General Details");
        System.out.println("---------------");
        System.out.println("Booking Creation Date: " + reservationRecord.getEntry(row).getReservationDate());
        System.out.println("Booking Status: "); //status can be pending or success or cancelation

        System.out.println("\nBooking Facilities/Equipment");
        System.out.println("----------------------------");
        System.out.println("Booking Type: " + reservationRecord.getEntry(row).getReservationType());

        if ("Facilities".equals(reservationRecord.getEntry(row).getReservationType())) {
            System.out.println("Booking Item: " + reservationRecord.getEntry(row).getFacilities());
        } else {
            System.out.println("Booking Item: " + reservationRecord.getEntry(row).getEquipments().getEquipmentType());
            System.out.println("Booking Items ID: " + reservationRecord.getEntry(row).getEquipments().getEquipmentID());
            System.out.println("Booking Items Status: " + reservationRecord.getEntry(row).getEquipments().getEquipmentStatus());
        }

        System.out.println("\nBooking Date");
        System.out.println("------------");
        System.out.println("From: " + reservationRecord.getEntry(row).getReservationStartTime());
        System.out.println("To: " + reservationRecord.getEntry(row).getReservationEndTime());
        System.out.println("Duration: " + reservationRecord.getEntry(row).getReservationDuration() + " Hour(s)");

        System.out.println("\nBooker Details");
        System.out.println("--------------");
        System.out.println("Booker ID: " + reservationRecord.getEntry(row).getUser().getUserID());
        System.out.println("Booker Name: " + reservationRecord.getEntry(row).getUser().getUserName());
        System.out.println("Booker Type: " + reservationRecord.getEntry(row).getUser().getUserCategory());
        System.out.println("Booker Tel: " + reservationRecord.getEntry(row).getUser().getUserTel());

        System.out.println("");
        System.out.println("-".repeat(80));
    }

    public void alterBookingDateTime(int row) throws ParseException {
        //validation of new startDate and endDate
        ReservationRecord currentRecord = reservationRecord.getEntry(row); //record to be alter
        ReservationRecord previousRecord;
        ReservationRecord nextRecord;
        LinkedList<ReservationRecord> bookingitems; //is the list of items that have XX items;
        bookingitems = filterRecord(reservationRecord, currentRecord);
        bookingitems = SortDateTime(bookingitems);
        int new_row = bookingitems.getPosition(currentRecord);

        System.out.println(bookingitems);

        Scanner in = new Scanner(System.in);
        String start_date, end_date; //for user imput
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        boolean loop = false;
        do {

            System.out.println("Altering Booking Start Time & End Time ");
            System.out.println("Caution: Enter date time in the format of dd/MM/yyyy HH:mm");
            System.out.print("New Start Time: ");
            start_date = in.nextLine();
            System.out.print("New End Time: ");
            end_date = in.nextLine();
            Date startDate = (Date) format.parse(start_date);
            Date endDate = (Date) format.parse(end_date);

            //ensure it has not exceed current time
            Date currentDate = new Date();
            Date booking_oriDate = currentRecord.getReservationStartTime();
            long datediff = endDate.getTime() - startDate.getTime();

            if (currentDate.compareTo(booking_oriDate) == 1) {
                System.out.println("Alter failed. The booking is either expired or ongoing");
            } else if (datediff < 0) {
                System.out.println("The booking duration is invalid, start time should not greater than end time ");
            } else if ((datediff / (1000 * 60 * 60)) % 24 > 2) {
                System.out.println("Maximum time allow to book is only 2 hours.");
            }

            if (new_row - 1 != 0) { //indicate there are items before this record
                previousRecord = bookingitems.getEntry(new_row - 1);
                System.out.println(bookingitems);
                System.out.println(previousRecord);
                System.out.println(startDate.compareTo(previousRecord.getReservationEndTime()));
                if (startDate.compareTo(previousRecord.getReservationEndTime()) < 0) {
                    System.out.println("The updation is clash with previous booking");
                }
            }
            if (new_row + 1 <= bookingitems.getLength()) { //indicate there are items after this record
                nextRecord = bookingitems.getEntry(new_row + 1);
                System.out.println(bookingitems);
                System.out.println(nextRecord);
                System.out.println(startDate.compareTo(nextRecord.getReservationEndTime()));
                //System.out.println("compare updatedate with next reservation " + endDate.compareTo(comingBooking.getReservationStartTime()));
                if (endDate.compareTo(nextRecord.getReservationStartTime()) > 0) {
                    System.out.println("The updation is clash with next booking");

                } else {
                    loop = true;
                }
            }
        } while (loop == false);
    }

}
