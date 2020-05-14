package com.company;

import java.util.Scanner;


public class Dialog {

    //Scannerdeklaration
    private static Scanner input;
    private int size;

    private Queue queue;

    //Funktionen
    private static final int QUEUE = 1;
    private static final int HINZUFUEGEN = 2;
    private static final int ERSTENENTFERNEN = 3;
    private static final int AUSGEBEN = 4;
    private static final int LEER = 5;
    private static final int VOLL = 6;
    private static final int SIZE = 7;
    private static final int AUSGABE = 8;
    private static final int SORTIEREN = 9;


    private static final int ENDE = 0;

    //Fehlermeldungen und Ausgaben
    private static final String MSG_PROGRAMM_AUSWAHL = "Bitte wählen Sie einen der oben aufgelisteten Möglichkeiten aus!";
    private static final String MSG_FEHLER = "Ein Fehler wurde abgefangen";
    private static final String MSG_UNGUELTIGER_TYP = "Ungültiger Typ";


    public Dialog() {
        input = new Scanner(System.in);
    }

    private void start() {
        int funktion = -1;
        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch (java.util.InputMismatchException e) {
                System.out.println(MSG_UNGUELTIGER_TYP);
                input.next();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(MSG_FEHLER + e);
                e.printStackTrace(System.out);
            }
        }
    }

    private int einlesenFunktion() {
        int eingabe;
        String dialog = "Was möchten Sie als nächstes machen?\n\n" +
                QUEUE + ": Neue Warteschlange anlegen" + "\n" +
                HINZUFUEGEN + ": Objekt hinzufügen" + "\n" +
                ERSTENENTFERNEN + ": Die erste Stelle entfernen" + "\n" +
                AUSGEBEN + ": Eine bestimmte Stelle ausgeben" + "\n" +
                LEER + ": Prüfen ob die Warteschlange noch leer ist" + "\n" +
                VOLL + ": Prüfen ob die Warteschlagne schon voll ist" + "\n" +
                SIZE + ": Prüfen wie viele Stellen in der Warteschlange sind" + "\n" +
                AUSGABE + ": Ausgabe der Warteschlange" + "\n" +
                SORTIEREN + ": Person mit dem lexikalisch kleinsten Namen ausgeben" + "\n" +
                ENDE + ": Programm beenden" + "\n";
        System.out.println(dialog);
        eingabe = input.nextInt();
        return eingabe;
    }

    private void ausfuehrenFunktion(int funktion) {
        final int PERSON = 11;
        final int STRING = 12;
        int queuetype;
        switch (funktion) {
            case QUEUE:
                System.out.println("Wollen Sie eine Personenwarteschlange oder eine Stringwarteschlange erstellen?"
                        + "\n" + "11: Personenwarteschlange\n12: Stringwarteschlange");
                queuetype = input.nextInt();
                input.nextLine();
                switch (queuetype) {
                    case PERSON -> {
                        System.out.println("Geben Sie an, wie viele Stellen die Warteschlange haben soll:");
                        size = input.nextInt();
                        input.nextLine();
                        queue = new PersonQueue(size);
                    }
                    case STRING -> {
                        System.out.println("Geben Sie an, wie viele Stellen die Warteschlange haben soll:");
                        size = input.nextInt();
                        input.nextLine();
                        queue = new StringQueue(size);
                    }
                }
                break;
            case HINZUFUEGEN:
                if(queue.size() != size) {
                    if (queue instanceof PersonQueue) {
                        System.out.println("Geben Sie den Nachnamen an: ");
                        input.nextLine();
                        String name = input.nextLine();
                        System.out.println("Geben Sie den Vornamen an: ");
                        String vorname = input.nextLine();
                        Object o = ((PersonQueue) queue).legePersonAn(name, vorname);
                        queue.addLast(o);
                    } else {
                        System.out.println("Geben Sie den String an: ");
                        input.nextLine();
                        String string = input.nextLine();
                        queue.addLast(string);
                    }
                    System.out.println("Erfolgreich hinzugefügt!");
                }else{
                    System.out.println("Die Warteschlange ist schon voll!");
                }
                break;
            case ERSTENENTFERNEN:
                System.out.println(queue.removeFirst());
                break;
            case AUSGEBEN:
                System.out.println("Geben Sie die Stelle ein die Sie Ausgeben wollen: ");
                int stelle = input.nextInt();
                input.nextLine();
                System.out.println(queue.get(stelle));
                break;
            case LEER:
                if (queue.empty()) {
                    System.out.println("Die Warteschlange ist leer!");
                } else {
                    System.out.println("Die Warteschlange ist nicht leer!");
                }
                break;
            case VOLL:
                if (queue.full()) {
                    System.out.println("Die Warteschlange ist voll!");
                } else {
                    System.out.println("Die Warteschlange ist nicht voll!");
                }
                break;
            case SIZE:
                System.out.println(queue.size());
                break;
            case AUSGABE:
                if ( queue instanceof PersonQueue){
                    System.out.println(queue);
                }else {
                    print(queue);
                }
                break;
            case SORTIEREN:
                PersonQueue personQueue;
                personQueue = (PersonQueue) queue;
                System.out.println(personQueue.smallest());
                break;
            case ENDE:
                System.out.println("Das Programm wird beendet!");
                break;
            default:
                System.out.println(MSG_PROGRAMM_AUSWAHL);
                break;
        }
    }


    public static void main(String[] args) {
        new Dialog().start();
    }

    public void print(Queue q) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q.size(); i++) {
            sb.append(q.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
