package client;

import adt.ArrayStack;
import adt.StackInterface;
import adt.ArrayStackWithIteratorInterface;
import static client.SportComplexSystem.usageManagement;
import entity.Equipment;
import entity.User;
import entity.ReservationRecord;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EquipmentManagement {

    StackInterface<Equipment> equipmentStack = new ArrayStack<>();
    StackInterface<Equipment> brokenStack = new ArrayStack<>();

    Scanner input = new Scanner(System.in);

    public EquipmentManagement() {

    }

    public void displayStack() {
        serFileReader();

        if (equipmentStack.isEmpty()) {
            System.out.println("Sorry. There are no racquet left.");
        } else {
            System.out.println("                                                            Racquet");
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s\n",
                    "Equipment ID", "Equipment Brand", "Equipment Status", "Equipment Price", "Equipment Location", "Equipment Type");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            Iterator<Equipment> it = equipmentStack.getIterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println("\nThere are currently " + equipmentStack.size() + " racquet.");
        }
    }

    public void borrowEquipment() throws ParseException {
        //Read file
        serFileReader();

        //Declaring variables
        User user = new User();

        if (equipmentStack.isEmpty()) {
            System.out.println("Sorry. There are no racquet left.");
        } else {

            System.out.print("Enter Name : ");
            user.setUserName(input.nextLine());

            System.out.print("Enter User ID : ");
            user.setUserID(input.nextLine());

            System.out.print("Enter Category : ");
            user.setUserCategory(input.nextLine());

            System.out.print("Enter Tel : ");
            user.setUserTel(input.nextLine());

            SimpleDateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            System.out.print("Enter End Time (dd/MM/yyyy HH:mm) : ");
            String end_date = input.nextLine();
            Date endDate = (Date) myFormatObj.parse(end_date);

            Equipment equipment = equipmentStack.peek();
            ReservationRecord record1 = new entity.ReservationRecord((Date) endDate, user, equipment);
            if (usageManagement.addReservation(record1)) {
                equipment.setEquipmentStatus(false);
                System.out.println("");
                System.out.println("----------------------------------");
                System.out.println("Equipment ID : " + equipment.getEquipmentID());
                System.out.println("Equipment Brand : " + equipment.getEquipmentBrand());
                equipmentStack.pop();
                System.out.println("----------------------------------");
                System.out.println("Equipment successfully borrowed.");
            }
        }
        //Write to file
        serFileWriter();
    }

    public void returnEquipment() {
        System.out.print("Enter the reservation ID : ");
        String id = input.nextLine();

        //call a function that return equipment borrowed according to the reservation 
        ReservationRecord bookingitem;
        bookingitem = usageManagement.getBookingRecord(id); //retrieve the whole equipment obj 

        //Display the borrowed equipment 
        System.out.println("------------------");
        System.out.println("Borrowed item : ");
        System.out.println("------------------");
        System.out.println("Equipment ID : " + bookingitem.getEquipment().getEquipmentID());
        System.out.println("Equipment Brand : " + bookingitem.getEquipment().getEquipmentBrand());
        System.out.println("Equipment Status : " + bookingitem.getEquipment().getEquipmentStatus());
        System.out.println("");

        //update booking status 
        usageManagement.updateBookingStatus(bookingitem);

        //calculate penalty 
        usageManagement.getPenaltyCharges(id);

        //Check if racquet is broken
        System.out.println("Is the racquet broken? ->");
        System.out.println("\n[1] Yes");
        System.out.println("[2] No\n");
        int num;
        boolean valid = true;
        do {
            System.out.print("-> ");
            String ch = input.nextLine();

            try {
                num = Integer.parseInt(ch);
                switch (num) {
                    //if racquet broken, add to broken stack
                    case 1 -> {
                        readBrokenFile();
                        brokenStack.push(bookingitem.getEquipment());
                        System.out.println("Broken equipment received.");
                        writeBrokenFile();
                        viewBrokenStack();
                        valid = true;
                    }
                    //add back to equipment stack only when in good condition
                    case 2 -> {
                        serFileReader();
                        bookingitem.getEquipment().setEquipmentStatus(true);
                        equipmentStack.push(bookingitem.getEquipment());
                        System.out.println("Equipment Successfully Returned.");
                        serFileWriter();
                        valid = true;
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        System.out.println();
                        valid = false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError. Invalid input.");
                System.out.println();
                valid = false;
            }
        } while (valid != true);
    }

    public void stockIn() {
        //Declaring variables
        String id, brand, location, type;
        double price;
        boolean valid = true;
        int qty = 0;

        //Read from file
        serFileReader();

        do {
            System.out.print("Enter Quantity : ");
            String inputQty = input.nextLine();

            try {
                qty = Integer.parseInt(inputQty);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("\nError. Invalid input.\n");
                valid = false;
            }
        } while (valid != true);

        for (int i = 0; i < qty; i++) {
            System.out.print("\nEquipment ID : ");
            id = input.nextLine();

            System.out.print("Equipment Brand : ");
            brand = input.nextLine();

            System.out.print("Equipment Price : ");
            price = input.nextDouble();
            input.nextLine();

            System.out.print("Equipment Location : ");
            location = input.nextLine();

            System.out.print("Equipment Type : ");
            type = input.nextLine();

            boolean status = true;

            Equipment e = new Equipment(id, brand, status, price, location, type);
            if (equipmentStack.contains(e) == true) {
                System.out.println("This element is already in stack.");
            } else {
                equipmentStack.push(e);
                System.out.println("\nEquipment Inserted.");
            }
            serFileWriter();
        }
    }

    public void returnDeleted(Equipment equipment) {
        serFileReader();
        equipment.setEquipmentStatus(true);
        equipmentStack.push(equipment);
        serFileWriter();
    }

    //Clearing all equipments in broken stack
    public void clearAll() {
        readBrokenFile();
        if (brokenStack.isEmpty()) {
            System.out.println("There are no broken racquet currently.");
        } else {
            viewBrokenStack();

            System.out.println("Confirm clear all broken equipments? ->");
            System.out.println("\n[1] Yes");
            System.out.println("[2] No\n");
            int num;
            boolean valid = true;
            do {
                System.out.print("-> ");
                String ch = input.nextLine();

                try {
                    num = Integer.parseInt(ch);
                    switch (num) {
                        case 1 -> {
                            brokenStack.clear();
                            System.out.println("All broken equipment is removed.");
                            writeBrokenFile();
                            valid = true;
                        }
                        //add back to equipment stack only when in good condition
                        case 2 -> {
                            System.out.println("No equipments removed.");
                            valid = true;
                        }
                        default -> {
                            System.out.println();
                            System.out.println("Error. Please select a correct choice.");
                            System.out.println();
                            valid = false;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nError. Invalid input.");
                    System.out.println();
                    valid = false;
                }
            } while (valid != true);
        }

    }

    //Display stack storing broken equipements
    public void viewBrokenStack() {
        readBrokenFile();

        if (brokenStack.isEmpty()) {
            System.out.println("There are no broken racquet currently.");
        } else {
            System.out.println("                                                Broken Racquet");
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s\n",
                    "Equipment ID", "Equipment Brand", "Equipment Status", "Equipment Price", "Equipment Location", "Equipment Type");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            Iterator<Equipment> it = brokenStack.getIterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println("There are currently " + brokenStack.size() + " broken racquet.");
        }
        writeBrokenFile();
    }

    //Read file (equipment stack)
    public void serFileReader() {
        try {
            FileInputStream fileIn = new FileInputStream("src/EquipmentRecord.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            equipmentStack = (ArrayStack<Equipment>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("No Equipment Record is found!");
            c.printStackTrace();
        }
    }

    //Write file (equipment stack)
    public void serFileWriter() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/EquipmentRecord.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(equipmentStack);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    //Raed file (broken stack)
    public void readBrokenFile() {
        try {
            FileInputStream fileIn = new FileInputStream("src/BrokenRecord.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            brokenStack = (ArrayStack<Equipment>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("No Broken Equipment Record is found!");
            c.printStackTrace();
        }
    }

    //Write file (broken stack)
    public void writeBrokenFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/BrokenRecord.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(brokenStack);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
