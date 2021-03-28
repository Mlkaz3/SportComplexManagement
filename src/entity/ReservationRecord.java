/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author winnieyap
 *
 * Comparable<ReservationRecord>,
 */
public class ReservationRecord implements Serializable {

    private static int nextNumber = 1000;
    private String reservationID;
    private String reservationType;
    private String status;
    private Date reservationDateTime;
    private Date reservationEndTime;
    private Date checkOutDateTime;
    private double reservationDuration;
    private double penaltyRate = 8.00;
    private double lateHour;
    private boolean isExtend;
    private User user;
    private Facility facilities;
    private Equipment equipments;

    //for facilities constructor needa pass in start time and end time 
    public ReservationRecord(Date reservationEndTime, User user, Facility facilities) {
        //Date date = new Date(); 
        this.reservationDateTime = new Date();
        this.reservationEndTime = reservationEndTime;
        this.reservationDuration = calculateDuration(this.reservationDateTime, this.reservationEndTime);
        this.user = user;
        this.facilities = facilities;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Facilities";
        this.status = "Pending";
        this.checkOutDateTime = null;
        this.lateHour = 0.0;
        this.isExtend = false;

    }
    //for equipment constructor 

    public ReservationRecord(Date reservationEndTime, User user, Equipment equipments) {
        this.reservationDateTime = new Date();
        this.reservationEndTime = reservationEndTime;
        this.reservationDuration = calculateDuration(this.reservationDateTime, this.reservationEndTime);
        this.user = user;
        this.equipments = equipments;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Equipments";
        this.status = "Pending";
        this.checkOutDateTime = null;
        this.lateHour = 0.0;
        this.isExtend = false;
       
    }

    public static int getNextNumber() {
        return nextNumber;
    }

    public static void setNextNumber(int nextNumber) {
        ReservationRecord.nextNumber = nextNumber;
    }

    
    double calculateDuration(Date reservationStartTime, Date reservationEndTime) {
        double difference_In_Time = reservationEndTime.getTime() - reservationStartTime.getTime();
        return (difference_In_Time / (1000 * 60 * 60)) % 24; //return in hour
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public String getReservationID() {
        return reservationID;
    }

    //reservation ID versus registration ID
    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public Date getReservationDate() {
        return reservationDateTime;
    }

    public boolean isIsExtend() {
        return isExtend;
    }

    public void setIsExtend(boolean isExtend) {
        this.isExtend = isExtend;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDateTime = reservationDate;
    }

    public Date getReservationStartTime() {
        return reservationDateTime;
    }

    public void setReservationStartTime(Date reservationStartTime) {
        this.reservationDateTime = reservationStartTime;
    }

    public Date getReservationEndTime() {
        return reservationEndTime;
    }

    public void setReservationEndTime(Date reservationEndTime) {
        this.reservationEndTime = reservationEndTime;
    }

    public Double getReservationDuration() {
        return reservationDuration;
    }

    public double getPenaltyRate() {
        return penaltyRate;
    }

    public double calculatePenalty() {
        return lateHour * penaltyRate;
    }

    public void setLateHour(double lateHour) {
        this.lateHour = lateHour;
    }

    public double getLateHour() {
        return lateHour;
    }

    public Date getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCheckOutDateTime(Date checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Facility getFacilities() {
        return facilities;
    }

    public void setFacilities(Facility facilities) {
        this.facilities = facilities;
    }

    public Equipment getEquipment() {
        return equipments;
    }

    public void setEquipments(Equipment equipments) {
        this.equipments = equipments;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        //checking check out time
        if (checkOutDateTime == null) {
            if (facilities == null) {
                return String.format("%-42s %-15s %-20s %-20s %-20s %-10s",
                        " #" + reservationID + " of " + equipments.getEquipmentBrand() + " " + equipments.getEquipmentType(),
                        status,
                        formatter.format(reservationDateTime), 
                        formatter.format(reservationEndTime), 
                        "-",
                        user.getUserID());
            }
            return String.format("%-42s %-15s %-20s %-20s %-20s %-10s",
                    " #" + reservationID + " of " + facilities.getFacilityName(), 
                    status,
                    formatter.format(reservationDateTime), 
                    formatter.format(reservationEndTime),
                    "-", 
                    user.getUserID());
        } else {
            if (facilities == null) {
                return String.format("%-42s %-15s %-20s %-20s %-20s %-10s", " #" + reservationID + " of " + equipments.getEquipmentBrand() + " " + equipments.getEquipmentType(), status,
                        formatter.format(reservationDateTime), formatter.format(reservationEndTime), formatter.format(checkOutDateTime), user.getUserID());
            }
            return String.format("%-42s %-15s %-20s %-20s %-20s %-10s", " #" + reservationID + " of " + facilities.getFacilityID(), status,
                    formatter.format(reservationDateTime), formatter.format(reservationEndTime), formatter.format(checkOutDateTime), user.getUserID());
        }
    }

    public ReservationRecord(User user, Facility facilities) {
        //Date date = new Date(); 
        this.reservationDateTime = new Date();
        this.reservationDateTime = new Date();
        this.reservationEndTime = new Date();
        this.reservationDuration = 10.0;
        this.user = user;
        this.facilities = facilities;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Facilities";
    }

    public ReservationRecord(User user, Equipment equipments) {
        this.reservationDateTime = new Date();
        this.reservationDateTime = new Date();
        this.reservationEndTime = reservationDateTime;
        this.reservationDuration = calculateDuration(this.reservationDateTime, this.reservationEndTime);
        this.user = user;
        this.equipments = equipments;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Equipments";
    }

    //this is for debug purpose
    public ReservationRecord(Date startTime, Date reservationEndTime, User user, Equipment equipments) {
        this.reservationDateTime = startTime;
        this.reservationEndTime = reservationEndTime;
        this.reservationDuration = calculateDuration(this.reservationDateTime, this.reservationEndTime);
        this.user = user;
        this.equipments = equipments;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Equipments";
        this.status = "Pending";
        this.checkOutDateTime = null;
        this.lateHour = 0.0;
    }

}
