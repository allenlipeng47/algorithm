package com.pli.project.algorithm.recursion.NextElement;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by pli on 12/22/2015.
 */
public class test {

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n4 = new Node<Integer>(4);
        Node<Integer> n5 = new Node<Integer>(5);
        Node<Integer> n6 = new Node<Integer>(6);
        Node<Integer> n7 = new Node<Integer>(7);
        Node<Integer> n8 = new Node<Integer>(8);
        Node<Integer> n9 = new Node<Integer>(9);
        Node<Integer> n10 = new Node<Integer>(10);
        Node<Integer> n11 = new Node<Integer>(11);
        Node<Integer> n12 = new Node<Integer>(12);
        Node<Integer> n13 = new Node<Integer>(13);
        Node<Integer> n14 = new Node<Integer>(14);
        n1.list = new ArrayList<Data<Integer>>(); n1.list.add(n2); n1.list.add(n3); n1.list.add(n4); n1.list.add(n5);
        n2.list = new ArrayList<Data<Integer>>(); n2.list.add(n6); n2.list.add(n7); n2.list.add(n8); n2.list.add(n9); n2.list.add(n10);
        n9.list = new ArrayList<Data<Integer>>(); n9.list.add(n11); n9.list.add(n12); n9.list.add(n13); n9.list.add(n14);
        DataIterator<Integer> itr = n1.getIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }


}
