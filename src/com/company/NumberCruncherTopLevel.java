package com.company;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class NumberCruncherTopLevel implements CrunchOperation {
    private float[] arr;

    public void setArr(float[] values) {
        this.arr = values;
    }

    public NumberCruncherTopLevel(float[] values) {
        setArr(values);
    }

    @Override
    public void crunch(float[] values) {

    }

    public void sum(float[] values) {
        NumberCruncherTopLevel nc = new sum(values);
        nc.crunch(arr);
        arr = nc.getNumbers();
    }

    public void swirl(float[] values) {
        NumberCruncherTopLevel nc = new swirl(values);
        nc.crunch(arr);
        arr = nc.getNumbers();
    }

    public void divide(float[] values) {
        NumberCruncherTopLevel nc = new divide(values);
        nc.crunch(arr);
        arr = nc.getNumbers();
    }

    public void substract(float[] values) {
        NumberCruncherTopLevel nc = new substract(values);
        nc.crunch(arr);
        arr = nc.getNumbers();
    }

    public void average(float[] values) {
        NumberCruncherTopLevel nc = new average(values);
        nc.crunch(arr);
        arr = nc.getNumbers();
    }

    public float[] getNumbers() {
        return arr;
    }


    public void crunch(String[] operations) {
        for (String operation : operations) {
            switch (operation) {
                case "sum" -> sum(arr);
                case "swirl" -> swirl(arr);
                case "divide" -> divide(arr);
                case "substract" -> substract(arr);
                case "average" -> average(arr);
            }
        }
    }
}


class sum extends NumberCruncherTopLevel {
    public sum(float[] values) {
        super(values);
    }

    @Override
    public void crunch(float[] values) {
        float[] temp = new float[values.length];
        temp[0] = values[0];
        for (int i = 0; i < values.length - 1; i++) {
            temp[i + 1] = values[i] + values[i + 1];
        }
        values = temp;
        setArr(values);
    }
}

class swirl extends NumberCruncherTopLevel {

    public swirl(float[] values) {
        super(values);
    }

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
            float temp = values[randomNum];
            values[randomNum] = values[randomNum2];
            values[randomNum2] = temp;
            setArr(values);
        }
        if(Arrays.equals(tempArr, values)){
            crunch(values);
        }
    }
}

class divide extends NumberCruncherTopLevel {

    public divide(float[] values) {
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

class substract extends NumberCruncherTopLevel {

    public substract(float[] values) {
        super(values);
    }

    @Override
    public void crunch(float[] values) {
        float[] temp = new float[values.length];
        temp[0] = values[0];
        for (int i = 0; i < values.length - 1; i++) {
            temp[i + 1] = values[i] - values[i + 1];
        }
        values = temp;
        setArr(values);
    }
}

class average extends NumberCruncherTopLevel {

    public average(float[] values) {
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

