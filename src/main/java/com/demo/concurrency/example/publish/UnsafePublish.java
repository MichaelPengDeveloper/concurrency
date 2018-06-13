package com.demo.concurrency.example.publish;

import com.demo.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by Wangpeng on 2018/6/13.
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private static String[] a = {"a", "b", "c"};

    public String[] getStrings(){
        return a;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStrings()));

        a[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStrings()));

    }

}
