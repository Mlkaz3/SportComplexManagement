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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import static client.MainDriver.pressEnterKeyToContinue;

/**
 *
 * @author winnie <winnieyap20@gmail.com>
 */
public class UsageManagement {

    LinkedList<ReservationRecord> reservationRecord;
    Scanner input = new Scanner(System.in);
    DateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public UsageManagement() {
        this.reservationRecord = new LinkedList<>();
    }

    public String addReservation(ReservationRecord record) {
        //checking to ensure the duration does not more than 2 hours 
        //checking to ensure date pass in is not previous than the current time
        if (record.getReservationDuration() > 2) {
            return "The maximum hour to use an equipment/facilities is 2 hours only";
        } else {
            reservationRecord.addLast(record);
            return "Booking added successfully.";
        }
    }

    public void displayReservation() {
        Date date = new Date();
        System.out.println("");
        DateFormat headingFormat = new SimpleDateFormat("E, dd.MM.yyyy");
        System.out.println("Today's Bookings -> " + headingFormat.format(date));
        displayHeading();
        System.out.println(reservationRecord);

//        Iterator<ReservationRecord> iterator = reservationRecord.getIterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }

    private void displayHeading() {
        System.out.println("-".repeat(135));
        System.out.println(String.format("%-2s %-40s %-15s %-20s %-20s %-20s %-10s", "No.",
                "Booking", "Status", "From", "To", "Date", "UserID"));
        System.out.println("-".repeat(135));
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
                        filterBookingItem(row);
                        pressEnterKeyToContinue();

                    }
                    case 2 -> {
                        filterBookerRecord(row);
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
                        //extension (debug 90% done)
                        extendBooking(reservationRecord, row);
                        System.out.println("");
                    }
                    case 2 -> {
                        //modify item
                        System.out.println("");

                    }
                    case 3 -> {
                        //update booker (debug 100% done)
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
        //get the deletion of item either equipment/facilities 

        System.out.println("\nAre you sure you want to permanently delete this booking? (Yes/No)");
        System.out.print("-> ");
        ReservationRecord deletionRecord;
        deletion = input.next();
        switch (deletion.toLowerCase()) {
            case "yes" -> {
                deletionRecord = reservationRecord.removeAt(row);
                System.out.println("The booking record with ID " + deletionRecord.getReservationID() + " is deleted.");

            }
            case "no" -> {
                System.out.println("The record is remain in the table.");
            }
            default -> {
                System.out.println("Unknown selection.");
            }

        }
    }

    public void updateBooker(int row) {
        //Update booker information
        //get the object to update
        Scanner user_input = new Scanner(System.in);
        ReservationRecord currentRecord = reservationRecord.getEntry(row);
        User currentUser = currentRecord.getUser();
        String user_update;
        System.out.println("Update Booking Information");
        System.out.println("Enter the following details");
        System.out.printf("%-30s %-1s", "Name", "|");
        user_update = user_input.nextLine();
        currentUser.setUserName(user_update);

        System.out.printf("%-30s %-1s", "User ID", "|");
        user_update = user_input.nextLine();
        currentUser.setUserID(user_update);

        System.out.printf("%-30s %-1s", "User Category ", "|");
        user_update = user_input.nextLine();
        currentUser.setUserCategory(user_update);

        System.out.printf("%-30s %-1s", "User Contact ", "|");
        user_update = user_input.nextLine();
        currentUser.setUserTel(user_update);

        currentRecord.setUser(currentUser);

        //update with replace
        if (reservationRecord.replace(row, currentRecord) == true) {
            System.out.println("\nBooker Info Successfully Update.");
        }

    }

    //success
    public void extendBooking(LinkedList<ReservationRecord> reservationRecord, int row) throws ParseException {

        DateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date now = new Date();
        Scanner input = new Scanner(System.in);

        ReservationRecord currentRecord = reservationRecord.getEntry(row); //record to be alter
        LinkedList<ReservationRecord> bookingitems; //is the list of items that have l;
        bookingitems = filterRecord(reservationRecord, currentRecord);
        LinkedList<ReservationRecord> sortedBookings = SortDateTime(bookingitems); //sorted list

        //check wether the time now is within the user booking time 
        Date bookingStart = currentRecord.getReservationStartTime();
        Date bookingEnd = currentRecord.getReservationEndTime();
        if (now.compareTo(bookingStart) > 0 && now.compareTo(bookingEnd) < 0) {

            int new_row = sortedBookings.getPosition(currentRecord); //get the current booking to update in sortedBookings
            ReservationRecord comingBooking; //refer to next booking
            String end_time;
            Date endDate;

            boolean loop = false;
            System.out.println("Extension");
            do {
                System.out.print("New End Time(dd/MM/yyyy HH:mm) :");
                end_time = input.nextLine();
                endDate = (Date) myFormatObj.parse(end_time);

                double datediff = endDate.getTime() - currentRecord.getReservationEndTime().getTime();
                //double datdiff = ((double) (endDate.getTime() - currentRecord.getReservationEndTime().getTime())) / (1000 * 60 * 60 * 24);
                //System.out.println(datediff);

                if ((datediff / (1000 * 60 * 60)) % 24 > 2) {
                    System.out.println("Maximum time allow to extend is only 2 hours.\n");
                } else if (endDate.compareTo(bookingEnd) < 0) { //where the updated is actually shorten the original 
                    System.out.println("Extension doesnt allow shorten of booking.\n");
                } else if (new_row + 1 <= sortedBookings.getLength()) { //there is a next row
                    comingBooking = sortedBookings.getEntry(new_row + 1);
                    //System.out.println("compare updatedate with next reservation " + endDate.compareTo(comingBooking.getReservationStartTime()));
                    if (endDate.compareTo(comingBooking.getReservationStartTime()) > 0) {
                        System.out.println("The updation is clash with next booking\n");
                    } else {
                        loop = true;
                    }
                }

            } while (loop == false);

            System.out.println("Booking successfully extended.");
            //here need to update booking table/record
            currentRecord.setReservationEndTime(endDate);
            reservationRecord.replace(row, currentRecord);
        } else {
            System.out.println("Extension is only available within booking period.");
        }
    }

    public int getRow() {
        //enable staff to choose a row to perform actions
        int row = 0;
        do {
            try {
                System.out.print("Please select a row to perform actions: ");
                row = input.nextInt();
                if (row < 1 || row > reservationRecord.getLength()) {
                    System.out.println("Unknown row input, please try again.");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Not an valid choice, please try again.");
                if (input.next().isEmpty()) {
                    break;
                }
            }
        } while (row < 1 || row > reservationRecord.getLength()); //validate the row input, make sure it is not larger than the list size
        return row;
    }

    private void filterBookingItem(int row) {

        ReservationRecord currentRecord = reservationRecord.getEntry(row); //record to be alter
        LinkedList<ReservationRecord> bookingitems; //is the list of items that have l;
        bookingitems = filterRecord(reservationRecord, currentRecord);
        bookingitems = SortDateTime(bookingitems);
        String bookingitemscode;
        if ("Equipments".equals(currentRecord.getReservationType())) {
            bookingitemscode = currentRecord.getEquipments().getEquipmentID();
        } else {
            bookingitemscode = currentRecord.getFacilities().getFacilityID();
        }

        System.out.println("\nBorrow Record for " + currentRecord.getReservationType() + " - " + bookingitemscode);
        displayHeading();
        System.out.println(bookingitems);

        //to do 
        //
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
        int count = 0;

        System.out.println("\nBooker Details");
        System.out.println("--------------");
        System.out.printf("%-25s %-20s\n", "Booker ID", "| " + reservationRecord.getEntry(row).getUser().getUserID());
        System.out.printf("%-25s %-20s\n", "Booker Name ", "| " + reservationRecord.getEntry(row).getUser().getUserName());
        System.out.printf("%-25s %-20s\n", "Booker Category ", "| " + reservationRecord.getEntry(row).getUser().getUserCategory());
        System.out.printf("%-25s %-20s\n", "Booker Contact ", "| " + reservationRecord.getEntry(row).getUser().getUserTel());

        while (newiterator.hasNext()) {
            ReservationRecord record = newiterator.next();

            if (record.getUser().getUserID().equals(user_id)) {

                bookerRecord.addLast(record);
                count++;
            }
        }

        System.out.println("\nBorrow Record for Booker - " + user_id);
        displayHeading();
        System.out.println(bookerRecord);

        System.out.println("");
        System.out.printf("%-25s %-20s", "Total booking record", "| " + count + " record(s)");

        //can do the press enter to continue
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
        DateFormat format = new SimpleDateFormat("E dd/MM/yyyy HH:mm");
        System.out.println("");

        System.out.println("=".repeat(60));
        System.out.println("Booking #" + reservationRecord.getEntry(row).getReservationID() + " Details");
        System.out.println("=".repeat(60));

        System.out.println("General Details");
        System.out.println("---------------");
        System.out.printf("%-25s %-30s\n", "Booking Creation Date", "| " + format.format(reservationRecord.getEntry(row).getReservationDate()));
        System.out.println("Booking Status"); //status can be pending or success or cancelation

        System.out.println("\nBooking Facilities/Equipment");
        System.out.println("----------------------------");
        System.out.printf("%-25s %-30s\n", "Booking Type ", "| " + reservationRecord.getEntry(row).getReservationType());

        if ("Facilities".equals(reservationRecord.getEntry(row).getReservationType())) {
            System.out.printf("%-25s %-20s\n", "Booking Item ", "| " + reservationRecord.getEntry(row).getFacilities());
        } else {
            System.out.printf("%-25s %-20s\n", "Booking Item", "| " + reservationRecord.getEntry(row).getEquipments().getEquipmentType());
            System.out.printf("%-25s %-20s\n", "Booking Items ID ", "| " + reservationRecord.getEntry(row).getEquipments().getEquipmentID());
            //System.out.printf("%-25s %-20s\n", "Booking Items Status", "| " +  reservationRecord.getEntry(row).getEquipments().getEquipmentStatus());
        }

        System.out.println("\nBooking Date");
        System.out.println("------------");
        System.out.printf("%-25s %-20s\n", "Start DateTime", "| " + myFormatObj.format(reservationRecord.getEntry(row).getReservationStartTime()));
        System.out.printf("%-25s %-20s\n", "End DateTime ", "| " + myFormatObj.format(reservationRecord.getEntry(row).getReservationEndTime()));
        System.out.printf("%-25s %-20s\n", "Duration", "| " + reservationRecord.getEntry(row).getReservationDuration() + " Hour(s)");

        System.out.println("\nBooker Details");
        System.out.println("--------------");
        System.out.printf("%-25s %-20s\n", "Booker ID", "| " + reservationRecord.getEntry(row).getUser().getUserID());
        System.out.printf("%-25s %-20s\n", "Booker Name ", "| " + reservationRecord.getEntry(row).getUser().getUserName());

        System.out.println("=".repeat(60));

        //if can put a press any key to continue
    }

    public void alterBookingDateTime(int row) throws ParseException {

        //validation of new startDate and endDate
        ReservationRecord currentRecord = reservationRecord.getEntry(row); //record to be alter
        ReservationRecord previousRecord;
        ReservationRecord nextRecord;
        LinkedList<ReservationRecord> bookingitems; //is the list of items that have XX items;
        bookingitems = filterRecord(reservationRecord, currentRecord);
        bookingitems = SortDateTime(bookingitems); //list
        int new_row = bookingitems.getPosition(currentRecord);

        //alter cannot make during the booking ongoing 
        //maybe can set a limit of 2 hours before updating 
        //cannot alter pass record
        Date now = new Date();
        Date bookingStart = currentRecord.getReservationStartTime();
        Date bookingEnd = currentRecord.getReservationEndTime();
        if (now.compareTo(bookingStart) < 0) {
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
        } else if (now.compareTo(bookingEnd) > 0) {
            System.out.println("Unable to alter past booking.");
        } else {
            System.out.println("Booking time is only able to alter right before the exact booking");
        }
    }

}
