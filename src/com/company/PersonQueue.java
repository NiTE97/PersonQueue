package com.company;

import java.util.Iterator;

public class PersonQueue implements Queue{
    /**
     * Klassenattribute
     */
    private final int size;
    private int pointer;
    private final Person [] queue;
    private static final String MSG_SIZEERR = "Die Größe muss größer als 0 sein!";
    private static final String MSG_OOB = "Die Queue ist schon voll!";
    private static final String MSG_INDEXERR = "Die Queue ist schon leer!";
    private static final String MSG_INDEXERR2 = "Die Queue ist noch leer!";
    private static final String MSG_DATATYPEERR = "Das Objekt ist vom falschen Datentyp!";


    /**
     * Konstruktor
     * @param size  -   Groesse des Arrays  -   darf nicht kleiner oder gleich 0 sein
     */
    public PersonQueue(int size) {
        Validator.check(size <= 0, MSG_SIZEERR);
        this.size = size;
        queue = new Person[size];
    }

    /**
     * addLast zum Hinzufuegen von Personen ans Ende der Queue
     * @param o -   Object das hinzugefuegt werden soll -   darf nicht null sein oder falscher Datentyp sein
     */
    public void addLast(Object o){
        Validator.check(pointer == size, MSG_OOB);
        Validator.check(! (o instanceof Person), MSG_DATATYPEERR );
            Methoden.addLast(queue, o, pointer);
            pointer++;
    }

    /**
     * removeFirst zum Entfernen der ersten Person in der Queue
     * @return  die entfernte Person
     */
    public Object removeFirst(){
        Validator.check(empty(), MSG_INDEXERR);
        pointer--;
            return Methoden.removeFirst(queue, pointer + 1);
    }

    /**
     * Get-Methode zum Ausgeben einer bestimmten Stelle der Queue
     * @param i -   Index der ausgegeben wird  -   darf nicht kleiner als 0 sein
     * @return  Person
     */
    public Object get(int i){
        return Methoden.get(i, queue);
    }

    /**
     * Methode zum Testen ob die Queue leer ist
     * @return  Boolean
     */
    public boolean empty(){
        return Methoden.empty(queue);
    }

    /**
     * Methode zum Testen ob die Queue voll ist
     * @return  Boolean
     */
    public boolean full(){
        return Methoden.full(queue, size);
    }

    /**
     * Methode um die Groesse der Queue auszugeben
     * @return  size
     */
    public int size(){
        return pointer;
    }

    /**
     * toString mit Iterator
     * @return  StringBuilder.toString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Iterator<Person> it = iterator();
        while(it.hasNext()) {
            Person current = it.next();
            sb.append(current).append("\n");
        }
    return sb.toString();
    }

    public Person legePersonAn(String name, String vorname){
        return new Person (name, vorname);
    }

    /**
     * Methode zum Ausgeben der Person mit dem lexikalisch kleinsten Vornamen
     * return String
     */
    public String smallest(){
        if(queue[0] == null){
            return "";
        }

        Person smallest = queue[0];
        Iterator<Person> it = iterator();

        while(it.hasNext()) {
            Person current = it.next();
            if(current.getVorname().compareTo(smallest.getVorname()) < 0){
                smallest = current;
            }
        }
        return smallest.toString();
    }

    /**
     * Methode zum Initialisieren des Iterators
     * @return  Iterator<Person>
     */
    public Iterator<Person> iterator() {
        int start = 0;
        int end = queue.length;
        Validator.check(queue[0] == null, MSG_INDEXERR2);
        return new PersonIteratorClass(start, end, queue);
    }

    /**
     * Innere Klasse zum Benutzen des Iterators
     */
    private static final class PersonIteratorClass implements PersonIterator{
        /**
         * Klassenattribute
         */
        private int cursor;
        private final int end;
        private final Person [] queue;

        /**
         * Konstruktor fuer den Iterator
         * @param start -   Anfang des Durchlaufs
         * @param end   -   Ende des Durchlaufs
         * @param queue -   Die Queue die durchlaufen wird
         */
        public PersonIteratorClass(int start, int end, Person[] queue){
            this.end = end;
            this.cursor = start;
            this.queue = queue;
        }

        /**
         * Methode zum Ueberpruefen, ob ein weiteres Element in der Queue enthalten ist
         * @return  Boolean
         */
        @Override
        public boolean hasNext() {
            return this.cursor < end && queue[cursor] != null;
        }

        /**
         * Methode zum Ausgeben der naechsten Person in der Queue
         * @return  Person
         */
        @Override
        public Person next() {
            if(this.hasNext()) {
                int current = cursor;
                cursor ++;
                return queue[current];
            }
            throw new NullPointerException();
        }
    }

    /**
     * Inneres Interface fuer den Iterator
     */
    interface PersonIterator extends java.util.Iterator<Person>{
        /**
         * Methode zum Ueberpruefen, ob ein weiteres Element in der Queue enthalten ist
         * @return  Boolean
         */
        @Override
        boolean hasNext();

        /**
         * Methode zum Ausgeben der naechsten Person in der Queue
         * @return  Person
         */
        @Override
        Person next();
    }
}
