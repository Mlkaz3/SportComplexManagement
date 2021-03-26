/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ArrList;
import adt.LinkedList;
import entity.Facility;
import entity.ReservationRecord;



/**
 *
 * @author YJ
 */
public class Data {
    
    public static ArrList<Facility> court = new ArrList<Facility>();
    
    public static Facility facility = new Facility();
    
    public static LinkedList<ReservationRecord> reservationRecord = new LinkedList<>();
   
}
