package client;

import adt.ArrayStack;
import adt.StackInterface;
import adt.ArrayStackWithIteratorInterface;
import static client.MainDriver.usageManagement;
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

    StackInterface<Equipment> equipmentStack = new ArrayStack<>(); //tennis only

    Scanner input = new Scanner(System.in);
    //StackInterface<Equipment> badmintonStack = new ArrayStack<>();
    //StackInterface<Equipment> tennisStack = new ArrayStack<>();

    public EquipmentManagement() {
        //equipmentStack = new ArrayStack<>();
    }

    public void displayStack() {
        serFileReader();
        Iterator<Equipment> it = equipmentStack.getIterator();

        if (equipmentStack.isEmpty()) {
            System.out.println("Sorry. There are no racquet left.");
        } else {
            System.out.println("                                                            Racquet");
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s\n",
                    "Equipment ID", "Equipment Brand", "Equipment Status", "Equipment Price", "Equipment Location", "Equipment Type");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println("There are currently " + equipmentStack.size() + " racquet.");
        }
        //returnStackType(choice);
    }

    public void borrowEquipment() throws ParseException {
        //Read file
        serFileReader();
        boolean valid;

        User user = new User();
        Date date = new Date();

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

            System.out.print("Enter Quantity : ");
            String inputQty = input.nextLine();
            int qty = Integer.parseInt(inputQty);

            SimpleDateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            System.out.print("Enter End Time: ");
            String end_date = input.nextLine();
            Date endDate = (Date) myFormatObj.parse(end_date); //help winnie

            if (equipmentStack.size() < qty) {
                System.out.println("Insufficient racquet.");
                System.out.println("There are only " + equipmentStack.size() + " racquet currently.");
            } else {
                for (int i = 0; i < qty; i++) {
                    Equipment equipment = equipmentStack.peek();
                    ReservationRecord record1 = new entity.ReservationRecord((Date) endDate, user, equipment);
                    if (usageManagement.addReservation(record1)) {
                        equipment.setEquipmentStatus(false);
                        equipmentStack.pop();

                    }

                }
            }
        }
        //returnStackType(choice);
        serFileWriter();
    }

    public void returnEquipment() {
        //Should be enter userid / equipmentId to retrieve all the info and put back to stack
        System.out.println("Enter the reservation ID");
        String id = input.nextLine();
        //call a function that return a equipment
        ReservationRecord bookingitem;
        bookingitem = usageManagement.getBookingRecord(id); //retrieve the whole equipment obj 

        //set status back to true 
        System.out.println("Booking item ");
        System.out.println("Equipment ID" + bookingitem.getEquipments().getEquipmentID());
        System.out.println("Equipment Brand" + bookingitem.getEquipments().getEquipmentBrand());
        System.out.println("Equipment Status" + bookingitem.getEquipments().getEquipmentStatus());

        //update booking status 
        usageManagement.updateBookingStatus(bookingitem);
        
        //find penalty 
        usageManagement.getPenaltyCharges(id);

        serFileWriter();

        System.out.print("Enter Quantity : ");
        int qty = input.nextInt();
        input.nextLine();

        bookingitem.getEquipments().setEquipmentStatus(true);
        equipmentStack.push(bookingitem.getEquipments());

        System.out.println("Equipment Returned.");

//        for (int i = 0; i < qty; i++) {
//            Equipment equipment = new Equipment();
//
//            System.out.print("\nEquipment ID : ");
//            equipment.setEquipmentID(input.nextLine());
//
//            System.out.print("Equipment Brand : ");
//            equipment.setEquipmentBrand(input.nextLine());
//
//            System.out.print("Equipment Price : ");
//            String inputPrice = input.nextLine();
//            equipment.setEquipmentPrice(input.nextDouble());
//
//            input.nextLine();
//
//            System.out.print("Equipment Location : ");
//            equipment.setEquipmentLocation(input.nextLine());
//
//            System.out.print("Equipment Type : ");
//            equipment.setEquipmentType(input.nextLine());
//
//            equipment.setEquipmentStatus(true);
//            equipmentStack.push(equipment);
//
//            System.out.println("Equipment Returned.");
//        }
        //returnStackType(choice);
        serFileWriter();
    }

    public void stockIn() {
        String id, brand, location, type;
        double price;
        serFileReader();

        System.out.print("Enter Quantity : ");
        String inputQty = input.nextLine();
        int qty = Integer.parseInt(inputQty);
        //do validation

        for (int i = 0; i < qty; i++) {
            Equipment equipment = new Equipment();

            //System.out.println("Equipment To Return : ");
            System.out.print("\nEquipment ID : ");
            id = input.nextLine();
            //equipment.setEquipmentID(input.nextLine());

            System.out.print("Equipment Brand : ");
            brand = input.nextLine();
            //equipment.setEquipmentBrand(input.nextLine());

            System.out.print("Equipment Price : ");
            price = input.nextDouble();
            input.nextLine();
            //equipment.setEquipmentPrice(input.nextLine());

            System.out.print("Equipment Location : ");
            location = input.nextLine();
            //equipment.setEquipmentLocation(input.nextLine());

            System.out.print("Equipment Type : ");
            type = input.nextLine();
            //equipment.setEquipmentType(input.nextLine());

            //equipment.setEquipmentStatus(true);
            boolean status = true;

            //Equipment e = new Equipment(id, brand, status, price, location, type);
            //equipmentStack.push(new Equipment(id, brand, status, price, location, type));
//            System.out.println(equipment);
//            Iterator<Equipment> it = equipmentStack.getIterator();
//            while(it.hasNext()) {
//                System.out.println(it.next());
//            }
//            System.out.println(equipmentStack.contains(equipment));
            Equipment e = new Equipment(id, brand, status, price, location, type);
            if (equipmentStack.contains(e) == true) {
                System.out.println("This element is already in stack.");
            } else {
                equipmentStack.push(e);
                //equipmentStack.push(equipment);
                System.out.println("Equipment Inserted.");
            }
            serFileWriter();
        }
    }

    //Read file
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

    //Write file
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

    public void clearAll() {
        serFileReader();
        equipmentStack.clear();
        System.out.println("All equipment is removed.");
        serFileWriter();
    }

