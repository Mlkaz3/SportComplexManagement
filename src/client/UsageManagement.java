package client;

import adt.LinkedList;
import static client.SportComplexSystem.equipmentManagement;
import static client.SportComplexSystem.facilityManagement;
import static client.SportComplexSystem.pressEnterKeyToContinue;
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
import static client.SportComplexSystem.usageManagement;
import entity.Facility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author 
 * Winnie Yap Xiang Loo 19WMR11981
 */
public class UsageManagement implements Serializable {

    LinkedList<ReservationRecord> reservationRecord;
    Scanner input = new Scanner(System.in);
    DateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public UsageManagement() {
        this.reservationRecord = new LinkedList<>();
    }

    public boolean addReservation(ReservationRecord record) {
        Date now = new Date();
        if (record.getReservationDuration() > 2) {
            System.out.println("The maximum hour to use an equipment/facilities is 2 hours only");
            return false;
        } else if (record.getReservationEndTime().compareTo(now) == -1) {
            System.out.println("The booking end time should not smaller than current time");
            return false;
        }
        System.out.println("Booking added successfully.");
        reservationRecord.addLast(record);
        serFileWriter();
        return true;
    }

    public void displayReservation() {
        serFileReader();
        if (reservationRecord.isEmpty()) {
            System.out.println("-----------------------");
            System.out.println("No booking record found");
            System.out.println("-----------------------");
        } else {
            System.out.println("");
            System.out.println("");
            System.out.println("*".repeat(135));
            Date date = new Date();
            System.out.println("");
            DateFormat headingFormat = new SimpleDateFormat("E, dd.MM.yyyy");
            System.out.println("Today's Bookings -> " + headingFormat.format(date));
            displayHeading();
            System.out.println(reservationRecord);
            System.out.println("*".repeat(135));
            System.out.println("");
            System.out.println("");
        }
    }

    public void displayHeading() {
        System.out.println("-".repeat(135));
        System.out.println(String.format("%-2s %-40s %-15s %-20s %-20s %-20s %-10s", "No.",
                "Booking", "Status", "StartDateTime", "EndDateTime", "CheckOutTime", "UserID"));
        System.out.println("-".repeat(135));
    }

