package com.company;

import java.util.Objects;

public class Person {
    /**
     * Klassenattribute
     */
    private String name, vorname;
    private static final String MSG_NAMEERR = "Der Name darf nicht leer sein!";
    private static final String MSG_VORNAMEERR = "Der Vorname darf nicht leer sein!";

    /**
     * Konstruktor
     * @param name  - darf nicht leer sein
     * @param vorname   - darf nicht leer sein
     */
    public Person(String name, String vorname){
        setName(name);
        setVorname(vorname);
    }

    /**
     * Set-Methode fuer Name
     * @param name  -   darf nicht leer sein
     */
    public void setName(String name){
        Validator.check(name == null || name.trim().isEmpty(), MSG_NAMEERR);
        this.name = name;
    }

    /**
     * Set-Methode fuer Vorname
     * @param vorname   -    darf nicht leer sein
     */
    public void setVorname(String vorname){
        Validator.check(vorname == null || vorname.trim().isEmpty(), MSG_VORNAMEERR);
        this.vorname = vorname;
    }

    /**
     * Get-Methode fuer Name
     * @return  name
     */
    public String getName(){
        return name;
    }

    /**
     * Get-Methode fuer Vorname
     * @return  vorname
     */
    public String getVorname(){
        return vorname;
    }

    /**
     * toString
     * @return  Person als String
     */
    @Override
    public String toString() {
        return name + ", " + vorname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(vorname, person.vorname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vorname);
    }
}
