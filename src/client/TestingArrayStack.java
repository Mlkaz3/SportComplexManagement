package client;

import adt.ArrayStack;
import adt.StackInterface;
import entity.Equipment;
import java.util.Iterator;
import java.util.Scanner;

public class TestingArrayStack {

    public static void main(String[] args) {
        //Creating Stack
        Equipment racquet1 = new Equipment("R001", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet2 = new Equipment("R002", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet3 = new Equipment("R003", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet4 = new Equipment("R004", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet5 = new Equipment("R005", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet6 = new Equipment("R006", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet7 = new Equipment("R007", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet8 = new Equipment("R008", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet9 = new Equipment("R009", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet10 = new Equipment("R010", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet11 = new Equipment("R011", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet12 = new Equipment("R012", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet13 = new Equipment("R013", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet14 = new Equipment("R014", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet15 = new Equipment("R015", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet16 = new Equipment("R016", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet17 = new Equipment("R017", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet18 = new Equipment("R018", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet19 = new Equipment("R019", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet20 = new Equipment("R020", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet21 = new Equipment("R021", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet22 = new Equipment("R022", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet23 = new Equipment("R023", "Yonex", true, "120.00", "Stack A", "Badminton racquet");
        Equipment racquet24 = new Equipment("R024", "Yonex", true, "120.00", "Stack A", "Badminton racquet");

        //Implementing ADT
        StackInterface<Equipment> stackA = new ArrayStack<>();
        
        // Adding elements to stack
        stackA.push(racquet1);
        stackA.push(racquet2);
        stackA.push(racquet3);
        stackA.push(racquet4);
        stackA.push(racquet5);
        stackA.push(racquet6);
        stackA.push(racquet7);
        stackA.push(racquet8);
        stackA.push(racquet9);
        stackA.push(racquet10);
        stackA.push(racquet11);
        stackA.push(racquet12);
        stackA.push(racquet13);
        stackA.push(racquet14);
        stackA.push(racquet15);
        stackA.push(racquet16);
        stackA.push(racquet17);
        stackA.push(racquet18);
        stackA.push(racquet19);
        stackA.push(racquet20);
        stackA.push(racquet21);
        stackA.push(racquet22);
        stackA.push(racquet23);
        stackA.push(racquet24);

        //display the stack
        System.out.println("");
        System.out.println("Display Stack A");
        System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s\n",
                "Equipment ID", "Equipment Brand", "Equipment Status", "Equipment Price", "Equipment Location", "Equipment Type");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        
        Iterator<Equipment> it = stackA.getIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("");
        System.out.println("Size of stack is: " + stackA.size());

        System.out.println("");
        System.out.println("Length of array is: " + stackA.length());

        System.out.println("");
        System.out.println("Top of stack is: " + stackA.peek());
        
        System.out.println("");
        System.out.println("Does Stack contains : " + stackA.contains(racquet1));
        
        System.out.println("Pop: " + stackA.pop());
        
        //display the stack
        System.out.println("");
        System.out.println("Display Stack A");
        System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s\n",
                "Equipment ID", "Equipment Brand", "Equipment Status", "Equipment Price", "Equipment Location", "Equipment Type");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("hasnext : " + it.hasNext());
        System.out.println("Size of stack is: " + stackA.size());

        while (it.hasNext()) {
            System.out.println(it.next());
        }

//        System.out.println("");
//        System.out.println("Display Stack A");
//        System.out.printf(" %-15s %-20s %-20s %-20s %-20s %-20s\n",
//                "Equipment ID", "Equipment Brand", "Equipment Status", "Equipment Price", "Equipment Location", "Equipment Type");
//        System.out.println("------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(stackA);

    }
}
