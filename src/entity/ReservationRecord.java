/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author winnieyap
 *
 * Comparable<ReservationRecord>,
 */
public class ReservationRecord implements Comparable<ReservationRecord>, Serializable {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static int nextNumber = 1000;
    private String reservationID;
    private String reservationType;
    private Date reservationDateTime; //time where student start to use an equipment or facilities
    private Date reservationEndTime; //time where student end to use an equipment or facilities
    private Double reservationDuration; //start time - end time, but user might late return; or do function that generate duration after user return
    private String status;
    private User user; //user info
    private Facility facilities; //facilities info
    private Equipment equipments; //equipment info
    private Date checkOutDateTime; //when user return

    public ReservationRecord() {
        this.reservationID = String.valueOf(nextNumber++);
    }

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
    }

    double calculateDuration(Date reservationStartTime, Date reservationEndTime) {
        double difference_In_Time = reservationEndTime.getTime() - reservationStartTime.getTime();
        return (difference_In_Time / (1000 * 60 * 60)) % 24; //return in hour
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

    public Equipment getEquipments() {
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
                return String.format("%-42s %-15s %-20s %-20s %-20s %-10s", " #" + reservationID + " of " + equipments.getEquipmentBrand() + " " + equipments.getEquipmentType(), "Pending",
                        formatter.format(reservationDateTime), formatter.format(reservationEndTime), "-", user.getUserID());
            }
            return String.format(" %-40s %-15s %-20s %-20s %-20s %-10s", " #" + reservationID + " of " + facilities.getFacilityType(), "Pending",
                    formatter.format(reservationDateTime), formatter.format(reservationEndTime), "-", user.getUserID());

        } else {
            if (facilities == null) {
                return String.format("%-42s %-15s %-20s %-20s %-20s %-10s", " #" + reservationID + " of " + equipments.getEquipmentBrand() + " " + equipments.getEquipmentType(), "Pending",
                        formatter.format(reservationDateTime), formatter.format(reservationEndTime), formatter.format(checkOutDateTime), user.getUserID());
            }
            return String.format(" %-40s %-15s %-20s %-20s %-20s %-10s", " #" + reservationID + " of " + facilities.getFacilityType(), "Pending",
                    formatter.format(reservationDateTime), formatter.format(reservationEndTime), formatter.format(checkOutDateTime), user.getUserID());

        }

    }

    @Override
    public int compareTo(ReservationRecord o) {
        //return this.getReservationStartTime().compareTo(o.getReservationStartTime());
        return this.reservationDateTime.compareTo(o.reservationDateTime);
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
        this.reservationDuration = 10.0;
        this.user = user;
        this.equipments = equipments;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Equipments";
    }
}
