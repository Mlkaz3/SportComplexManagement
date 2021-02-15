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
        //might import another Calender
        Date now = new Date();
        
        //hc!!
        User user = new User("Winnie", "19119", "Student", "0123456789");
        Equipment equipment = new Equipment();
        Facility facility = new Facility();
        
        ReservationRecord record1 = new ReservationRecord();
        System.out.println("record1 " + record1);
        ReservationRecord record2 = new ReservationRecord(now,now,2.0,user,equipment);
        System.out.println("record2 " + record2);
        ReservationRecord record3 = new ReservationRecord(now,now,2.0,user,facility);
        System.out.println("record3 " + record3);
    }
}
