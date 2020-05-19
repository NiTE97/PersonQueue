public class Divide extends NumberCruncherTopLevel implements CrunchOperation {
/**
 * Konstruktor der auf super zugreift
 * @param values    -   das zu bearbeitende Array
 */
    public Divide(float[] values) {
        super(values);
    }
/**
 * crunch Methode die das Interface implementiert
 * @param values    -   das zu bearbeitende Array
 */
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
        setNewArr(temp2);
    }
}
