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

/**
 *
 * @author winnieyap
 * note: red line = to update yo 
 */
public class TestingReservationRecord {
    public static void main(String[] args) {
        
        // TODO code application logic here
        System.out.println("Today's Reservation");
        System.out.println("RID        Name      Category           StartTime(In)       EndTime(Out)");
        System.out.println("R0000001   Winnie    Facilities-Gym1    01:25PM             02:25PM     ");
        System.out.println("R0000002   Yap       Facilities-Gym2    01:25PM             02:25PM     ");
        
        
        System.out.println("Today's Registration");
        System.out.println("RID        Name      Category           StartTime(In)       EndTime(Out)");
        System.out.println("R0000001   Winnie    Facilities-Gym1    01:25PM             02:25PM     ");
        System.out.println("R0000002   Yap       Facilities-Gym2    01:25PM             02:25PM     ");
        
        //might import another Calender
        Date now = new Date();
        
        //hc!!
        User user = new User("Winnie", "19119", "Student", "0123456789");
        Equipment equipment = new Equipment("001","Yoonex",true,"12.00","Shelf0123","badminton racquet");
        Facility facility = new Facility();

        //heading
        System.out.println("");
         System.out.println(String.format("%-15s %-20s %-30s %-30s %-30s %-20s %-20s %-20s",
                "Reservation ID","Reservation Type","Reservation DateTime","Check In","Check Out",
                "Duration","UserName","Reserved Item"));
        
        ReservationRecord record1 = new ReservationRecord(20.00,user,equipment);
        System.out.println(record1);
        ReservationRecord record2 = new ReservationRecord(60.00,user,equipment);
        System.out.println(record2);
        ReservationRecord record3 = new ReservationRecord(10.00,user,equipment);
        System.out.println(record3);
        ReservationRecord record4 = new ReservationRecord(30.00,user,equipment);
        System.out.println(record4);
//        ReservationRecord record3 = new ReservationRecord(now,now,2.0,user,facility);
//        System.out.println("record3 " + record3);
        
        //client side planning
        //staff able to edit the reservation record
        //staff able to view the reservaion record
        //staff able to sort the reservation record
        //staff able to insert a new reservation record 
        //staff able to delete a reservation record 
        //staff able to ???
        System.out.println("Today's Record");
        System.out.println("______________");
    }
}
