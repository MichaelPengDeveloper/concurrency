package com.demo.concurrency.example.syncContainer;

import com.demo.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Wangpeng on 2018/6/15.
 */
@Slf4j
@NotThreadSafe
public class VectorExample3 {

    // java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> vector){
        for (Integer i : vector){
            if (i.equals(3)){
                vector.remove(i);
            }
        }

    }

    // java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> vector){
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next.equals(3)){
                vector.remove(next);
            }
        }
    }

    private static void test3(Vector<Integer> vector){
        for (int i = 0; i < vector.size(); i++){
            if (vector.get(i).equals(3)){
                vector.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        VectorExample3.test1(vector);

    }

}
