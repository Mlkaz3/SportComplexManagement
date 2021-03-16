/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedPriorityQueue;
import adt.PriorityQueueInterface;
import entity.Facility;
import entity.Maintenance;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author YJ
 */
public class MaintenanceManagement {

    //NOT YET FORMAT OUTPUT
    
    PriorityQueueInterface<Maintenance> appointmentQueue;
    Maintenance maintenance;
    //Reference to andrew's list adt
    Facility facility;

    public MaintenanceManagement() {
        appointmentQueue = new LinkedPriorityQueue<>();
        maintenance = new Maintenance();
    }
    
    //display
    public void display() {
        System.out.println(appointmentQueue);
        
        //check position
        //get front
        //get total entry
        //or back
        System.out.println("Get position of maintenance 1: " + appointmentQueue.getPosition(maintenance));
        System.out.println("Queue is empty: " + appointmentQueue.isEmpty());
        System.out.println("Total elements in queue: " + appointmentQueue.getTotalEntry());
        System.out.println("Element at front: " + appointmentQueue.getFront());
    }
    
    //insert appointment
    public void addAppt() throws ParseException {
        
        Scanner userInput = new Scanner(System.in);
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
        maintenance.setRequestDate(new GregorianCalendar());
    }

    //serve appointment
    public void serveFront() {
        appointmentQueue.dequeue();
        //write to andrew's list
        maintenance.setStartDate(new GregorianCalendar());
        //Facility.setStatus(false);
    }

    //cancel appointment
    public void cancelAppt() {
        appointmentQueue.toString();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Cancel an appointment: ");
        appointmentQueue.remove(userInput.nextInt());
    }

    //edit appointment details
    public void editAppt() {
        //no idea how to do yet
    }

    //manage completed maintenance (write endDate, set status = true, calcDuration & cost)
    public void manageCompletion() {
        maintenance.setEndDate(new GregorianCalendar());
        //Facility.setStatus(true);
        maintenance.calcDuration();
        maintenance.calcCost();
    }
    
    //ARE THESE NECCESSARY? --->
  
    //sort in descending order
    public void sortDesc() {
        appointmentQueue.desc();
        System.out.println(appointmentQueue);
        //turn back
    }
    
    public void sortAsc() {
        
    }
    
    //check the position of element in the queue
    private void checkPosition() {
        
    }
    
    //check element at the front of the queue
    private void checkFront() {
        
    }

}
        