/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author winnieyap
 */
public class ReservationRecord implements Comparable<ReservationRecord> {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    //registrations number start from 1000
    private static int nextNumber = 1000;
    //field
    private String reservationID; //a unique id to verify reservation R0000000001 , this is computerised 
    private String reservationType; //computerised

    private Date reservationDateTime; //time where this record is generated

    private Date reservationStartTime; //time where student start to use an equipment or facilities
    private Date reservationEndTime; //time where student end to use an equipment or facilities
    private Double reservationDuration; //start time - end time, but user might late return; or do function that generate duration after user return
    private String status; //to store the status of a reservation, which can be success or failure due to cancelation/ not turn up to register, it can be staff input too 
    //other object
    private User user; //user info
    private Facility facilities; //facilities info
    private Equipment equipments; //equipment info

    //might having a penalty but soon 
    //private penaltyRate;
    //private overdueDuration;
    //empty constructor
    public ReservationRecord() {
        this.reservationID = String.valueOf(nextNumber++);
    }

    //for facilities constructor needa pass in start time and end time 
    public ReservationRecord(Date reservationStartTime, Date reservationEndTime, User user, Facility facilities) {
        //Date date = new Date(); 
        this.reservationDateTime = new Date();
        this.reservationStartTime = new Date();
        this.reservationEndTime = new Date();
        this.reservationDuration = calculateDuration(this.reservationStartTime, this.reservationEndTime);
        this.user = user;
        this.facilities = facilities;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Facilities";
    }

    public ReservationRecord(User user, Facility facilities) {
        //Date date = new Date(); 
        this.reservationDateTime = new Date();
        this.reservationStartTime = new Date();
        this.reservationEndTime = new Date();
        this.reservationDuration = 10.0;
        this.user = user;
        this.facilities = facilities;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Facilities";
    }

    double calculateDuration(Date reservationStartTime, Date reservationEndTime) {
        double difference_In_Time = reservationEndTime.getTime() - reservationStartTime.getTime();
        return (difference_In_Time / (1000 * 60 * 60)) % 24; //return in hour
    }

    //for equipment constructor 
    public ReservationRecord(Date reservationStartTime, Date reservationEndTime, User user, Equipment equipments) {
        this.reservationDateTime = new Date();
        this.reservationStartTime = new Date();
        this.reservationEndTime = reservationStartTime;
        this.reservationDuration = calculateDuration(this.reservationStartTime, this.reservationEndTime);
        this.user = user;
        this.equipments = equipments;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Equipments";
    }
    
        public ReservationRecord(User user, Equipment equipments) {
        this.reservationDateTime = new Date();
        this.reservationStartTime = new Date();
        this.reservationEndTime = reservationStartTime;
        this.reservationDuration = 10.0;
        this.user = user;
        this.equipments = equipments;
        this.reservationID = String.valueOf(nextNumber++);
        this.reservationType = "Equipments";
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
        return reservationStartTime;
    }

    public void setReservationStartTime(Date reservationStartTime) {
        this.reservationStartTime = reservationStartTime;
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

    public void setReservationDuration(Double reservationDuration) {
        this.reservationDuration = reservationDuration;
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

    //update the facilities if user booked wrongly 
    public void setFacilities(Facility facilities) {
        this.facilities = facilities;
    }

    public Equipment getEquipments() {
        return equipments;
    }

    //update the equipment if user booked wrongly 
    public void setEquipments(Equipment equipments) {
        this.equipments = equipments;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        //formatting the date 
        if (facilities == null) {
//            return "ReservationRecord{" + "reservationID=" + reservationID + ", reservationType="
//                    + reservationType + ", reservationDateTime=" + reservationDateTime + ", reservationStartTime="
//                    + reservationStartTime + ", reservationEndTime=" + reservationEndTime + ", reservationDuration="
//                    + reservationDuration + ", user=" + user + ", equipments=" + equipments + '}';

//            return String.format(" %-15s %-20s %-30s %-30s %-30s %-20f %-20s %-20s", reservationID,reservationType,
//            reservationDateTime,formatter.format(reservationStartTime),formatter.format(reservationEndTime),reservationDuration,
//            user.getUserName(),equipments.getEquipmentType());
            return String.format("%-42s %-15s %-20s %-20s %-20s %-10s", " #" + reservationID + " of " + equipments.getEquipmentBrand() + " " + equipments.getEquipmentType(), "Pending",
                    formatter.format(reservationStartTime), formatter.format(reservationEndTime), formatter.format(reservationDateTime), user.getUserID());

            /*expected output
            Booking                  Status          From                   To                      Date
            #ID of Items booked      Pending         22/3/2021 08:00AM      22/3/2021 09:00AM       2 mins ago
            
            
             */
        }

//        return "ReservationRecord{" + "reservationID=" + reservationID + ", reservationType="
//                + reservationType + ", reservationDateTime=" + reservationDateTime + ", reservationStartTime="
//                + formatter.format(reservationStartTime) + ", reservationEndTime=" + formatter.format(reservationEndTime) + ", reservationDuration="
//                + reservationDuration + ", user=" + user + ", facilities=" + facilities + '}';
        return String.format(" %-40s %-15s %-20s %-20s %-20s %-10s", " #" + reservationID + " of " + facilities.getFacilityType(), "Pending",
                formatter.format(reservationStartTime), formatter.format(reservationEndTime), formatter.format(reservationDateTime), user.getUserID());

    }

    //method
    void checkIn() {
    }

    void checkOut() {
    }

    void reserve() {
    }

    void alter() {
    }

    void cancel() {
    }

    void calculatePenalty() {
    }

    void insertRecord() {
    }

    void updateRecord() {
    }

    void deleteRecord() {
    }

    void filterRecord() {
    }

    @Override
    public int compareTo(ReservationRecord o) {
        return this.getReservationStartTime().compareTo(o.getReservationStartTime());
    }
//
//    static class ReservedStartTimeSortingComparator implements Comparator<ReservationRecord> {
//        // Used for sorting in ascending order of
//        // Reservation Start Time
//
//        public int compare(ReservationRecord a, ReservationRecord b) {
//            return a.getReservationStartTime().compareTo(b.getReservationStartTime());
//        }
//    }

}
