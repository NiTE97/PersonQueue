package com.company;

public class Divide extends NumberCruncherTopLevel implements CrunchOperation {

    public Divide(float[] values) {
        super(values);
    }

    @Override
    public void crunch(float[] values) {
        float[] temp = new float[values.length];
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


        Methoden.bubbleSort(temp);

        for (int i = 0; i < values.length - 1; i++) {
            if (temp[i] != 0) {
                max = Methoden.findNumber(values, temp[p]);
                temp[p] = temp[p] / temp[i];
                values[max] = temp[p];
                temp[p] = 0;
                temp[i] = 0;
                p--;
            }
        }
        setArr(values);
    }
}
