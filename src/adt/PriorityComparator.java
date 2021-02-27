/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import entity.Maintenance;
import java.util.Comparator;

/**
 *
 * @author YJ
 */
public class PriorityComparator implements Comparator<Maintenance> {

    @Override
    public int compare(Maintenance m1, Maintenance m2) {
        return m1.getStartDate().compareTo(m2.getStartDate());
//        if (m1.getPriority() > m2.getPriority()) {
//            return 1;
//        } else if (m1.getPriority() < m2.getPriority()) {
//            return -1;
//        }
//        return 0;
    }
}