//    public void setStackType(int ch) {
//        System.out.println("Setting stack type");
//        switch (ch) {
//            case 1:
//                transferStack(tennisStack);
//                break;
//            case 2:
//                transferStack(badmintonStack);
//                break;
//        }
//    }
//    
//    public void returnStackType(int ch) {
//        switch (ch) {
//            case 1:
//                transferStack2(tennisStack);
//                break;
//            case 2:
//                transferStack2(badmintonStack);
//                break;
//        }
//    }
//
//    public void transferStack(StackInterface<Equipment> stackChoice) {
//        StackInterface<Equipment> stack1 = new ArrayStack<>();
//        System.out.println("Transferring stack 1");
//        //StackInterface<Equipment> equipStack = new ArrayStack<>();
//
//        //if (!stackChoice.isEmpty()) {
//            int x = stackChoice.size();
//            for (int i = 0; i < x; i++) {
//                stack1.push(stackChoice.pop());
//            }
//            //push it back 
//        //}
//        //if (!stack1.isEmpty()) {
//            int y = stack1.size();
//            for (int i = 0; i < y; i++) {
//                equipmentStack.push(stack1.pop());
//            }
//        //}
//    }
//    
//    public void transferStack2(StackInterface<Equipment> stackChoice) {
//        StackInterface<Equipment> stack2 = new ArrayStack<>();
//        System.out.println("Transferring stack 2");
//        int x = stackChoice.size();
//            for (int i = 0; i < x; i++) {
//                stack2.push(equipmentStack.pop());
//                System.out.println("Pop from equipmentStack");
//            }
//            int y = stack2.size();
//            for (int i = 0; i < y; i++) {
//                stackChoice.push(stack2.pop());
//            }
//    }
}
