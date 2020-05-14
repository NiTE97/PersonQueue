package com.company;


import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test (expected = IllegalArgumentException.class)
    public void personQueueKonstruktorTestLeer(){
        PersonQueue p = new PersonQueue (0);
        p.size();
    }

    @Test (expected = IllegalArgumentException.class)
    public void personQueueKonstruktorTestNegativ(){
        PersonQueue p = new PersonQueue (-1);
        p.size();
    }

    @Test
    public void addLastPersonQueueTest1() {
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        Person expected = new Person("Mustermann", "Max");
        Person actual = (Person) p1.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void addLastPersonQueueTest2() {
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        Person expected = new Person("Fant", "Ele");
        Person actual = (Person) p1.get(1);
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addLastPersonQueueTestOOB() {
        PersonQueue p1 = new PersonQueue(0);
        p1.addLast (new Person ("Mustermann", "Max"));
    }

    @Test
    public void removeFirstPersonQueueTest() {
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        p1.addLast (new Person ("Bauer", "Benny"));
        Person expected = new Person ("Mustermann", "Max");
        Person actual = (Person) p1.removeFirst();
        assertEquals(expected, actual);
    }

    @Test
    public void removeFirstPersonQueueTest2() {
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        p1.removeFirst();
        Person expected = new Person ("Fant", "Ele");
        Person actual = (Person) p1.get(0);
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeFirstPersonQueueTestIllegalArgument() {
        PersonQueue p1 = new PersonQueue(3);
        p1.removeFirst();
    }

    @Test
    public void getPersonQueueTest1() {
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        Person expected = new Person("Mustermann", "Max");
        Person actual = (Person) p1.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void emptyPersonQueueTestPositiv() {
        PersonQueue p1 = new PersonQueue(3);
        assertTrue(p1.empty());
    }
    @Test
    public void emptyPersonQueueTestNegativ() {
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        assertFalse(p1.empty());
    }

    @Test
    public void fullPersonQueueTestPositiv() {
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        p1.addLast (new Person ("Bauer", "Benny"));
        assertTrue(p1.full());
    }

    @Test
    public void fullPersonQueueTestNegativ() {
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        assertFalse(p1.full());
    }

    @Test
    public void sizePersonQueueTest() {
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        int expected = 2;
        int actual = p1.size();
        assertEquals(expected, actual);
    }

    @Test
    public void ausgabePersonQueueTest(){
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        String expected = "Mustermann, Max" + "\n" + "Fant, Ele" + "\n";
        String actual = p1.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void smallestPersonQueueTest(){
        PersonQueue p1 = new PersonQueue(2);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        String expected = "Fant, Ele";
        String actual = p1.smallest();
        assertEquals(expected, actual);
    }

    @Test
    public void smallestPersonQueueTest2(){
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        p1.addLast (new Person ("Bauer", "Benny"));
        String expected = "Bauer, Benny";
        String actual = p1.smallest();
        assertEquals(expected, actual);
    }

    @Test
    public void smallestPersonQueueTest3(){
        PersonQueue p1 = new PersonQueue(3);
        String expected = "";
        String actual = p1.smallest();
        assertEquals(expected, actual);
    }

    @Test
    public void smallestPersonQueueTest4(){
        PersonQueue p1 = new PersonQueue(3);
        p1.addLast (new Person ("Bauer", "Benny"));
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast (new Person ("Fant", "Ele"));
        String expected = "Bauer, Benny";
        String actual = p1.smallest();
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void PersonQueueDatatypeTest(){
        PersonQueue p1 = new PersonQueue(2);
        p1.addLast (new Person ("Mustermann", "Max"));
        p1.addLast ("String 1");
    }

    @Test (expected = IllegalArgumentException.class)
    public void StringQueueKonstruktorTestLeer(){
        StringQueue s = new StringQueue (0);
        s.size();
    }

    @Test (expected = IllegalArgumentException.class)
    public void StringQueueKonstruktorTestNegativ(){
        StringQueue s = new StringQueue (-1);
        s.size();
    }

    @Test
    public void addLastStringQueueTest1() {
        StringQueue s1 = new StringQueue(3);
        s1.addLast ("String 1");
        String expected = "String 1";
        String actual = s1.get(0).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void addLastStringQueueTest2() {
        StringQueue s1 = new StringQueue(3);
        s1.addLast ("String 1");
        s1.addLast ("String 2");
        String expected = "String 2";
        String actual = s1.get(1).toString();
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addLastStringQueueTestOOB() {
        StringQueue s1 = new StringQueue(0);
        s1.addLast ("String 1");
    }

    @Test
    public void removeFirstStringQueueTest() {
        StringQueue s1 = new StringQueue(3);
        s1.addLast ("String 1");
        s1.addLast ("String 2");
        s1.removeFirst();
        String expected = "String 2";
        String actual = s1.get(0).toString();
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeFirstStringQueueTestIllegalArgument() {
        StringQueue s1 = new StringQueue(3);
        s1.removeFirst();
    }

    @Test
    public void getStringQueueTest1() {
        StringQueue s1 = new StringQueue(3);
        s1.addLast ("String 1");
        String expected = "String 1";
        String actual = s1.get(0).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void emptyStringQueueTestPositiv() {
        StringQueue s1 = new StringQueue(3);
        assertTrue(s1.empty());
    }
    @Test
    public void emptyStringQueueTestNegativ() {
        StringQueue s1 = new StringQueue(3);
        s1.addLast ("String 1");
        assertFalse(s1.empty());
    }

    @Test
    public void fullStringQueueTestPositiv() {
        StringQueue p1 = new StringQueue(3);
        p1.addLast ("String 1");
        p1.addLast ("String 2");
        p1.addLast ("String 3");
        assertTrue(p1.full());
    }

    @Test
    public void fullStringQueueTestNegativ() {
        StringQueue s1 = new StringQueue(3);
        s1.addLast ("String 1");
        s1.addLast ("String 2");
        assertFalse(s1.full());
    }

    @Test
    public void sizeStringQueueTest() {
        StringQueue s1 = new StringQueue(3);
        s1.addLast ("String 1");
        s1.addLast ("String 2");
        int expected = 2;
        int actual = s1.size();
        assertEquals(expected, actual);
    }

    @Test
    public void ausgabeStringQueueTest(){
        StringQueue s1 = new StringQueue(2);
        s1.addLast ("String 1");
        s1.addLast ("String 2");
        String expected = "String 1" + "\n" + "String 2" + "\n";
        String actual = s1.toString();
        assertEquals(expected, actual);
    }
    @Test (expected = IllegalArgumentException.class)
    public void StringQueueDatatypeTest(){
        StringQueue s1 = new StringQueue(2);
        s1.addLast ("String 1");
        s1.addLast (new Person ("Mustermann", "Max"));
    }
}