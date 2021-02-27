/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ArrayPriorityQueue;
import adt.PriorityComparator;
import entity.Maintenance;
import adt.PriorityQueueInterface;
import java.util.Scanner;

/**
 *
 * @author YJ
 */
public class TestArrayPriorityQueue {

    public static void main(String[] args) {

        PriorityQueueInterface<Maintenance> schedule = new ArrayPriorityQueue<>(10, new PriorityComparator());

        Maintenance maintenance = new Maintenance("repair", "desc", 200.00, "2020-03-25");
        Maintenance maintenance2 = new Maintenance("replace", "abc", 200.00, "2020-01-25");

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




//        PriorityQueueInterface<String> s1 = new ArrayPriorityQueue<>();
//        s1.enqueue("F007");
//        s1.enqueue("F003");
//        s1.enqueue("F002");
//        s1.enqueue("F005");
//        s1.enqueue("F004");
//        System.out.println("Queue: \n" + s1);
//        System.out.println("Queue after removing F002: \n" + s1);
//        s1.dequeue();
//        System.out.println("Queue after serving the first in the queue: \n" + s1);
//        System.out.println("Position of F004: " + s1.getPosition("F004"));
//        System.out.println("\nQueue is empty: " + s1.isEmpty());
//        System.out.println("\nTotal number of schedules in queue: " + s1.getTotalEntry());
//        Comparator<Integer> priorityComparator = new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        };
