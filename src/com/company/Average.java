package com.company;

public class Average extends NumberCruncherTopLevel implements CrunchOperation {

    public Average(float[] values) {
        super(values);
    }

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
