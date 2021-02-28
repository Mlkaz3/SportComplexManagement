/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.ReservationRecord;
import entity.User;
import entity.Equipment;
import entity.Facility;
import java.util.Date;

import adt.LinkedList;

/**
 *
 * @author winnieyap note: red line = to update yo
 */
public class TestingReservationRecord {

    public static void main(String[] args) {

        System.out.println("Expected output");
        // TODO code application logic here
        System.out.println("Today's Reservation");
        System.out.println("RID        Name      Category           ReservedTime    StartTime(In)       EndTime(Out)");
        System.out.println("R0000001   Winnie    Facilities-Gym1    01:25PM             02:25PM         01:25PM     ");
        System.out.println("R0000002   Yap       Facilities-Gym2    01:25PM             02:25PM         01:25PM     ");

        System.out.println("Today's Registration");
        System.out.println("RID        Name      Category           ReservedTime    StartTime(In)       EndTime(Out)");
        System.out.println("R0000001   Winnie    Facilities-Gym1    01:25PM             01:25PM             02:25PM     ");
        System.out.println("R0000002   Yap       Facilities-Gym2    01:25PM             01:25PM             02:25PM     ");

        System.out.println("");
        //might import another Calender
        Date now = new Date();

        //hc!!
        User user = new User("Winnie", "19119", "Student", "0123456789");
        Equipment equipment = new Equipment("001", "Yoonex", true, "12.00", "Shelf0123", "badminton racquet");
        Facility facility = new Facility();

        //creating 4 record
        ReservationRecord record1 = new ReservationRecord(20.00, user, equipment);
        ReservationRecord record2 = new ReservationRecord(60.00, user, equipment);
        ReservationRecord record3 = new ReservationRecord(10.00, user, equipment);
        ReservationRecord record4 = new ReservationRecord(30.00, user, equipment);

        //implementing ADT
        LinkedList<ReservationRecord> reservationRecord = new LinkedList<>();
        reservationRecord.addFront(record1);
        reservationRecord.addFront(record2);
        reservationRecord.addFront(record3);
        reservationRecord.addFront(record4);

        System.out.println("");
        System.out.println("SECTION 1");
        System.out.println("");
        System.out.println("This is printed with the linked list class (add front function, which is the push)");
        System.out.println("----------------------------------------------------------------------------------");
        //heading
        System.out.println("");
        System.out.println(String.format("%-15s %-20s %-30s %-30s %-30s %-20s %-20s %-20s",
                "Reservation ID", "Reservation Type", "Reservation DateTime", "Check In", "Check Out",
                "Duration", "UserName", "Reserved Item"));
        System.out.println(reservationRecord);
        
        
        System.out.println("");
        System.out.println("SECTION 2");
        System.out.println("");
        System.out.println("Check either the list contain record 2");
        System.out.println("--------------------------------------");
        System.out.println(reservationRecord.contains(record2));
        System.out.println("ERROR, CANT DETECT SAME ELEMENT WITH MY CODE URGH");
        System.out.println("");
        
        System.out.println("");
        System.out.println("SECTION 3");
        System.out.println("");
        System.out.println("Get the size of list");
        System.out.println("--------------------");
        System.out.println("The size is "+reservationRecord.getLength());
        System.out.println("");
        
         System.out.println("");
        System.out.println("SECTION 4");
        System.out.println("");
        System.out.println("Check wether the list is empty");
        System.out.println("------------------------------");
        System.out.println(reservationRecord.isEmpty());
        System.out.println("");
        
        System.out.println("");
        System.out.println("SECTION 5");
        System.out.println("");
        System.out.println("Get element at position 1 2 3 4");
        System.out.println("-------------------------------");
        System.out.println("The element at position 1 is " + reservationRecord.getEntry(1));
        System.out.println("The element at position 2 is " + reservationRecord.getEntry(2));
        System.out.println("The element at position 3 is " + reservationRecord.getEntry(3));
        System.out.println("The element at position 4 is " + reservationRecord.getEntry(4));
        System.out.println("");
        
//        
//        System.out.println("");
//        System.out.println("SECTION 6");
//        System.out.println("");
//        System.out.println("Replace element at position 4 with element 3");
//        System.out.println("--------------------------------------------");
//        System.out.println(reservationRecord.replace(4, reservationRecord.getEntry(3)));
//        System.out.println("The element at position 1 is " + reservationRecord.getEntry(1));
//        System.out.println("The element at position 2 is " + reservationRecord.getEntry(2));
//        System.out.println("The element at position 3 is " + reservationRecord.getEntry(3));
//        System.out.println("The element at position 4 is " + reservationRecord.getEntry(4));
//        System.out.println("");
        
//        System.out.println("");
//        System.out.println("SECTION 7");
//        System.out.println("");
//        System.out.println("Remove element at position 4");
//        System.out.println("--------------------------------------------");
//        System.out.println(reservationRecord.remove(4));
//        System.out.println(reservationRecord);
//        System.out.println("");
      

//        ReservationRecord record3 = new ReservationRecord(now,now,2.0,user,facility);
//        System.out.println("record3 " + record3);
        //client side planning
        //staff able to edit the reservation record
        //staff able to view the reservaion record
        //staff able to sort the reservation record
        //staff able to insert a new reservation record 
        //staff able to delete a reservation record 
        //staff able to ???
//        System.out.println("Today's Record");
//        System.out.println("______________");
    }
}
