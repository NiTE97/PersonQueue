package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NumberCruncherAnonymTest {

    @Test
    public void sumTest1() {
        float[] arr = {1, 2, 3, 4};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float[] actual = nc.sum(arr);
        float[] expected = {1, 3, 5, 7};
        assertArrayEquals(actual, expected, 0.0f);
    }

    @Test
    public void sumTest2() {
        float[] arr = {0, 2, 4, 8};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float[] actual = nc.sum(arr);
        float[] expected = {0, 2, 6, 12};
        assertArrayEquals(actual, expected, 0.0f);
    }

    @Test
    public void swirlTest1() {
        float[] arr = {1, 2, 3, 4};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float[] actual = nc.swirl(arr);
        float[] expected = {1, 2, 3, 4};
        assertFalse(Arrays.equals(actual, expected));
    }

    @Test
    public void swirlTest2() {
        float[] arr = {0, 2, 4, 8};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float[] actual = nc.swirl(arr);
        float[] expected = {0, 2, 4, 8};
        assertFalse(Arrays.equals(actual, expected));
    }

    @Test
    public void divideTest1() {
        float[] arr = {1, 2, 3, 4};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float[] actual = nc.divide(arr);
        float[] expected = {1, 2, 1.5f, 4};
        assertArrayEquals(expected, actual, (float) 0.0);
    }

    @Test
    public void divideTest2() {
        float[] arr = {2, 4, 6, 8};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float[] actual = nc.divide(arr);
        float[] expected = {2, 4, 1.5f, 4};
        assertArrayEquals(expected, actual, (float) 0.0);
    }

    @Test
    public void divideTest3() {
        float[] arr = {8, 6, 2, 4};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float[] actual = nc.divide(arr);
        float[] expected = {4, 1.5f, 2, 4};
        assertArrayEquals(expected, actual, (float) 0.0);
    }

    @Test
    public void substractTest1(){
        float [] arr = {2, 4, 6, 8};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float [] actual = nc.substract(arr);
        float [] expected = {2, -2, -2, -2};
        assertArrayEquals(actual, expected, (float) 0.0);
    }

    @Test
    public void substractTest2(){
        float [] arr = { 1, 2, 3, 4};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float [] actual = nc.substract(arr);
        float [] expected = {1, -1, -1, -1};
        assertArrayEquals(actual, expected, (float) 0.0);
    }

    @Test
    public void averageTest1(){
        float [] arr = {1, 2, 4, 3};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float [] actual = nc.average(arr);
        float [] expected = {1, 2, 2.5f, 3};
        assertArrayEquals(expected, actual, (float) 0.0);
    }

    @Test
    public void averageTest2(){
        float [] arr = {2, 8, 6, 4};
        NumberCruncherAnonym nc = new NumberCruncherAnonym();
        float [] actual = nc.average(arr);
        float [] expected = {2, 5, 6, 4};
        assertArrayEquals(expected, actual, (float) 0.0);
    }


}