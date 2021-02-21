/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author YJ
 */
public class Maintenance implements Serializable {
    
    private Facility facility;
    private Equipment equipment;
    private String maintenanceID;
    private String maintenanceType;
    private String maintenanceDesc;
    private double maintenanceCost;
    private Calendar startDate;
    private Calendar endDate;

    public Maintenance(Facility facility, String maintenanceID, String maintenanceType, String maintenanceDesc, double maintenanceCost, Calendar startDate) {
        this.facility = facility;
        this.maintenanceID = maintenanceID;
        this.maintenanceType = maintenanceType;
        this.maintenanceDesc = maintenanceDesc;
        this.maintenanceCost = maintenanceCost;
        this.startDate = startDate;
    }
}
