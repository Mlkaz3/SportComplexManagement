/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


Log:
16/3/2021 
- work on designing the main 
- ideas: https://openplay.ie/online-booking-system/sports-centres.php

22/3/2021 
- work on driver path/flow 
- flow chart planning
- outcome: file:///C:/Users/user/Desktop/flow%20chart.html

23/3/2021
- formattin output suggestion: https://stackoverflow.com/questions/13813247/java-generating-formatted-report-in-text-file-format
- idea: add a search bar
- a complete linked list model: https://beginnersbook.com/2013/12/linkedlist-in-java-with-example/

24/3/2021
- discussion with groupmates to avoid clashing 
- plan further for the whole function 
- study of linked list: https://www.programcreek.com/2013/01/sort-linkedlist-of-user-defined-objects-in-java/

25/3/2021
- sorting datetime https://www.geeksforgeeks.org/comparator-interface-java/
- https://www.geeksforgeeks.org/how-to-sort-a-linked-list-that-is-sorted-alternating-ascending-and-descending-orders/
- dealing with date https://www.geeksforgeeks.org/find-the-duration-of-difference-between-two-dates-in-java/
- https://www.javatpoint.com/program-to-sort-the-elements-of-the-singly-linked-list
 */
package client;

import adt.LinkedList;
import entity.ReservationRecord;
import entity.Equipment;
import entity.Facility;
import entity.User;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author winnie <winnieyap20@gmail.com>
 */
public class UsageLogBasic {

