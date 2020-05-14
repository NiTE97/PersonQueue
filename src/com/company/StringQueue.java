package com.company;

public class StringQueue implements Queue {
    /**
     * Klassenattribute
     */
    private final int size;
    private int pointer;
    private final String [] queue;
    private static final String MSG_SIZEERR = "Die Größe muss größer als 0 sein!";
    private static final String MSG_OOB = "Die Queue ist schon voll!";
    private static final String MSG_INDEXERR = "Die Queue ist schon leer!";
    private static final String MSG_DATATYPEERR = "Das Objekt ist vom falschen Datentyp!";


    /**
     * Konstruktor
     * @param size  -   Groesse des Arrays  -   darf nicht kleiner oder gleich 0 sein
     */
    public StringQueue(int size) {
        Validator.check(size <= 0, MSG_SIZEERR);
        this.size = size;
        queue = new String[size];
    }

    /**
     * addLast zum Hinzufuegen von Strings ans Ende der Queue
     * @param o -   Object das hinzugefuegt werden soll -   darf nicht null sein oder falscher Datentyp sein
     */
    public void addLast(Object o){
        Validator.check(pointer == size, MSG_OOB);
        Validator.check(! (o instanceof String), MSG_DATATYPEERR );
            Methoden.addLast(queue, o, pointer);
            pointer++;
    }

    /**
     * removeFirst zum Entfernen des ersten Strings in der Queue
     * @return  der entfernte String
     */
    public Object removeFirst(){
        Validator.check(empty(), MSG_INDEXERR);
        pointer--;
        return Methoden.removeFirst(queue, pointer + 1);
    }

    /**
     * Get-Methode zum Ausgeben einer bestimmten Stelle der Queue
     * @param i -   Indecx der ausgegeben wird  -   darf nicht kleiner als 0 sein
     * @return  String
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
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pointer; i++){
            sb.append(get(i)).append("\n");
        }
        return sb.toString();
    }
}
