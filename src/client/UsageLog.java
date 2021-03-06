/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


Log:
16/3/2021 
- work on designing the main 
- ideas: https://openplay.ie/online-booking-system/sports-centres.php
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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author winnie <winnieyap20@gmail.com>
 */
public class UsageLog {

    public static void main(String[] args) {

        Date now = new Date();

        int ch = 0;
        Scanner input = new Scanner(System.in);

        //hc!!
        User user = new User("Winnie", "19119", "Student", "0123456789");
        Equipment equipment = new Equipment("001", "Yoonex", true, "12.00", "Shelf0123", "badminton racquet");
        Facility facility = new Facility();

        //creating 4 record
        ReservationRecord record1 = new entity.ReservationRecord(20.00, user, equipment);
        ReservationRecord record2 = new entity.ReservationRecord(60.00, user, equipment);
        ReservationRecord record3 = new entity.ReservationRecord(10.00, user, equipment);
        ReservationRecord record4 = new entity.ReservationRecord(30.00, user, equipment);

        //implementing ADT
        LinkedList<ReservationRecord> reservationRecord = new LinkedList<>();
        reservationRecord.addFront(record1);
        reservationRecord.addFront(record2);
        reservationRecord.addFront(record3);
        reservationRecord.addFront(record4);

        //read the file data in
        //reservationRecord = Deserialize(reservationRecord);
        System.out.println("ⓦⓔⓛⓒⓞⓜⓔ ⓣⓞ ⓣⓐⓡⓤⓒ ⓢⓟⓞⓡⓣ ⓒⓞⓜⓟⓛⓔⓧ");
        System.out.println("🅆🄴🄻🄲🄾🄼🄴 🅃🄾 🅃🄰🅁🅄🄲 🅂🄿🄾🅁🅃 🄲🄾🄼🄿🄻🄴🅇 🄵🄰🄲🄸🄻🄸🅃🄸🄴🅂 🄰🄽🄳 🅄🅂🄰🄶🄴 🄼🄰🄽🄰🄶🄴🄼🄴🄽🅃 🅂🅈🅂🅃🄴🄼");
        System.out.println("1. Facilities Bookings");
        System.out.println("2. Equipment Bookings");
        System.out.println("3. ");

        System.out.print("Please select your choice: ");
        ch = input.nextInt();

        switch (ch) {
            case 1:
                int case1 = 0;
                int row = 0;
                //print heading with reservation record in the memory
                printHeading();
                System.out.println(reservationRecord);

                //enable staff to choose a row to perform actions
                System.out.print("Please select a row to perform actions: ");
                row = input.nextInt();

                //validate the row input, make sure it is not larger than the list size 
                if (row < 0) { //false condition with loop 

                }

                //then print selection of actions to be performed
                System.out.println("\nActions: ");
                System.out.println("1. View Facilities Booking");
                System.out.println("2. Update Facilities Booking"); //thinking a edit column but no sure what to add still 
                System.out.println("3. Cancel Facilities Booking");
                System.out.print("\uD83D\uDE40" + " Please choose your action: ");

                case1 = input.nextInt();

                switch (case1) {
                    case 1:
                       //view facilities booking detail at position row
                       //print all the facilities info at position row
                        break;
                    case 2:
                        //update facilities booking at position row
                       //update selection: what value to be update? 
                        break;
                    case 3:
                        //cancel facilities booking at position row
                        //cancel should be added into another dat file, written with reason
                        break;
                    default:
                        break;
                }

                break;

            case 2:
                break;

            case 3:
                break;
        }

        //for choices 2 
        //for choices 3 
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
        System.out.println(String.format("%-15s %-20s %-30s %-30s %-30s %-20s %-20s %-20s",
                "Reservation ID", "Reservation Type", "Reservation DateTime", "Check In", "Check Out",
                "Duration", "UserName", "Reserved Item"));
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

}
