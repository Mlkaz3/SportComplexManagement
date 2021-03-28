package client;

/**
 *
 * @author Chen Chee Yong 19WMR11909
 */
import adt.ArrList;
import adt.ListInter;
import static client.SportComplexSystem.pressEnterKeyToContinue;
import static client.SportComplexSystem.usageManagement;
import entity.Facility;
import entity.ReservationRecord;
import entity.User;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FacilityManagement {

    ListInter<Facility> facility;
    Scanner userInput = new Scanner(System.in);

    public FacilityManagement() {
        facility = new ArrList<>();
    }

    public void displayCourt() {
        readFacility();
        System.out.println("                       List of Facilities");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-15s %-22s %-13s %-15s\n", "Facility ID", "Facility Name", "Type", "Availability");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 1; i <= facility.filledSize(); i++) {
            System.out.println(facility.get(i));
        }
        System.out.println("-----------------------------------------------------------------");

    }

    void add(Facility element) {
        facility.add(element);
        writeFacility();
    }

    public void addCourt() {
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

//        System.out.println("------------------------------------------------------------------------------");
//        System.out.printf("%-15s %-22s %-13s %-15s\n", "Facility ID", "Facility Name", "Type", "Availability");
//        System.out.println("------------------------------------------------------------------------------");
//        System.out.println(facility.get(1).getFacilityID());
        Facility newFacility = new Facility(facilityID, facilityName, facilityType, facilityAvailability);
        facility.add(newFacility);

        for (int i = 1; i <= facility.filledSize(); i++) {
//    System.out.println(i);
            System.out.println(facility.get(i));
        }
        System.out.println("------------------------------------------------------------------------------");

        System.out.println("Court Added Successfully.");

        writeFacility();
    }

    public void removeCourt() {
        readFacility();
        System.out.println("Enter remove facility ID: ");
        String facilityRemove = userInput.nextLine();
        for (int i = 1; i <= facility.filledSize(); i++) {
            String currentID = facility.get(i).getFacilityID();
            if (currentID.equals(facilityRemove)) {
                facility.remove(i);
            }
        }
        writeFacility();
        pressEnterKeyToContinue();
    }

    public void addReservation() throws ParseException {
        readFacility();
        System.out.println("Kindly insert ur personal info: ");
        System.out.print("Enter username: ");
        String userName = userInput.nextLine();
        System.out.print("Enter user ID: ");
        String userID = userInput.nextLine();
        System.out.print("Enter user category: ");
        String userCategory = userInput.nextLine();
        System.out.print("Enter user tel: ");
        String userTel = userInput.nextLine();
        User newuser = new User(userName, userID, userCategory, userTel);
        System.out.print("Enter request facility ID: ");
        String requestID = userInput.nextLine();
        for (int i = 1; i <= facility.filledSize(); i++) {
            String checkID = facility.get(i).getFacilityID();
            Boolean currentCourtAvai = facility.get(i).getFacilityAvailability();
            if (currentCourtAvai == true && checkID.equals(requestID)) {
                SimpleDateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                System.out.print("Enter End Time: ");
                String end_date = userInput.nextLine();
                Date endDate = (Date) myFormatObj.parse(end_date);
                //add a new reservation record 
                ReservationRecord record1 = new entity.ReservationRecord((Date) endDate, newuser, facility.get(i));
                if (usageManagement.addReservation(record1)) {
                    facility.get(i).setFacilityAvailability(false);
                }
            } else if (currentCourtAvai == false && checkID.equals(requestID)) {
                System.out.println("the room is not available");
            }
        }
        writeFacility();
    }

    public void returnDeleted(Facility deletedfacility) {
        readFacility();
        deletedfacility.setFacilityAvailability(true);
        facility.add(deletedfacility);
        writeFacility();
    }

    public void checkOut() {
        readFacility();
        System.out.print("Enter request reservation ID: ");
        String requestID = userInput.nextLine();
        //call a function that return equipment borrowed according to the reservation 
        ReservationRecord bookingitem;
        bookingitem = usageManagement.getBookingRecord(requestID); //retrieve the whole equipment obj 
        //update booking status 
        usageManagement.updateBookingStatus(bookingitem);
        //calculate penalty 
        usageManagement.getPenaltyCharges(requestID);
        String removeFacilityID;
        removeFacilityID = bookingitem.getFacilities().getFacilityID();
        for (int i = 1; i <= facility.filledSize(); i++) {
            String checkID = facility.get(i).getFacilityID();
            Boolean currentCourtAvai = facility.get(i).getFacilityAvailability();
            if (currentCourtAvai == false && checkID.equals(removeFacilityID)) {
                facility.get(i).setFacilityAvailability(true);
                System.out.println("Court successfully booked out");
            } else if (currentCourtAvai == true && checkID.equals(requestID)) {
                System.out.println("Room is not booked no booking out require");
            }
        }
        writeFacility();
    }

    //Read facility file
    public void readFacility() {
        try {
            FileInputStream fileIn = new FileInputStream("src/FacilityRecord.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            facility = (ArrList<Facility>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("No Equipment Record is found!");
            c.printStackTrace();
        }
    }

    //Write facility file
    public void writeFacility() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/FacilityRecord.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(facility);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
