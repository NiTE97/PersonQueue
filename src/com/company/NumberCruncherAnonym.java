import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class NumberCruncherAnonym {
    /**
     * Klassenkonstanten
     */
    private float[] arr;
    private float[] edited;

    /**
     * Hilfsmethode zum Loeschen des edited Arrays
     */
    public void deleteArray(){
        edited = null;
    }

    /**
     * Konstruktor
     * @param values    -   das zu bearbeitende Array
     */
    public NumberCruncherAnonym(float [] values){
        setArray(values);
    }

    /**
     * Set-Methode fuer arr
     * @param values    -   das zu bearbeitende Array
     */
    public void setArray(float [] values){
        this.arr = values;
    }

    /**
     * Set-Methode fuer edited
     * @param values    -   das editierte Array
     */
    public void setNewArray(float [] values){
        this.edited = values;
    }

    /**
     * Get-Methode fuer edited
     * @return edited   -   das veraenderte Array
     */
    public float [] getNewNumbers(){
        return edited;
    }

    /**
     * Get-Methode fuer arr
     * @return arr  -   das urspruengliche Array
     */
    public float[] getNumbers() {
        return arr;
    }

    /**
     * crunch Methode zum Ausfuehren mehrerer Methoden hintereinander
     * @param operations    -   Array das die Methoden beinhaltet
     */
    public void crunch(String [] operations) {
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

    /**
     * sum Methode die das Interface implementiert
     * erstellt anonyme Klasse
     * @param values    -   das zu bearbeitende Array
     */
    public void sum(float[] values) {
        CrunchOperation co = new CrunchOperation() {
                @Override
                public void crunch(float[] values) {
                    float[] temp = new float[values.length];
                    temp[0] = values[0];
                    for (int i = 0; i < values.length - 1; i++) {
                        temp[i + 1] = values[i] + values[i + 1];
                    }
                    values = temp;
                    setNewArray(values);
                }
            };
        co.crunch(values);
    }

    /**
     * swirl Methode die das Interface implementiert
     * erstellt anonyme Klasse
     * @param values    -   das zu bearbeitende Array
     */
    public void swirl(float[] values) {
        CrunchOperation co = new CrunchOperation() {
                @Override
                public void crunch(float[] values) {
                    float [] tempArr = new float[values.length];

                    {
                        int i = 0;
                        while (i < values.length) {
                            tempArr[i] = values[i];
                            i++;
                        }
                    }
                    for (int i = 0; i < values.length; i++) {
                        int randomNum = ThreadLocalRandom.current().nextInt(0, values.length);
                        int randomNum2 = ThreadLocalRandom.current().nextInt(0, values.length);
                        float temp = tempArr[randomNum];
                        tempArr[randomNum] = tempArr[randomNum2];
                        tempArr[randomNum2] = temp;
                        setNewArray(tempArr);
                    }
                    if(Arrays.equals(tempArr, values)){
                        crunch(values);
                    }
                }
            };
        co.crunch(values);

    }

    /**
     * divide Methode die das Interface implementiert
     * erstellt anonyme Klasse
     * @param values    -   das zu bearbeitende Array
     */
    void divide(float[] values) {
        CrunchOperation co = new CrunchOperation() {
                @Override
                public void crunch(float[] values) {
                    float[] temp = new float[values.length];
                    float[] temp2 = new float[values.length];

                    int max;
                    int p = values.length - 1;

                    //temp array mit values Fuellen
                    {
                        int i = 0;
                        while (i < values.length) {
                            temp[i] = values[i];
                            i++;
                        }
                    }
                    //temp2 array mit values Fuellen
                    {
                        int i = 0;
                        while (i < values.length) {
                            temp2[i] = values[i];
                            i++;
                        }
                    }

                    Methoden.bubbleSort(temp);

                    for (int i = 0; i < values.length - 1; i++) {
                        if (temp[i] != 0) {
                            max = Methoden.findNumber(temp2, temp[p]);
                            temp[p] = temp[p] / temp[i];
                            temp2[max] = temp[p];
                            temp[p] = 0;
                            temp[i] = 0;
                            p--;
                        }
                    }
                    setNewArray(temp2);

                }
            };
        co.crunch(values);

    }

    /**
     * subtract Methode die das Interface implementiert
     * erstellt anonyme Klasse
     * @param values    -   das zu bearbeitende Array
     */
    void subtract(float[] values) {
        CrunchOperation co = new CrunchOperation() {
                @Override
                public void crunch(float[] values) {
                    float[] temp = new float[values.length];
                    temp[0] = values[0];
                    for (int i = 0; i < values.length - 1; i++) {
                        temp[i + 1] = values[i] - values[i + 1];
                    }
                    values = temp;
                    setNewArray(values);
                }
            };
        co.crunch(values);
    }

    /**
     * average Methode die das Interface implementiert
     * erstellt anonyme Klasse
     * @param values    -   das zu bearbeitende Array
     */
    void average(float[] values) {
        CrunchOperation co = new CrunchOperation() {
                @Override
                public void crunch(float[] values) {
                    float temp = 0;
                    float [] tempArr = new float[values.length];

                    {
                        int i = 0;
                        while (i < values.length) {
                            tempArr[i] = values[i];
                            i++;
                        }
                    }

                    for (float v : values) {
                        temp += v;
                    }
                    temp = temp / values.length;
                    tempArr[Methoden.findMax(values)] = temp;
                    setNewArray(tempArr);
                }
            };
        co.crunch(values);
    }
}