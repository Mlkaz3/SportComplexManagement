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
        
        PriorityQueueInterface<String> s1 = new ArrayPriorityQueue<>();

        s1.enqueue("F007");
        s1.enqueue("F003");
        s1.enqueue("F002");
        s1.enqueue("F005");
        s1.enqueue("F004");
        System.out.println("Queue: \n" + s1);
        s1.remove("F002");
        s1.remove("F001");
        System.out.println("Queue after removing F002: \n" + s1);
        s1.dequeue();
        System.out.println("Queue after serving the first in the queue: \n" + s1);
        System.out.println("Position of F004: " + s1.getPosition("F004"));
        System.out.println("\nQueue is empty: " + s1.isEmpty());
        System.out.println("\nPosition of F007: " + s1.getPosition("F007"));
        System.out.println("\nTotal number of schedules in queue: " + s1.getTotalEntry());

//        Comparator<Integer> priorityComparator = new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        };

        PriorityQueueInterface<Maintenance> schedule = new ArrayPriorityQueue<>();
        
        Maintenance maintenance = new Maintenance();
        Maintenance maintenance2 = new Maintenance();
        
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nFacility ID: ");
        maintenance.setFacility(userInput.nextLine());
        System.out.print("Maintenance type: ");
        maintenance.setMaintenanceType(userInput.nextLine());
        System.out.print("Maintenance description: ");
        maintenance.setMaintenanceDesc(userInput.nextLine());
        System.out.print("Maintenance cost: ");
        maintenance.setMaintenanceCost(userInput.nextDouble());
        
        schedule.enqueue(maintenance);
        
        System.out.print("\nFacility ID: ");
        maintenance2.setFacility(userInput.nextLine());
        System.out.print("Maintenance type: ");
        maintenance2.setMaintenanceType(userInput.nextLine());
        System.out.print("Maintenance description: ");
        maintenance2.setMaintenanceDesc(userInput.nextLine());
        System.out.print("Maintenance cost: ");
        maintenance2.setMaintenanceCost(userInput.nextDouble());
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
