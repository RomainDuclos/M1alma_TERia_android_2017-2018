package com.inter.romdu.TERapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalMisc {

    Interval a;

    @Test
    public void construct_isCorrect() throws Exception {
        a = new Interval();
        assertEquals(0.0,a.lo,0.0);
        assertEquals(0.0,a.hi,0.0);

        a = new Interval(-5.0,5.0);
        assertEquals(-5.0, a.lo,0.0);
        assertEquals(5.0, a.hi,0.0);

        a = new Interval(-5.1,5.1);
        assertEquals(-5.1, a.lo,0.0);
        assertEquals(5.1, a.hi,0.0);

        a = new Interval(-5.514561694512545145,5.9215894471654124675);
        assertEquals(-5.514561694512545145, a.lo,0.0);
        assertEquals(5.9215894471654124675, a.hi,0.0);

        a = new Interval(5.0,-5.0);
        assertEquals(1.0, a.lo,0.0);
        assertEquals(0.0, a.hi,0.0);

        a = new Interval("-5.0","5.0");
        assertEquals(-5.0, a.lo,0.0);
        assertEquals(5.0, a.hi,0.0);

        a = new Interval("5.0","-5.0");
        assertEquals(1.0, a.lo,0.0);
        assertEquals(0.0, a.hi,0.0);

        a = new Interval("-5.1","5.1");
        assertEquals(-5.1, a.lo,0.0);
        assertEquals(5.1, a.hi,0.0);

        a = new Interval("-5.514561694512545145","5.9215894471654124675");
        assertEquals(-5.514561694512545145, a.lo,0.0);
        assertEquals(5.9215894471654124675, a.hi,0.0);
    }

    @Test
    public void isEmpty_isCorrect() throws Exception {
        a = new Interval(-5.0,5.0);
        assertEquals(false,a.isEmpty());

        a = new Interval(5.0,-5.0);
        assertEquals(true,a.isEmpty());
    }

    @Test
    public void toString_isCorrect() throws Exception {
        a = new Interval(-5.0,5.0);
        assertEquals("[ -5.0 , 5.0 ]",a.toString());

        a = new Interval(-5.1,5.1);
        assertEquals("[ -5.1 , 5.1 ]",a.toString());

        a = new Interval(-5.62514512769,5.145197958195);
        assertEquals("[ -5.62514512769 , 5.145197958195 ]",a.toString());
    }
}