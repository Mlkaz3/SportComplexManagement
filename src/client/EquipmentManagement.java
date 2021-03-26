package client;

import adt.ArrayStack;
import adt.StackInterface;
import adt.ArrayStackWithIteratorInterface;
import entity.Equipment;
import entity.User;
import entity.ReservationRecord;
import java.util.Iterator;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EquipmentManagement {

    StackInterface<Equipment> equipmentStack; //tennis only

    Scanner input = new Scanner(System.in);
    StackInterface<Equipment> badmintonStack = new ArrayStack<>();
    StackInterface<Equipment> tennisStack = new ArrayStack<>();

    public EquipmentManagement() {
        equipmentStack = new ArrayStack<>();
    }

//    public void checkEmpty(StackInterface<Equipment> stackChoice) {
//        if(stackChoice.isEmpty());
//    }
//    public void setStack(int equipType) {
//        //set stack according to user choice.
//    }
    public void displayStack() {
        Iterator<Equipment> it = equipmentStack.getIterator();

        if (equipmentStack.isEmpty()) {
            System.out.println("Sorry. There are no racquet left.");
        } else {
            System.out.println("                                                            Tennis");
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s\n",
                    "Equipment ID", "Equipment Brand", "Equipment Status", "Equipment Price", "Equipment Location", "Equipment Type");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println("There are currently " + equipmentStack.size() + " in stock.");
        }
        //returnStackType(choice);
    }

    public void borrowEquipment() {
        User user = new User();
        ReservationRecord reservationRecord = new ReservationRecord();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        if (equipmentStack.isEmpty()) {
            System.out.println("Sorry. There are no racquet left.");
        } else {
            System.out.print("Enter Name : ");
            user.setUserName(input.nextLine());

            System.out.print("Enter ID : ");
            user.setUserID(input.nextLine());

            System.out.print("Enter Category : ");
            user.setUserCategory(input.nextLine());

            System.out.print("Enter Tel : ");
            user.setUserTel(input.nextLine());

            System.out.print("Enter Quantity : ");
            String inputQty = input.nextLine();
            int qty = Integer.parseInt(inputQty);

            SimpleDateFormat myFormatObj = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            System.out.print("Enter Start Time: ");
            String start_date = input.nextLine();
            //Date startDate = (Date) myFormatObj.parse(start_date); //help winnie
            //reservationRecord.setReservationStartTime(startDate);
            
            System.out.print("Enter End Time: ");
            String end_date = input.nextLine();
            //Date endDate = (Date) myFormatObj.parse(end_date); //help winnie
            //reservationRecord.setReservationStartTime(endDate);

            if (equipmentStack.size() < qty) {
                System.out.println("Insufficient racquet.");
                System.out.println("There are only " + equipmentStack.size() + " racquet currently.");
            } else {
                for (int i = 0; i < qty; i++) {
                    Equipment equipment = equipmentStack.peek();
                    equipment.setEquipmentStatus(false);
                    equipmentStack.pop();
                    //Here should be writing to WINNIE part
                }
            }
        }
        //returnStackType(choice);
    }

    public void returnEquipment() {//add
        //Should be enter userid / equipmentId to retrieve all the info and put back to stack
        System.out.print("Enter Quantity : ");
        String inputQty = input.nextLine();
        int qty = Integer.parseInt(inputQty);

        for (int i = 0; i < qty; i++) {
            Equipment equipment = new Equipment();

            System.out.print("\nEquipment ID : ");
            equipment.setEquipmentID(input.nextLine());

            System.out.print("Equipment Brand : ");
            equipment.setEquipmentBrand(input.nextLine());

            System.out.print("Equipment Price : ");
            equipment.setEquipmentPrice(input.nextLine());

            System.out.print("Equipment Location : ");
            equipment.setEquipmentLocation(input.nextLine());

            System.out.print("Equipment Type : ");
            equipment.setEquipmentType(input.nextLine());

            equipment.setEquipmentStatus(true);
            equipmentStack.push(equipment);

            System.out.println("Equipment Returned.");
        }
        //returnStackType(choice);
    }

    public void stockIn() {
        System.out.print("Enter Quantity : ");
        String inputQty = input.nextLine();
        int qty = Integer.parseInt(inputQty);
        //do validation

        for (int i = 0; i < qty; i++) {
            Equipment equipment = new Equipment();

            //System.out.println("Equipment To Return : ");
            System.out.print("\nEquipment ID : ");
            equipment.setEquipmentID(input.nextLine());

            System.out.print("Equipment Brand : ");
            equipment.setEquipmentBrand(input.nextLine());

            System.out.print("Equipment Price : ");
            equipment.setEquipmentPrice(input.nextLine());

            System.out.print("Equipment Location : ");
            equipment.setEquipmentLocation(input.nextLine());

            System.out.print("Equipment Type : ");
            equipment.setEquipmentType(input.nextLine());

            equipment.setEquipmentStatus(true);
            
            System.out.println(equipment);
            Iterator<Equipment> it = equipmentStack.getIterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println(equipmentStack.contains(equipment));
            
            if(equipmentStack.contains(equipment) == true)
            {
                System.out.println("This element is already in stack.");
            }
            else {
                equipmentStack.push(equipment);
                System.out.println("Equipment Inserted.");
            }
        }
    }

    //validation for user input
    public void stockOut() {
        equipmentStack.clear();
        System.out.println("All equipment is removed.");
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
