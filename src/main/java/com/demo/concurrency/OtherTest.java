package com.demo.concurrency;

import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.Sets;

import java.util.Random;
import java.util.Set;

/**
 * Created by Administrator on 2018/6/18.
 */
public class OtherTest {

    public static void main(String[] args) {
        RangeMap<Integer, String> rangeMap;
        ImmutableRangeMap.Builder<Integer, String> builder = ImmutableRangeMap.builder();

        Set<Integer> sets = OtherTest.sets();
        int s = 0;
        for (Integer set : sets){
            int e = set + s;
            Range range = Range.closedOpen(s, e);
            builder.put(range, "奖品" + set);
            s = e;
        }

        rangeMap = builder.build();
        Random random = new Random();
        int i = random.nextInt(s);
        System.out.println(rangeMap.get(i));

    }

    private static Set<Integer> sets(){
        Set<Integer> set = Sets.newHashSet();
        set.add(1000);
        set.add(900);
        set.add(100);
        set.add(3000);
        set.add(300);
        set.add(1500);
        set.add(2000);
        set.add(1200);
        return set;
    }

}
