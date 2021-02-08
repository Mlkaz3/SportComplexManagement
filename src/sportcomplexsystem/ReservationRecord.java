/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportcomplexsystem;

import java.util.Date;

/**
 *
 * @author winnieyap
 */
public class ReservationRecord {
    //field
    private String reservationID;
    private Date reservationDate;
    private Date reservationTime;
    private Double reservationDuration;
    private User user;
    private Facility facilities;
    private Equipment equipments;
         
    //method
    void calculateDuration(){}
    void calculatePenalty(){}
    void insertRecord(){}
    void updateRecord(){}
    void deleteRecord(){}
    void filterRecord(){}
    
}
