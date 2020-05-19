 

import java.util.Arrays;
import java.util.Scanner;

public class TestDialog {

    //Scannerdeklaration
    private static Scanner input;

    //Funktionen
    private static final int SUM = 1;
    private static final int SWIRL = 2;
    private static final int DIVIDE = 3;
    private static final int SUBTRACT = 4;
    private static final int AVERAGE = 5;
    private static final int CRUNCH = 6;
    private static final int ENDE = 0;
    private static final int ANLEGEN = 7;
    private static final int ANZEIGEN = 8;
    private static final int TOPLEVEL = 11;
    private static final int ANONYM = 12;
    private static int verfahren = 0;

    private NumberCruncherTopLevel numberCrunsherTop;
    private NumberCruncherAnonym numberCrunsherAno;
    private float[] values;

    //Fehlermeldungen und Ausgaben
    private static final String MSG_PROGRAMM_AUSWAHL = "Bitte wählen Sie einen der oben aufgelisteten Möglichkeiten aus!";
    private static final String MSG_FEHLER = "Ein Fehler wurde abgefangen";
    private static final String MSG_NEGATIV = "Die Zahl muss größer als 0 sein!";
    private static final String MSG_UNGUELTIGER_TYP = "Ungültiger Typ";


    public TestDialog() {
        input = new Scanner(System.in);
    }

    private void start() {
        int funktion = -1;
        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                if (verfahren == 0 && funktion != 7) {
                    System.out.println("Bitte erst das Verfahren angeben!");
                    ausfuehrenFunktion(7);
                } else {
                    ausfuehrenFunktion(funktion);
                }
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
                SUM + ": Sum Funktion benutzen" + "\n" +
                SWIRL + ": Swirl Funktion benutzen" + "\n" +
                DIVIDE + ": Divide Funktion benutzen" + "\n" +
                SUBTRACT + ": Subtract Funktion benutzen" + "\n" +
                AVERAGE + ": Average Funktion benutzen" + "\n" +
                CRUNCH + ": Mehrere Funktionen benutzen" + "\n" +
                ANLEGEN + ": Verfahren wählen" + "\n" +
                ANZEIGEN + ": Das aktuelle Array anzeigen" + "\n" +
                ENDE + ": Programm beenden" + "\n";
        System.out.println(dialog);
        eingabe = input.nextInt();
        return eingabe;
    }

