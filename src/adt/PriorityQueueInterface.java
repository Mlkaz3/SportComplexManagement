/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author YJ
 */
public interface PriorityQueueInterface<T> {
    void joinQueue (T newSchedule);
    void leaveQueue (T aSchedule);
    void serveFirst ();
    void cutQueue (T newSchedule, int position, int priority);
    boolean isEmpty();
    //void compare(T newElement);
    int getPosition(T aSchedule);
    int getTotalEntry();
}
