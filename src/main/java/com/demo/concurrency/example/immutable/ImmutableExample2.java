package com.demo.concurrency.example.immutable;

import com.demo.concurrency.annoations.NotThreadSafe;
import com.demo.concurrency.annoations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Wangpeng on 2018/6/14.
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {



    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map);
    }


}
