/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ArrayPriorityQueue;
import entity.Maintenance;
import adt.PriorityQueueInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author YJ
 */
public class TestArrayPriorityQueue {

    public static void main(String[] args) throws ParseException {

        PriorityQueueInterface<Maintenance> schedule = new ArrayPriorityQueue<>();

        Maintenance maintenance = new Maintenance();
        Maintenance maintenance2 = new Maintenance();
        Maintenance maintenance3 = new Maintenance();
        Maintenance maintenance4 = new Maintenance();

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

        //System.out.print("Maintenance cost: ");
        //maintenance2.setMaintenanceCost(userInput.nextDouble());
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

        schedule.enqueue(maintenance);
        schedule.enqueue(maintenance2);
        schedule.enqueue(maintenance3);

        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Maintenance cost");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(schedule);
        
        System.out.println("Queue is empty: " + schedule.isEmpty());
        
        System.out.println("Queue is full: " + schedule.isFull());
        
        System.out.println("Total elements in queue: " + schedule.getTotalEntry());
        
        System.out.println("Element at front: " + schedule.getFront());

        System.out.println("Cancel a schedule: ");
        schedule.remove(userInput.nextInt());

        schedule.dequeue();
        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Maintenance cost");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(schedule);
        
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