    public static void main(String[] args) throws ParseException {

        LinkedList<ReservationRecord> reservationRecord = new LinkedList<>();

        Date now = new Date();
        DateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        int ch = 0;
        Scanner input = new Scanner(System.in);

        //hc!!
        User user = new User("Tan Pei Ling", "19119", "Student", "0123456789");
        User user1 = new User("Ting Tin Tin", "19109", "Alumni", "0123456781");
        User user2 = new User("Phea Lee Mai", "18119", "Student", "0123456782");
        User user3 = new User("Lim Siew Mooi", "20119", "Student", "0123456783");
        User user4 = new User("Kenneth", "20109", "Student", "0123456783");

        Equipment equipment = new Equipment("001", "Yoonex", true, "12.00", "Shelf0123", "badminton racquet");
        Equipment equipment1 = new Equipment("002", "Adidas", true, "12.00", "Shelf0122", "squash racquet");
        Equipment equipment2 = new Equipment("003", "MsiaB", true, "12.00", "Shelf0121", "tennis ball");
        Equipment equipment3 = new Equipment("004", "Nike", true, "12.00", "Shelf0120", "badminton racquet");

        Facility facility = new Facility(); //facility havent done 

        //creating 4 record
        ReservationRecord record1 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 02:01"), (Date) myFormatObj.parse("02/02/2021 03:01"), user, equipment);
        ReservationRecord record2 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 03:11"), (Date) myFormatObj.parse("02/02/2021 04:12"), user1, equipment2);
        ReservationRecord record3 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 10:13"), (Date) myFormatObj.parse("02/02/2021 11:37"), user2, equipment3);
        ReservationRecord record4 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 05:01"), (Date) myFormatObj.parse("02/02/2021 06:00"), user3, equipment3);
        ReservationRecord record5 = new entity.ReservationRecord((Date) myFormatObj.parse("02/02/2021 07:01"), (Date) myFormatObj.parse("02/02/2021 10:01"), user4, equipment3);

//        ReservationRecord record1_ = new entity.ReservationRecord(now, now, user, equipment);
//        ReservationRecord record2_ = new entity.ReservationRecord(now, now, user1, equipment1);
//        ReservationRecord record3_ = new entity.ReservationRecord(now, now, user2, equipment2);
//        ReservationRecord record4_ = new entity.ReservationRecord(now, now, user3, equipment3);
//        ReservationRecord record5_ = new entity.ReservationRecord(now, now, user4, equipment3);
        //implementing ADT
        reservationRecord.addFirst(record1);
        reservationRecord.addFirst(record2);
        reservationRecord.addFirst(record4);
        reservationRecord.addFirst(record3);
        reservationRecord.addFirst(record5);

//        reservationRecord.addFirst(record1_);
//        reservationRecord.addFirst(record2_);
//        reservationRecord.addFirst(record3_);
//        reservationRecord.addFirst(record4_);
//        reservationRecord.addFirst(record5_);
        Iterator<ReservationRecord> iterator = reservationRecord.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //read the file data in
        //reservationRecord = Deserialize(reservationRecord);
        System.out.println("ⓦⓔⓛⓒⓞⓜⓔ ⓣⓞ ⓣⓐⓡⓤⓒ ⓢⓟⓞⓡⓣ ⓒⓞⓜⓟⓛⓔⓧ");
        System.out.println("🅆🄴🄻🄲🄾🄼🄴 🅃🄾 🅃🄰🅁🅄? 🅂🄿🄾🅁🅃 🄲🄾🄼🄿🄻🄴🅇 🄵🄰🄲🄸🄻🄸🅃🄸🄴🅂 🄰🄽🄳 🅄🅂🄰🄶🄴 🄼🄰🄽🄰🄶🄴🄼🄴🄽🅃 🅂🅈🅂🅃🄴🄼");
        System.out.println("1. Facilities Bookings");
        System.out.println("2. Equipment Bookings");
        System.out.println("3. ");

        do {
            try {
                System.out.print("Please select your choice: ");
                ch = input.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Not an valid choice, please try again.");
                if (input.next().isEmpty()) {
                    break;
                }
            }
        } while (ch < 1 || ch > 3);

        switch (ch) {
            case 1 -> {
                int case1 = 0;
                int row = 0;
                //print heading with reservation record in the memory
                printHeading();
                System.out.println(reservationRecord);

                //enable staff to choose a row to perform actions
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

                bookingDetails(reservationRecord, row);
                //then print selection of actions to be performed
                System.out.println("\nActions to be perform: ");
                System.out.println("1. View Facilities Booking dont do this first ");
                System.out.println("2. Update Facilities Booking"); //thinking a edit column but no sure what to add still 
                System.out.println("3. Delete This Booking");

                do {
                    try {
                        System.out.print("\uD83D\uDE40" + " Please choose your action: ");
                        case1 = input.nextInt();
                    } catch (InputMismatchException exception) {
                        System.out.println("Not an valid choice, please try again.");
                        if (input.next().isEmpty()) {
                            break;
                        }
                    }
                    //validate the row input, make sure it is not larger than the list size 
                } while (case1 < 1 || case1 > 3);

                System.out.println("");
                switch (case1) {
                    case 1 -> {
                        //view booking details 
                        //choose a selection
                        System.out.println("");
                        System.out.println("Selection of items to view:");
                        System.out.println("1-Booking Item");
                        System.out.println("2-User Profile");
                        System.out.println("3-Back");

                        int view_selection = 0;

                        do {
                            try {
                                System.out.print("\uD83D\uDE40" + " Please choose your action: ");
                                view_selection = input.nextInt();
                            } catch (InputMismatchException exception) {
                                System.out.println("Not an valid choice, please try again.");
                                if (input.next().isEmpty()) {
                                    break;
                                }
                            }
                            //validate the row input, make sure it is not larger than the list size 
                        } while (view_selection < 1 || view_selection > 3);

                    }
                    case 2 -> {
                        //update facilities booking at position row
                        //update selection: what value to be update? 
                        System.out.println("");
                        System.out.println("Selection of updating booking details:");
                        System.out.println("1 Extension of booking duration ");
                        System.out.println("2 Modify booking facility/equipment ");
                        System.out.println("3 Update booker information");
                        System.out.println("4 Alter booking duration");

                        //user selection
                        int update_selection;
                        update_selection = input.nextInt();

                        switch (update_selection) {
                            case 1 -> {

                                //flow
                                //get current row record 
                                //extension got a bit error
                                ReservationRecord currentRecord = reservationRecord.getEntry(row);
                                String type = currentRecord.getReservationType();
                                String booking_item;
                                LinkedList<ReservationRecord> bookingitems = new LinkedList<>();
                                System.out.println(type);
                                System.out.println(bookingitems);

                                if ("Facilities".equals(type)) {
                                    //get the booking items
                                    booking_item = currentRecord.getFacilities().getFacilityID();
                                } else {
                                    booking_item = currentRecord.getEquipments().getEquipmentID();
                                }

                                System.out.println("booking item id: " + booking_item);

                                Iterator<ReservationRecord> newiterator = reservationRecord.getIterator();
                                while (newiterator.hasNext()) {
                                    ReservationRecord record = newiterator.next();
                                    System.out.println(record);

                                    if (record.getEquipments().getEquipmentID() == booking_item) {
                                        bookingitems.addFirst(record);
                                    }
                                }

                                System.out.println("Printing the booking items");
                                System.out.println(bookingitems);

                                //arrage in time, ascending order
                                //no idea how to do so
                                LinkedList<ReservationRecord> sortedBookings = SortDateTime(bookingitems);
                                System.out.println(sortedBookings);
                                //System.out.println("end");

                                //compare the booking item with the next row booking item
                                int new_row = bookingitems.getPosition(currentRecord);

                                //use the next end time - start time 
                                Date pre_endtime = bookingitems.getEntry(new_row).getReservationEndTime();
                                Date next_starttime = bookingitems.getEntry(new_row + 1).getReservationStartTime(); //here got error cause no next row 
       
                                //if null then perform?? 
                                
                                
                                double difference_In_Time = next_starttime.getTime() - pre_endtime.getTime();
                               // double diff_hours = (difference_In_Time / (1000 * 60 * 60)) % 24;
                                double diff_mins = (difference_In_Time / (1000 * 60)) % 60;
                                System.out.println("Duration that able to be extend is: " + diff_mins + "minute(s)");
                            }
                            case 2 -> {
                                //Modify booking facility/equipment
                                ReservationRecord modifyBookingItem = reservationRecord.getEntry(row);
                                String modifyitem;
                                System.out.println("Modify booking items to");
                                modifyitem = input.next();

                                //needa do validation 
                                //either equipment/facilities
                                System.out.println("Enter booking items to be edit");

                            }
                            case 3 -> {
                                updateBooker(reservationRecord, row);

                            }
                            case 4 -> {
                                // Alter booking duration}
                                //this similar as case 1 
                                //i also dk how 
                            }
                        }

                    }
                    case 3 -> {
                        //delete record done 
                        deleteBooking(reservationRecord, row);

                    }
                    default -> {
                    }

                }
            }

            case 2 -> {
            }

            case 3 -> {
            }
        }

    }