    private void ausfuehrenFunktion(int funktion) {
        int size;
        switch (funktion) {
            case ANLEGEN:
                System.out.println("Soll die anonyme Klasse oder die TopLevel Klasse benutzt werden?"
                        + "\n" + "11: TopLevel\n12: Anonym");
                verfahren = input.nextInt();
                input.nextLine();
                System.out.println("Wie viele Stellen soll das Array haben?");
                size = input.nextInt();
                input.nextLine();
                Validator.check(size <= 0, MSG_NEGATIV);
                values = new float[size];
                System.out.println("Bitte geben Sie nacheinander die einzelnen Zahlen ein: ");
                for (int i = 0; i < size; i++) {
                    values[i] = input.nextInt();
                    input.nextLine();
                    System.out.println(values[i] + " wurde hinzugefügt");
                }
                System.out.println(Arrays.toString(values));
                switch (verfahren) {
                    case TOPLEVEL:
                    numberCrunsherTop = new NumberCruncherTopLevel(values);
                    break;
                    case ANONYM:
                    numberCrunsherAno = new NumberCruncherAnonym(values);
                    break;
                }
                break;
            case SUM:
                if (verfahren == TOPLEVEL) {
                    numberCrunsherTop.sum(values);
                    System.out.println(Arrays.toString(numberCrunsherTop.getNewNumbers()));
                    numberCrunsherTop.deleteArray();
                } else if (verfahren == ANONYM) {
                    numberCrunsherAno.sum(values);
                    System.out.println(Arrays.toString(numberCrunsherAno.getNewNumbers()));
                    numberCrunsherAno.deleteArray();
                } else {
                    System.out.println("Es wurde noch kein Verfahren gewählt!");
                }
                break;
            case SWIRL:
                if (verfahren == TOPLEVEL) {
                    numberCrunsherTop.swirl(values);
                    System.out.println(Arrays.toString(numberCrunsherTop.getNewNumbers()));
                    numberCrunsherTop.deleteArray();
                } else if (verfahren == ANONYM) {
                    numberCrunsherAno.swirl(values);
                    System.out.println(Arrays.toString(numberCrunsherAno.getNewNumbers()));
                    numberCrunsherAno.deleteArray();
                } else {
                    System.out.println("Es wurde noch kein Verfahren gewählt!");
                }
                break;
            case DIVIDE:
                if (verfahren == TOPLEVEL) {
                    numberCrunsherTop.divide(values);
                    System.out.println(Arrays.toString(numberCrunsherTop.getNewNumbers()));
                    numberCrunsherTop.deleteArray();
                } else if (verfahren == ANONYM) {
                    numberCrunsherAno.divide(values);
                    System.out.println(Arrays.toString(numberCrunsherAno.getNewNumbers()));
                    numberCrunsherAno.deleteArray();
                } else {
                    System.out.println("Es wurde noch kein Verfahren gewählt!");
                }
                break;
            case SUBTRACT:
                if (verfahren == TOPLEVEL) {
                    numberCrunsherTop.subtract(values);
                    System.out.println(Arrays.toString(numberCrunsherTop.getNewNumbers()));
                    numberCrunsherTop.deleteArray();
                } else if (verfahren == ANONYM) {
                    numberCrunsherAno.subtract(values);
                    System.out.println(Arrays.toString(numberCrunsherAno.getNewNumbers()));
                    numberCrunsherAno.deleteArray();
                } else {
                    System.out.println("Es wurde noch kein Verfahren gewählt!");
                }
                break;
            case AVERAGE:
                if (verfahren == TOPLEVEL) {
                    numberCrunsherTop.average(values);
                    System.out.println(Arrays.toString(numberCrunsherTop.getNewNumbers()));
                    numberCrunsherTop.deleteArray();
                } else if (verfahren == ANONYM) {
                    numberCrunsherAno.average(values);
                    System.out.println(Arrays.toString(numberCrunsherAno.getNewNumbers()));
                    numberCrunsherAno.deleteArray();
                } else {
                    System.out.println("Es wurde noch kein Verfahren gewählt!");
                }
                break;
            case CRUNCH:
                String[] operations;
                int opSize;
                System.out.println("Wie viele Funktionen soll es hintereinander geben?");
                opSize = input.nextInt();
                input.nextLine();
                operations = new String[opSize];
                System.out.println("Geben Sie nacheinander die Funktionen ein: " + "\n(sum, swirl, divide, subtract, average)");
                for (int i = 0; i < opSize; i++) {
                    operations[i] = input.nextLine().toLowerCase().trim();
                }
                if (verfahren == TOPLEVEL) {
                    numberCrunsherTop.crunch(operations);
                    System.out.println(Arrays.toString(numberCrunsherTop.getNewNumbers()));
                    numberCrunsherTop.deleteArray();
                } else if (verfahren == ANONYM) {
                    numberCrunsherAno.crunch(operations);
                    System.out.println(Arrays.toString(numberCrunsherAno.getNewNumbers()));
                    numberCrunsherAno.deleteArray();
                } else {
                    System.out.println("Es wurde noch kein Verfahren gewählt!");
                }
                break;
            case ANZEIGEN:
                if (verfahren == TOPLEVEL) {
                    System.out.println(Arrays.toString(numberCrunsherTop.getNumbers()));
                    numberCrunsherTop.deleteArray();
                } else if (verfahren == ANONYM) {
                    System.out.println(Arrays.toString(numberCrunsherAno.getNumbers()));
                } else {
                    System.out.println("Es wurde noch kein Verfahren gewählt!");
                }
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
        new TestDialog().start();
    }
}
