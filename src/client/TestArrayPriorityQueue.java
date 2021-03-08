/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ArrayPriorityQueue;
import entity.Maintenance;
import adt.PriorityQueueInterface;
import java.util.Scanner;

/**
 *
 * @author YJ
 */
public class TestArrayPriorityQueue {

    public static void main(String[] args) {

        PriorityQueueInterface<Maintenance> schedule = new ArrayPriorityQueue<>();

        Maintenance maintenance = new Maintenance("F001", "repair", "desc", 200.00, 3);
        Maintenance maintenance2 = new Maintenance("F002", "replace", "abc", 400.00, 1);

//        Scanner userInput = new Scanner(System.in);
//        System.out.print("\nFacility ID: ");
//        maintenance.setFacility(userInput.nextLine());
//        System.out.print("Maintenance type: ");
//        maintenance.setMaintenanceType(userInput.nextLine());
//        System.out.print("Maintenance description: ");
//        maintenance.setMaintenanceDesc(userInput.nextLine());
//        System.out.print("Date required: ");
//        maintenance.setMaintenanceCost(userInput.nextDouble());

        schedule.enqueue(maintenance);
        schedule.enqueue(maintenance2);

//        System.out.print("\nFacility ID: ");
//        maintenance2.setFacility(userInput.nextLine());
//        System.out.print("Maintenance type: ");
//        maintenance2.setMaintenanceType(userInput.nextLine());
//        System.out.print("Maintenance description: ");
//        maintenance2.setMaintenanceDesc(userInput.nextLine());
//        System.out.print("Maintenance cost: ");
//        maintenance2.setMaintenanceCost(userInput.nextDouble());
//        schedule.enqueue(maintenance2);

        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Maintenance cost");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(schedule);

        schedule.dequeue();
        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Maintenance cost");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(schedule);

    }

}
