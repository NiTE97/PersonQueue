package com.company;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class NumberCruncherAnonym {
    private float[] arr;

    public NumberCruncherAnonym(float [] values){
        setArray(values);
    }

    public void setArray(float [] values){
        this.arr = values;
    }


    public float[] getNumbers() {
        return arr;
    }

    public void crunch(String [] operations) {
        for (String operation : operations) {

            switch (operation) {
                case "sum":
                    sum(arr);
                    break;
                case "swirl":
                    swirl(arr);
                    break;
                case "divide":
                    divide(arr);
                    break;
                case "subtract":
                    subtract(arr);
                    break;
                case "average":
                    average(arr);
                    break;
            }
        }
    }



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
                setArray(values);
            }
        };
        co.crunch(values);
    }

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
                    float temp = values[randomNum];
                    values[randomNum] = values[randomNum2];
                    values[randomNum2] = temp;
                }
                if(Arrays.equals(tempArr, values)){
                    crunch(values);
                }
            }
        };
        co.crunch(values);
        setArray(values);

    }

    void divide(float[] values) {
        CrunchOperation co = new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                float[] temp = new float[values.length];
                int max;
                int p = values.length - 1;


                //temp Array mit arr Fuellen
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
                setArray(values);

            }
        };
        co.crunch(values);
        setArray(arr);

    }

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
                arr = values;
            }
        };
        co.crunch(values);
    }

    void average(float[] values) {
        CrunchOperation co = new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                float temp = 0;
                for (float v : values) {
                    temp += v;
                }
                temp = temp / values.length;
                values[Methoden.findMax(values)] = temp;
                setArray(values);
            }
        };
        co.crunch(values);
    }
}