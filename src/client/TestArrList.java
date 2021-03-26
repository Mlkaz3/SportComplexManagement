/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ArrList;

import adt.ListInter;

import entity.Facility;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class TestArrList {
        public static void main(String[] args) throws ParseException {

        String input_Type;
        String input_ID;
        
            
        ListInter<Facility> facility = new ArrList<>();

        //This is for list
        Facility badmintonCourt1 = new Facility(); //"F001", "repair", "desc", 200.00, 19-06-2000
        Facility badmintonCourt2 = new Facility();
        Facility badmintonCourt3 = new Facility();
        Facility badmintonCourt4 = new Facility();
        Facility badmintonCourt5 = new Facility();
        Facility badmintonCourt6 = new Facility();
        Facility tennisCourt1 = new Facility(); //"F002", "replace", "abc", 400.00, 06-06-2000
        Facility tennisCourt2 = new Facility();
        Facility tennisCourt3 = new Facility();
        Facility tennisCourt4 = new Facility();
        Facility tennisCourt5 = new Facility();

        Scanner userInput = new Scanner(System.in);
        
        badmintonCourt1.setFacilityID("B001");
        badmintonCourt1.setFacilityName("Badminton Court 1");
        badmintonCourt1.setFacilityType("Badminton");
        badmintonCourt1.setFacilityAvailability(true);
        badmintonCourt1.setTimeSlot("11.00");
        
        badmintonCourt2.setFacilityID("B002");
        badmintonCourt2.setFacilityName("Badminton Court 2");
        badmintonCourt2.setFacilityType("Badminton");
        badmintonCourt2.setFacilityAvailability(true);
        badmintonCourt2.setTimeSlot("11.00");
        
        badmintonCourt3.setFacilityID("B003");
        badmintonCourt3.setFacilityName("Badminton Court 3");
        badmintonCourt3.setFacilityType("Badminton");
        badmintonCourt3.setFacilityAvailability(true);
        badmintonCourt3.setTimeSlot("11.00");
        
        badmintonCourt4.setFacilityID("B004");
        badmintonCourt4.setFacilityName("Badminton Court 4");
        badmintonCourt4.setFacilityType("Badminton");
        badmintonCourt4.setFacilityAvailability(true);
        badmintonCourt4.setTimeSlot("11.00");
        
        badmintonCourt5.setFacilityID("B005");
        badmintonCourt5.setFacilityName("Badminton Court 5");
        badmintonCourt5.setFacilityType("Badminton");
        badmintonCourt5.setFacilityAvailability(true);
        badmintonCourt5.setTimeSlot("11.00");
        

        tennisCourt1.setFacilityID("T001");
        tennisCourt1.setFacilityName("Tennis Court 1");
        tennisCourt1.setFacilityType("Tennis");
        tennisCourt1.setFacilityAvailability(true);
        tennisCourt1.setTimeSlot("11.00");
        
        tennisCourt2.setFacilityID("T002");
        tennisCourt2.setFacilityName("Tennis Court 2");
        tennisCourt2.setFacilityType("Tennis");
        tennisCourt2.setFacilityAvailability(false);
        tennisCourt2.setTimeSlot("11.00");
        
        tennisCourt3.setFacilityID("T003");
        tennisCourt3.setFacilityName("Tennis Court 3");
        tennisCourt3.setFacilityType("Tennis");
        tennisCourt3.setFacilityAvailability(false);
        tennisCourt3.setTimeSlot("11.00");
        
        tennisCourt4.setFacilityID("T004");
        tennisCourt4.setFacilityName("Tennis Court 4");
        tennisCourt4.setFacilityType("Tennis");
        tennisCourt4.setFacilityAvailability(false);
        tennisCourt4.setTimeSlot("11.00");
        
        tennisCourt5.setFacilityID("T005");
        tennisCourt5.setFacilityName("Tennis Court 5");
        tennisCourt5.setFacilityType("Tennis");
        tennisCourt5.setFacilityAvailability(false);
        tennisCourt5.setTimeSlot("11.00");
        
        System.out.println("Choose the type of Court");
        input_Type = userInput.nextLine();
        System.out.println("Choose the ID of Court");
        input_ID = userInput.nextLine();
        

       facility.add(badmintonCourt1);
       facility.add(badmintonCourt2);
       facility.add(badmintonCourt3);
       facility.add(badmintonCourt4);
       facility.add(badmintonCourt5);

       facility.add(tennisCourt1);
       facility.add(tennisCourt2);
       facility.add(tennisCourt3);
       facility.add(tennisCourt4);
       facility.add(tennisCourt5);
       

        for(int i = 0; i < facility.filledSize() ; i++){
            System.out.println(i);
            System.out.println(facility.get(i));}
        
        System.out.println(facility.isEmpty());
        System.out.println(facility.filledSize());

        int selection;
       /***************************************************/

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - View available room");
        System.out.println("2 - Add Court");
        System.out.println("3 - Remove Court");
        System.out.println("4 - Add Reservation");
        System.out.println("5 - Remove Court");
        System.out.println("6 - Quit");

        selection = userInput.nextInt();
  
        switch(selection){
            case 1:
                for(int i = 0; i < facility.filledSize() ; i++){
                    System.out.println(i);
                    System.out.println(facility.get(i));}
                break;
            case 2:
                String courtName;
                String facilityID;
                String facilityName;
                String facilityType;
                Boolean facilityAvailability = true;
                String timeSlot = "11.00";
                
  
                System.out.println("Enter facility ID: ");
                facilityID = userInput.nextLine();
                
                System.out.println("Enter facility name: ");
                facilityName = userInput.nextLine();
                
                System.out.println("Enter facility type: ");
                facilityType = userInput.nextLine();
                
                System.out.println("Enter timeSlot: ");
                timeSlot = userInput.nextLine(); 
                
                System.out.println(facility.get(1).getFacilityID());
                Facility newFacility = new Facility(facilityID,facilityName,facilityType,facilityAvailability,timeSlot);
                facility.add(newFacility);
                

                break;
            case 3:
                
                String facilityRemove;
                System.out.println("Enter remove facility ID: ");
                facilityRemove = userInput.nextLine();
                
                System.out.println("Enter remove facility ID: ");
                facilityRemove = userInput.nextLine();
                
                for(int i = 0; i < facility.filledSize() ; i++){
  
                    String currentID = facility.get(i).getFacilityID();
                    if(currentID == facilityRemove){
                        facility.remove(i);
                    };
}
                break;
            case 4:
            String requestID;
            System.out.println("Enter request facility ID: ");
            requestID = userInput.nextLine();
            
            System.out.println("Enter request facility ID: ");
            requestID = userInput.nextLine();
            
            for(int i = 0; i < facility.filledSize() ; i++){
                System.out.println(i);
                System.out.println(facility.get(i));}
                
                break; 
            case 5:
                break;
            case 6:
                break;
        } 

        
        }
        

}
