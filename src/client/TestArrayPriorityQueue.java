/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ArrayPriorityQueue;
import entity.Maintenance;
import adt.PriorityQueueInterface;
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

        Maintenance maintenance = new Maintenance(); //"F001", "repair", "desc", 200.00, 19-06-2000
        Maintenance maintenance2 = new Maintenance(); //"F002", "replace", "abc", 400.00, 06-06-2000

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
        System.out.print("Date required: ");
        String date = userInput.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date requiredDate = format.parse(date);
        maintenance.setRequiredDate(requiredDate);

        schedule.enqueue(maintenance);
        //schedule.enqueue(maintenance2);

        System.out.print("\nFacility ID: ");
        maintenance2.setFacilityID(userInput.nextLine());
        System.out.print("Maintenance type: ");
        maintenance2.setMaintenanceType(userInput.nextLine());
        System.out.print("Maintenance description: ");
        maintenance2.setMaintenanceDesc(userInput.nextLine());
        System.out.print("Date required: ");
        String date2 = userInput.nextLine();
        Date requiredDate1 = format.parse(date2);
        maintenance2.setRequiredDate(requiredDate1);
        
        
        //System.out.print("Maintenance cost: ");
        //maintenance2.setMaintenanceCost(userInput.nextDouble());
        schedule.enqueue(maintenance2);

        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Maintenance cost");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(schedule);

        schedule.dequeue();
        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Maintenance cost");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(schedule);

    }

}
