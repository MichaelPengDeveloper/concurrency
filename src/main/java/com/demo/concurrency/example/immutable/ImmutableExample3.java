package com.demo.concurrency.example.immutable;

import com.demo.concurrency.annoations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Wangpeng on 2018/6/14.
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private final static List<Integer> list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    private static ImmutableMap.Builder<Integer, Integer> map1 = ImmutableMap.builder();

    public static void main(String[] args) {
        map1.put(1, 2);
        map1.build();

    }

}
