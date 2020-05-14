package com.company;

public class Methoden {
    /**
     * Methode um ein Element am Ende der Queue einzufuegen
     * @param queue -   Die Queue die bearbeitet werden soll
     * @param o -   Das Objekt das eingefuegt wird
     * @param pointer   -   Stelle der Queue
     */
    public static void addLast(Object [] queue, Object o, int pointer){
        queue[pointer] = o;
    }

    /**
     * Methode zum Entfernen des ersten Elements aus der Queue
     * @param queue -   Die Queue die bearbeitet wird
     * @param pointer   -    Stelle der Queue
     * @return  Object das entfernt wurde
     */
    public static Object removeFirst(Object [] queue, int pointer){
        Object o = queue [0];
        queue [0] = null;
        System.arraycopy(queue, 1, queue, 0, queue.length - 1);
        queue [pointer -1] = null;
        return o;
    }

    /**
     * Methode zum Ausgeben eines bestimmten Elements aus der Queue
     * @param i -   Index der ausgegeben wird
     * @param queue -   Queue aus der ein Element ausgegeben wird
     * @return  Object an einer bestimmten Stelle
     */
    public static Object get(int i, Object [] queue){
        return queue[i];
    }

    /**
     * Methode zum Ueberpruefen ob die Queue leer ist
     * @param queue -   Queue die ueberprueft wird
     * @return  Boolean
     */
    public static boolean empty(Object[] queue){
        return queue[0] == null;
    }

    /**
     * Methode zum Ueberpruefen ob die Queue voll ist
     * @param queue -   Queue die ueberprueft wird
     * @param size  -   Groesse der Queue
     * @return  Boolean
     */
    public static boolean full(Object[] queue, int size){
        return queue[size - 1] != null;
    }

    public static void bubbleSort(float [] a){
        // Sortierter Bereich auf a[i] ... a[n-1]
        for (int i = a.length; i > 0; i--){
            // Unsortierter Bereich auf a[0] ... a[i-1]
            for (int j = 0; j < i -1; j++){
                // Werte a[j] und a[j+1] in falscher Reihenfolge?
                if (a[j] > a[j+1]){
                    // Werte vertauschen
                    float t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
    }

    public static int findNumber(float[] arr, float max) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                temp = i;
            }
        }
        return temp;
    }

    public static int findMax(float[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[temp]) {
                temp = i;
            }
        }
        return temp;
    }
}
