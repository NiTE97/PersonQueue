package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void setNameTest1() {
        Person p = new Person("Mustermann", "Max");
        String expected = "Mustermann";
        String actual = p.getName();
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setNameTestLeer() {
        Person p = new Person("", "Max");
    }

    @Test
    public void setVornameTest1() {
        Person p = new Person("Mustermann", "Max");
        String expected = "Max";
        String actual = p.getVorname();
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setVornameTestLeer() {
        Person p = new Person("Mustermann", "");
    }

    @Test
    public void testToString() {
        Person p = new Person("Mustermann", "Max");
        String expected = "Mustermann, Max";
        String actual = p.toString();
        assertEquals(expected, actual);
    }
}