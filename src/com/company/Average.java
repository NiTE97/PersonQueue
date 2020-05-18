package com.company;

public class Average extends NumberCruncherTopLevel implements CrunchOperation {

    public Average(float[] values) {
        super(values);
    }

    @Override
    public void crunch(float[] values) {
        float temp = 0;
        for (float v : values) {
            temp += v;
        }
        temp = temp / values.length;
        values[Methoden.findMax(values)] = temp;
        setArr(values);
    }
}
