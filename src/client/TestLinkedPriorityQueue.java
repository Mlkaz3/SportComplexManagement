/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedPriorityQueue;
import entity.Maintenance;
import adt.PriorityQueueInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author YJ
 */
public class TestLinkedPriorityQueue {
    
   public static void main(String[] args) throws ParseException {

        PriorityQueueInterface<Maintenance> appointment = new LinkedPriorityQueue<>();

        Maintenance maintenance = new Maintenance();
        Maintenance maintenance2 = new Maintenance();
        Maintenance maintenance3 = new Maintenance();

        Scanner userInput = new Scanner(System.in);
        //System.out.print("Enter due date (dd-mm-yyyy): ");
        //String date = userInput.nextLine();
        //SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        //Date requiredDate = format.parse(date);

        System.out.print("\nFacility ID: ");
        maintenance.setFacilityID(userInput.nextLine());
        System.out.print("Maintenance type: ");
        maintenance.setMaintenanceType(userInput.nextLine());
        System.out.print("Maintenance description: ");
        maintenance.setMaintenanceDesc(userInput.nextLine());
        System.out.print("Date required (yyyy-mm-dd): ");
        String date = userInput.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date requiredDate = format.parse(date);
        maintenance.setRequiredDate(requiredDate);
        //set date of making appointment
        GregorianCalendar cal = new GregorianCalendar();
        //Date now = new Date();
        Date now = cal.getTime();
        maintenance.setRequestDate(now);
       
        System.out.print("\nFacility ID: ");
        maintenance2.setFacilityID(userInput.nextLine());
        System.out.print("Maintenance type: ");
        maintenance2.setMaintenanceType(userInput.nextLine());
        System.out.print("Maintenance description: ");
        maintenance2.setMaintenanceDesc(userInput.nextLine());
        System.out.print("Date required (yyyy-mm-dd): ");
        String date2 = userInput.nextLine();
        Date requiredDate1 = format.parse(date2);
        maintenance2.setRequiredDate(requiredDate1);
        
        //Date now2 = new Date();
        //maintenance2.setRequestDate(now2);

        System.out.print("\nFacility ID: ");
        maintenance3.setFacilityID(userInput.nextLine());
        System.out.print("Maintenance type: ");
        maintenance3.setMaintenanceType(userInput.nextLine());
        System.out.print("Maintenance description: ");
        maintenance3.setMaintenanceDesc(userInput.nextLine());
        System.out.print("Date required (yyyy-mm-dd): ");
        String date3 = userInput.nextLine();
        Date requiredDate2 = format.parse(date3);
        maintenance3.setRequiredDate(requiredDate2);
        
        //Date now3 = new Date();
        //maintenance3.setRequestDate(now3);

        appointment.enqueue(maintenance);
        appointment.enqueue(maintenance2);
        appointment.enqueue(maintenance3);
        
        System.out.print("Remove element: ");
        System.out.println(appointment.getElement(userInput.nextInt()));
        //appointment.remove(appointment.getElement(userInput.nextInt()));
        

        System.out.println("                                            Maintenance Appointment Queue\n");
        System.out.printf("%-10s %-15s %-25s %-20s %-30s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Required Date | ", "Request Timestamp");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println(appointment);

        //schedule.desc();
        //System.out.println("Get position of maintenance 1: " + appointment.getPosition(maintenance));

        System.out.println("Queue is empty: " + appointment.isEmpty());

        System.out.println("Total elements in queue: " + appointment.getTotalEntry());

        System.out.println("Element at front: " + appointment.getFront());

        System.out.println("Cancel a schedule: ");
        //appointment.remove(userInput.nextInt());

        appointment.dequeue();
        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Required Date | ", "Request Timestamp");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(appointment);

        try {
            File file = new File("MaintenanceSchedule.dat");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(maintenance);
            //closing the stream  
            out.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
