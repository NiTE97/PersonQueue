import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Swirl extends NumberCruncherTopLevel implements CrunchOperation {
/**
 * Konstruktor der auf super zugreift
 * @param values    -   das zu bearbeitende Array
 */
    public Swirl(float[] values) {
        super(values);
    }
/**
 * crunch Methode die das Interface implementiert
 * @param values    -   das zu bearbeitende Array
 */
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
            setNewArr(tempArr);
        }
        if(Arrays.equals(tempArr, values)){
            crunch(values);
        }
    }
}
