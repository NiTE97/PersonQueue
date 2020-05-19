public class Average extends NumberCruncherTopLevel implements CrunchOperation {
/**
 * Konstruktor der auf super zugreift
 * @param values    -   das zu bearbeitende Array
 */
    public Average(float[] values) {
        super(values);
    }
/**
 * crunch Methode die das Interface implementiert
 * @param values    -   das zu bearbeitende Array
 */
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
        setNewArr(tempArr);
    }
}
