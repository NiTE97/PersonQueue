public class Subtract extends NumberCruncherTopLevel implements CrunchOperation {
/**
 * Konstruktor der auf super zugreift
 * @param values    -   das zu bearbeitende Array
 */
    public Subtract(float[] values) {
        super(values);
    }
/**
 * crunch Methode die das Interface implementiert
 * @param values    -   das zu bearbeitende Array
 */
    @Override
    public void crunch(float[] values) {
        float[] temp = new float[values.length];
        temp[0] = values[0];
        for (int i = 0; i < values.length - 1; i++) {
            temp[i + 1] = values[i] - values[i + 1];
        }
        values = temp;
        setNewArr(values);
    }
}
