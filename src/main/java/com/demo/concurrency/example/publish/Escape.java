package com.demo.concurrency.example.publish;

import com.demo.concurrency.annoations.NotRecommend;
import com.demo.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Wangpeng on 2018/6/13.
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    private class InnerClass{
        public InnerClass(){
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
