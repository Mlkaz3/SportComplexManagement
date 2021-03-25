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
        //ListInter<Facility> facility2 = new ArrList<>();
        

        Facility badmintonCourt1 = new Facility(); //"F001", "repair", "desc", 200.00, 19-06-2000
        Facility badmintonCourt2 = new Facility();
        Facility badmintonCourt3 = new Facility();
        Facility badmintonCourt4 = new Facility();
        Facility badmintonCourt5 = new Facility();
        Facility tennisCourt1 = new Facility(); //"F002", "replace", "abc", 400.00, 06-06-2000
        Facility tennisCourt2 = new Facility();
        Facility tennisCourt3 = new Facility();
        Facility tennisCourt4 = new Facility();
        Facility tennisCourt5 = new Facility();

        Scanner userInput = new Scanner(System.in);
        
        badmintonCourt1.setFacilityID("B001");
        badmintonCourt1.setFacilityName("Badminton Court 1");
        badmintonCourt1.setFacilityType("Badminton");
        badmintonCourt1.setFacilityAvailability("Yes");
        badmintonCourt1.setTimeSlot("11.00");
        
        badmintonCourt2.setFacilityID("B002");
        badmintonCourt2.setFacilityName("Badminton Court 2");
        badmintonCourt2.setFacilityType("Badminton");
        badmintonCourt2.setFacilityAvailability("Yes");
        badmintonCourt2.setTimeSlot("11.00");
        
        tennisCourt1.setFacilityID("T001");
        tennisCourt1.setFacilityName("Tennis Court 1");
        tennisCourt1.setFacilityType("Tennis");
        tennisCourt1.setFacilityAvailability("Yes");
        tennisCourt1.setTimeSlot("11.00");
        
        tennisCourt2.setFacilityID("T002");
        tennisCourt2.setFacilityName("Tennis Court 2");
        tennisCourt2.setFacilityType("Tennis");
        tennisCourt2.setFacilityAvailability("No");
        tennisCourt2.setTimeSlot("11.00");
        
        System.out.println("Choose the type of Court");
        input_Type = userInput.nextLine();
        System.out.println("Choose the ID of Court");
        input_ID = userInput.nextLine();
        

        facility.add(0,badmintonCourt1);
        //facility.add(1,badmintonCourt2);
        //facility.get(1);
        System.out.println(facility.isEmpty());
        System.out.println(facility.size());

        System.out.println(facility.get(0));
        
        }
}
