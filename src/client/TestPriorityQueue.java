/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.PriorityQueue;
import adt.PriorityQueueInterface;

/**
 *
 * @author YJ
 */
public class TestPriorityQueue {
    
    public static void main(String[] args) {
        
        PriorityQueueInterface<String> s1 = new PriorityQueue<>();

        s1.joinQueue("F007");
        s1.joinQueue("F003");
        s1.joinQueue("F002");
        s1.joinQueue("F005");
        s1.joinQueue("F004");
        s1.joinQueue("F004");
        System.out.println(s1);
        s1.leaveQueue("F002");
        s1.leaveQueue("F001");
        System.out.println(s1);
        s1.serveFirst();
        System.out.println(s1);
        System.out.println(s1.checkPosition("F004"));
        
    }

    
}