    private static void updateBooker(LinkedList<ReservationRecord> reservationRecord, int row) {
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

    private static void bookingDetails(LinkedList<ReservationRecord> reservationRecord, int row) {
        System.out.println("");

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
            System.out.println("Booking Items: " + reservationRecord.getEntry(row).getFacilities());
        } else {
            System.out.println("Booking Items: " + reservationRecord.getEntry(row).getEquipments().getEquipmentType());
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

    private static void deleteBooking(LinkedList<ReservationRecord> reservationRecord, int row) {
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

    private static void NOTUSINGYET() {

        //first will print today's reservation(bottom of registration) and registration queue (max of 15 row)
        System.out.println("                                                                                                          Date: ");
        System.out.println("                                                                                                          Time: ");
        System.out.println("                                                                                                          Day : ");
        System.out.println("                                                                                                                ");
        System.out.println("\n                                                       REGISTRATION REPORT LOG");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("RDate       RID        Name      Category           ReservedStartTime     ReservedEndTime     CheckedInTime       CheckOutTime    Status");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                            no record yet. ");
        System.out.println("");
        System.out.println("");
        System.out.println("\n                                                       RESERVATION REPORT LOG");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("RDate       RID        Name      Category           ReservedStartTime     ReservedEndTime     CheckedInTime       CheckOutTime    Status");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                            no record yet. ");
        System.out.println("");
        System.out.println("");

        //then enable user to choose next page or perform action 
        System.out.println("");
        System.out.println("----------------");
        System.out.println("ACTION COMMAND: ");
        System.out.println("----------------");
        System.out.println("PLS NEXT - show next page of registration report");
        System.out.println("PLS UPDATE [NO.]- update registration report at position [NO.]");
        System.out.println("PLS VIEW [NO.] - view details of registration report at position [NO.]");
        System.out.println("PLS FILTER - filter registration report at position [NO.]");
        System.out.println("PLS SHOW - filter registration report at position [NO.]");
        System.out.println("select reservation record at when... ");
        System.out.println("check if which record exist ... ");
        System.out.println("check how many rows of record exist... ");
        System.out.println("replacing record??? ");
        System.out.println("remove record??? ");
        //actions include: View Details at position X / first row / last row 
        //actions include: Update Details at position X / position 1/ last position
        //actions include: Filter report based on date, ID, facilities, equipments, Status 
        //finally will have usage report (not sure doable or not) 

        //Serialize(reservationRecord);
    }

    private static void getCurrentDateTime() {

        //different format 
        SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat timef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat dayf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        //date
        Date currentdate = new Date();

        //print
        System.out.println("                                                                                                          Date: " + datef.format(currentdate));
        System.out.println("                                                                                                          Time: " + timef.format(currentdate));
        System.out.println("                                                                                                          Day : " + dayf.format(currentdate));
        System.out.println("                                                                                                                ");
    }

    private static void printHeading() {
        //heading
        System.out.println("");
        System.out.println("Bookings");
        System.out.println(String.format("%-2s %-40s %-15s %-20s %-20s %-20s %-10s", "No.",
                "Booking", "Status", "From", "To", "Date", "UserID"));

    }

    private static LinkedList<ReservationRecord> Deserialize(LinkedList<ReservationRecord> reservationRecord) throws HeadlessException {
        //deserialize from the file  (read from the file)
        try {
            //Deserializing
            File file = new File("reservationrecord.dat");
            // System.out.println("***TRACE: " + file.getAbsolutePath());
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            // This cast is correct because we're reading an ArrayList of Runner objects
            // from the binary file
            // @SuppressWarnings("unchecked") List<Runner> tempList = (ArrayList<Runner>) (oiStream.readObject());
            // runnerList = tempList
            reservationRecord = (LinkedList<ReservationRecord>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return reservationRecord;
    }

    private static void Serialize(LinkedList<ReservationRecord> reservationRecord) throws HeadlessException {
        //serializable to the file
        try {
            //Serializing
            File file = new File("reservationrecord.dat");
            System.out.println("***TRACE: " + file.getAbsolutePath());
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(reservationRecord);
            ooStream.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

//    public static class SortByID implements Comparator<ReservationRecord> {
//
//        public int compare(ReservationRecord a, ReservationRecord b) {
//            return a.getReservationStartTime().compareTo(b.getReservationStartTime());
//        }
//    }
    //i not sure this can work or not but er...
    private static LinkedList<ReservationRecord> sort(LinkedList<ReservationRecord> toSortList) {
        //Node current will point to head  
        int index = 1;
        ReservationRecord current;
        ReservationRecord next;
        ReservationRecord temp;
        LinkedList<ReservationRecord> SortedList = toSortList;

        if (toSortList != null) {

            current = SortedList.getEntry(index);
            next = SortedList.getEntry(index + 1);
            while (current != null) { //ensuring n position is not null             
                //comparing 1st and 2nd element 

                while (next != null) { //ensuring that n+1 position is not null
                    if (current.getReservationStartTime().compareTo(next.getReservationStartTime()) > 0) {
                        temp = current;
                        current = next;
                        SortedList.swap(index, index + 1);
                        next = temp;
                    }
                }
                index++;
                //If current node's data is greater than index's node data, swap the data between them  
            }
        }
        return SortedList;

    }

    private static LinkedList<ReservationRecord> SortDateTime(LinkedList<ReservationRecord> toSortList) {
        //Node current will point to head  
        ReservationRecord current;
        ReservationRecord next;
        ReservationRecord temp;
        LinkedList<ReservationRecord> SortedList = toSortList;
        SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for (int i = 1; i < SortedList.getLength() +1; i++) {
            for (int j = 1; j < SortedList.getLength()+ 1; j++) {
                current = SortedList.getEntry(i);
                next = SortedList.getEntry(j);
                if (current.getReservationStartTime().compareTo(next.getReservationStartTime()) < 0) {
                    temp = SortedList.getEntry(j);
                    SortedList.replace(j, SortedList.getEntry(i));
                    SortedList.replace(i, temp);
                }
            }
        }
        return SortedList;
    }



}
