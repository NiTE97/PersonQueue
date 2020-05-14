package com.company;

/**
 * Klasse zum Ueberpruefen von Werten/Eingabe
 *
 */

public class Validator {

    public static void check(boolean bedingung, String msg) {
        if (bedingung) {
            throw new IllegalArgumentException(msg);
        }
    }
}