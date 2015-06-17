package com.util;

import org.junit.Test;

import java.util.Date;

/**
 * Created by dan on 15-6-16.
 */
public class TimeTest {
    @Test
    public void testTime() throws Exception {
        System.out.println(new Date().getTime());
        long time = 1434364346895L;
        Date date = new Date(time);
        System.out.println(date);
    }
}