    public void updateBooking(int row) throws ParseException {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                  Update Booking                 *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] Extension of booking duration            *");
                System.out.println("*    [2] Update booker information                *");
                System.out.println("*    [3] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                        extendBooking(row);
                        System.out.println("");
                    }
                    case 2 -> {
                        updateBooker(row);
                        System.out.println();
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

    public void deleteBooking(int row) {
        String deletion;
        serFileReader();
        if ("Complete".equals(reservationRecord.getEntry(row).getStatus())) {
            System.out.println("Unable to delete success booking");
            pressEnterKeyToContinue();
        } else {
            System.out.println("\nAre you sure you want to permanently delete this booking? (Yes/No)");
            System.out.print("-> ");
            ReservationRecord deletionRecord;
            deletion = input.next();
            switch (deletion.toLowerCase()) {
                case "yes" -> {
                    if ("Facilities".equals(reservationRecord.getEntry(row).getReservationType())) {
                        Facility deletionFacility = reservationRecord.getEntry(row).getFacilities();
                        facilityManagement.returnDeleted(deletionFacility);
                    } else {
                        Equipment deletionEquipment = reservationRecord.getEntry(row).getEquipment();
                        equipmentManagement.returnDeleted(deletionEquipment);
                    }
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
        serFileWriter();

    }

    public void updateBooker(int row) {
        serFileReader();
        Scanner user_input = new Scanner(System.in);
        ReservationRecord currentRecord = reservationRecord.getEntry(row);
        User currentUser = currentRecord.getUser();
        String user_update;
        System.out.println("\n--------------------------");
        System.out.println("Update Booking Information");
        System.out.println("--------------------------");
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

        if (reservationRecord.replace(row, currentRecord) == true) {
            System.out.println("\nBooker Info Successfully Update.");
        }
        serFileWriter();
    }

    public void extendBooking(int row) throws ParseException {
        serFileReader();
        DateFormat format_date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date now = new Date();
        Scanner user_in = new Scanner(System.in);
        ReservationRecord currentRecord = reservationRecord.getEntry(row);
        Date bookingStart = currentRecord.getReservationDate();
        Date bookingEnd = currentRecord.getReservationEndTime();
        if (now.compareTo(bookingStart) > 0 && now.compareTo(bookingEnd) < 0
                && currentRecord.isIsExtend() == false && "pending".equals(currentRecord.getStatus().toLowerCase())) {
            String end_time;
            Date endDate = new Date();
            boolean loop = false;
            System.out.println("\n-----------------------------");
            System.out.println("Extension of Booking Duration");
            System.out.println("-----------------------------");
            do {
                boolean validDate;
                do {
                    System.out.print("New End Time(dd/MM/yyyy HH:mm) :");
                    end_time = user_in.nextLine();
                    try {
                        endDate = (Date) format_date.parse(end_time);
                        validDate = true;
                    } catch (ParseException e) {
                        System.out.println("\nInvalid date format.");
                        System.out.println();
                        validDate = false;
                    }
                } while (validDate != true);

                double datediff = endDate.getTime() - currentRecord.getReservationEndTime().getTime();
                if ((datediff / (1000 * 60 * 60)) % 24 > 2) {
                    System.out.println("Maximum time allow to extend is only 2 hours.\n");
                } else if (endDate.compareTo(bookingEnd) < 0) {
                    System.out.println("Extension doesnt allow shorten of booking.\n");
                } else {
                    loop = true;
                }
            } while (loop == false);

            System.out.println("Booking successfully extended.");
            currentRecord.setReservationEndTime(endDate);
            currentRecord.setIsExtend(true);
            reservationRecord.replace(row, currentRecord);
            serFileWriter();
        } else if (currentRecord.isIsExtend() == true) {
            System.out.println("Extension is only allow once per each booking.");
        } else {
            System.out.println("Extension is only available within booking period.");
        }
    }

    public int getRow() {
        int row = 0;
        if (reservationRecord.isEmpty()) {
            row = -1;
        } else {
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
            } while (row < 1 || row > reservationRecord.getLength());
        }
        return row;
    }

    public LinkedList<ReservationRecord> filterBookerRecord(int row) {
        serFileReader();
        LinkedList<ReservationRecord> bookerRecord = new LinkedList<>(); //list to store the booking record for user 
        Iterator<ReservationRecord> newiterator = reservationRecord.getIterator();
        ReservationRecord currentRecord = reservationRecord.getEntry(row);
        String user_id = currentRecord.getUser().getUserID();
        int count = 0;
        System.out.println("");
        System.out.println("");
        System.out.println("*".repeat(135));
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
        System.out.printf("%-25s %-20s\n\n", "Total booking record", "| " + count + " record(s)");
        System.out.println("*".repeat(135));
        System.out.println("");
        System.out.println("");
        return bookerRecord;
    }

    public ReservationRecord getBookingRecord(String id) {
        serFileReader();
        ReservationRecord bookingitem = null;
        Iterator<ReservationRecord> itemIterator = reservationRecord.getIterator();
        while (itemIterator.hasNext()) {
            ReservationRecord record = itemIterator.next();
            if (record.getReservationID() == null ? id == null : record.getReservationID().equals(id)) {
                bookingitem = record;
                break;
            }
        }
        return bookingitem;
    }

    public void updateBookingStatus(ReservationRecord record) {
        int position;
        Date now = new Date();
        position = reservationRecord.getPosition(record);
        reservationRecord.getEntry(position).setCheckOutDateTime(now);
        reservationRecord.getEntry(position).setStatus("Complete");
        serFileWriter();
    }

    public void getPenaltyCharges(String id) {
        serFileReader();
        int position = 0;
        Iterator<ReservationRecord> itemIterator = reservationRecord.getIterator();
        while (itemIterator.hasNext()) {
            ReservationRecord record = itemIterator.next();
            if (record.getReservationID() == null ? id == null : record.getReservationID().equals(id)) {
                position = reservationRecord.getPosition(record);
                Date end = reservationRecord.getEntry(position).getReservationEndTime();
                Date checkout = reservationRecord.getEntry(position).getCheckOutDateTime();
                if (checkout.compareTo(end) > 0) {
                    long datediff = checkout.getTime() - end.getTime();
                    datediff = (datediff / (1000 * 60 * 60)) % 24;
                    reservationRecord.getEntry(position).setLateHour(datediff);
                    System.out.println("Late In Returning");
                    System.out.println("Penalty Fine: " + reservationRecord.getEntry(position).calculatePenalty());
                }
                break;
            }
        }
    }

    public void displayBookingDetails(int row) {
        DateFormat format = new SimpleDateFormat("E dd/MM/yyyy HH:mm");
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println("");
        System.out.println("=".repeat(60));
        System.out.println("Booking #" + reservationRecord.getEntry(row).getReservationID() + " Details");
        System.out.println("=".repeat(60));
        System.out.println("General Details");
        System.out.println("---------------");
        System.out.printf("%-25s %-30s\n", "Booking Creation Date", "| " + format.format(reservationRecord.getEntry(row).getReservationDate()));
        System.out.printf("%-25s %-30s\n", "Booking Status", "| " + reservationRecord.getEntry(row).getStatus());
        System.out.printf("%-25s %-20s\n", "Booking Extension Status ", "| " + reservationRecord.getEntry(row).isIsExtend());
        System.out.println("\nBooking Facilities/Equipment");
        System.out.println("----------------------------");
        System.out.printf("%-25s %-30s\n", "Booking Type ", "| " + reservationRecord.getEntry(row).getReservationType());
        if ("Facilities".equals(reservationRecord.getEntry(row).getReservationType())) {
            System.out.printf("%-25s %-20s\n", "Booking Item ", "| " + reservationRecord.getEntry(row).getFacilities().getFacilityName());
            System.out.printf("%-25s %-20s\n", "Booking Items ID ", "| " + reservationRecord.getEntry(row).getFacilities().getFacilityID());
        } else {
            System.out.printf("%-25s %-20s\n", "Booking Item", "| " + reservationRecord.getEntry(row).getEquipment().getEquipmentType());
            System.out.printf("%-25s %-20s\n", "Booking Items ID ", "| " + reservationRecord.getEntry(row).getEquipment().getEquipmentID());
        }
        System.out.println("\nBooking Date");
        System.out.println("------------");
        System.out.printf("%-25s %-20s\n", "Start DateTime", "| " + myFormatObj.format(reservationRecord.getEntry(row).getReservationStartTime()));
        System.out.printf("%-25s %-20s\n", "End DateTime ", "| " + myFormatObj.format(reservationRecord.getEntry(row).getReservationEndTime()));
        System.out.printf("%-25s %-20s\n", "Duration", "| " + df.format(reservationRecord.getEntry(row).getReservationDuration()) + " Hour(s)");
        System.out.println("\nBooker Details");
        System.out.println("--------------");
        System.out.printf("%-25s %-20s\n", "Booker ID", "| " + reservationRecord.getEntry(row).getUser().getUserID());
        System.out.printf("%-25s %-20s\n", "Booker Name ", "| " + reservationRecord.getEntry(row).getUser().getUserName());
        System.out.println("\nPenalty Details");
        System.out.println("---------------");
        if (reservationRecord.getEntry(row).getLateHour() == 0.0) {
            System.out.printf("%-25s %-20s\n", "Penalty Status", "| " + "False");
        } else {
            System.out.printf("%-25s %-20s\n", "Penalty Status", "| " + "True");
            System.out.printf("%-25s %-20s\n", "Late in Hours", "| " + reservationRecord.getEntry(row).getLateHour());
            System.out.printf("%-25s %-20s\n", "Penalty Rate ", "| " + reservationRecord.getEntry(row).getPenaltyRate());
            System.out.printf("%-25s %-20s\n", "Penalty Amount ", "| " + reservationRecord.getEntry(row).calculatePenalty());
        }
        System.out.println("=".repeat(60));
    }

    public LinkedList<ReservationRecord> filterEquipmentRecord() {
        serFileReader();
        LinkedList<ReservationRecord> equipment = new LinkedList<>();
        for (int i = 1; i < reservationRecord.getLength() + 1; i++) {
            ReservationRecord record = reservationRecord.getEntry(i);
            if (record.getEquipment() != null) {
                equipment.addLast(record);
            }
        }
        return equipment;
    }

    public LinkedList<ReservationRecord> filterFacilitiesRecord() {
        serFileReader();
        LinkedList<ReservationRecord> facility = new LinkedList<>();
        for (int i = 1; i < reservationRecord.getLength() + 1; i++) {
            ReservationRecord record = reservationRecord.getEntry(i);
            if (record.getFacilities() != null) {
                facility.addLast(record);
            }
        }
        return facility;
    }

    //Read file
    public void serFileReader() {
        try {
            FileInputStream fileIn = new FileInputStream("src/ReservationRecord.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            reservationRecord = (LinkedList<ReservationRecord>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("No reservation record found!");
            c.printStackTrace();
        }
    }

    //Write file
    public void serFileWriter() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/ReservationRecord.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(reservationRecord);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void overview() {
        System.out.println("");
        System.out.println("");
        System.out.println("*".repeat(135));
        System.out.println("Summary");
        LinkedList<ReservationRecord> equipment = usageManagement.filterEquipmentRecord();
        equipment = SortDateTime(equipment);
        LinkedList<ReservationRecord> facility = usageManagement.filterFacilitiesRecord();
        facility = SortDateTime(facility);
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

    private static LinkedList<ReservationRecord> SortDateTime(LinkedList<ReservationRecord> toSortList) {
        ReservationRecord current;
        ReservationRecord next;
        ReservationRecord temp;
        LinkedList<ReservationRecord> SortedList = toSortList;
        SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for (int i = 1; i < SortedList.getLength() + 1; i++) {
            for (int j = 1; j < SortedList.getLength() + 1; j++) {
                current = SortedList.getEntry(i);
                next = SortedList.getEntry(j);
                if (current.getReservationStartTime().compareTo(next.getReservationStartTime()) > 0) {
                    temp = SortedList.getEntry(j);
                    SortedList.swap(i, j);
                }
            }
        }
        return SortedList;
    }

    //this function fucked up 
    //filter Record based on type of reservation
    private LinkedList<ReservationRecord> filterRecord(ReservationRecord currentRecord) {
        serFileReader();
        LinkedList<ReservationRecord> bookingitems = new LinkedList<>();
        String type = currentRecord.getReservationType();

        if ("Facilities".equals(type)) {
            //get the booking items
            String booking_item = currentRecord.getFacilities().getFacilityID();
            Iterator<ReservationRecord> newiterator = reservationRecord.getIterator();
            while (newiterator.hasNext()) {
                ReservationRecord record = newiterator.next();
                if (record.getFacilities().getFacilityID().equals(booking_item)) {
                    bookingitems.addFirst(record);
                }
            }
        } else {
            System.out.println("currentRecord " + currentRecord);
            String booking_item = currentRecord.getEquipment().getEquipmentID();
            Iterator<ReservationRecord> newiterator = reservationRecord.getIterator();
            while (newiterator.hasNext()) {
                ReservationRecord record = newiterator.next();
                if (record.getEquipment().getEquipmentID().equals(booking_item)) {
                    bookingitems.addFirst(record);
                }
            }
        }
        return bookingitems;
    }
}

//                    SortedList.replace(j, SortedList.getEntry(i));
//                    SortedList.replace(i, temp);
