package client;

import adt.ArrayStack;
import adt.StackInterface;
import adt.ArrayStackWithIteratorInterface;
import entity.Equipment;
import entity.User;
import java.util.Iterator;
import java.util.Scanner;

public class EquipmentManagement {

    StackInterface<Equipment> equipmentStack; //tennis only

    Scanner input = new Scanner(System.in);
    StackInterface<Equipment> badmintonStack = new ArrayStack<>();
    //StackInterface<Equipment> squashStack = new ArrayStack<>();

    public EquipmentManagement() {
        equipmentStack = new ArrayStack<>();
    }

    public void setStackType() {
        //setting the stack based on user selection
        //if else 
        //equipmentStack = badmintonStack;
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
    }

    public void borrowEquipment() {
        User user = new User();
        
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
    }
    
    public void stockIn() {
        System.out.print("Enter Quantity : ");
        String inputQty = input.nextLine();
        int qty = Integer.parseInt(inputQty);

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
            equipmentStack.push(equipment);

            System.out.println("Equipment Returned.");
        }
    }
    
    //validation for user input
    public void stockOut() {
        
    }
}
