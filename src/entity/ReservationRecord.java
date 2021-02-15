/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author winnieyap
 */
public class ReservationRecord {
    //field
    private User user;
    private Facility facilities;
    private Equipment equipments;
    private String reservationID; //a unique id to verify reservation R0000000001
    private Date reservationDate; //
    private Date reservationStartTime; //student set it or???
    private Date reservationEndTime;
    private Double reservationDuration; //
    
         
    //method
    void checkIn(){}
    void checkOut(){}
    void reserve(){}
    void alter(){}
    void cancel(){}
    
    
    void calculateDuration(){}
    void calculatePenalty(){}
    void insertRecord(){}
    void updateRecord(){}
    void deleteRecord(){}
    void filterRecord(){}
    
}
