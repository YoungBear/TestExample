package com.ysx.testexample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author ysx
 * @date 2017/11/14
 * @description
 */
public class CalculatorTest {

    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(6d, mCalculator.add(1d, 5d), 0);
    }

    @Test
    public void testSubtract() throws Exception {
        assertEquals(1d, mCalculator.subtract(5d, 4d), 0);
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(4d, mCalculator.divide(20d, 5d), 0);
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(10d, mCalculator.multiply(2d, 5d), 0);
    }

}