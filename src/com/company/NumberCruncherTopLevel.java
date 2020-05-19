public class NumberCruncherTopLevel implements CrunchOperation {
    /**
     * Klassenkonstanten
     */
    private float[] arr;
    private float [] edited;

    /**
     * Hilfsmethode zum Loeschen des edited Arrays
     */
    public void deleteArray(){
        edited = null;
    }

    /**
     * Set-Methode zum Anlegen des Arrays
     */
    public void setArr(float[] values) {
        this.arr = values;
    }

    /**
     * Set-Methode zum Anlegen des edited Arrays
     */
    public void setNewArr(float[] values) {
        this.edited = values;
    }

    /**
     * Konstruktor
     * @param values    -   Array mit den zu bearbeitenden Zahlen
     */
    public NumberCruncherTopLevel(float[] values) {
        setArr(values);
    }

    /**
     * crunch Methode die das Interface implementiert
     * @param values    -   Array mit den zu bearbeitenden Zahlen
     */
    @Override
    public void crunch(float[] values) {
    }

    /**
     * sum Funktion
     * @param values    -   Array mit den zu bearbeitenden Zahlen
     */
    public void sum(float[] values) {
        NumberCruncherTopLevel nc = new Sum(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    /**
     * swirl Methode die das Interface implementiert
     * @param values    -   Array mit den zu bearbeitenden Zahlen
     */
    public void swirl(float[] values) {
        NumberCruncherTopLevel nc = new Swirl(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    /**
     * divide Methode die das Interface implementiert
     * @param values    -   Array mit den zu bearbeitenden Zahlen
     */
    public void divide(float[] values) {
        NumberCruncherTopLevel nc = new Divide(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    /**
     * subtract Methode die das Interface implementiert
     * @param values    -   Array mit den zu bearbeitenden Zahlen
     */
    public void subtract(float[] values) {
        NumberCruncherTopLevel nc = new Subtract(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    /**
     * average Methode die das Interface implementiert
     * @param values    -   Array mit den zu bearbeitenden Zahlen
     */
    public void average(float[] values) {
        NumberCruncherTopLevel nc = new Average(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    /**
     * Hilfsmethode zum Ausgeben des Arrays
     * @return arr  -   das urspruengliche Array
     */
    public float[] getNumbers() {
        return arr;
    }

    /**
     * Hilfsmethode zum Ausgeben des edited Arrays
     * @return arr  -   das editierte Array
     */
    public float[] getNewNumbers() {
        return edited;
    }

    /**
     * crunch Methode zum Ausfuehren verschiedener Methoden hintereinander
     * @param operations    -   Array das die auszufuehrenden Methoden beinhaltet
     */
    public void crunch(String[] operations) {
        float [] tempArr;

        for (String operation : operations) {

            if (edited != null){
                tempArr = edited;
            }else{
                tempArr = arr;
            }

            switch (operation) {
                case "sum" :
                sum(tempArr);
                break;
                case "swirl":
                swirl(tempArr);
                break;
                case "divide":
                divide(tempArr);
                break;
                case "subtract":
                subtract(tempArr);
                break;
                case "average":
                average(tempArr);
                break;
            }
        }
        edited = getNewNumbers();
    }
}

