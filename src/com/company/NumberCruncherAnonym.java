package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class NumberCruncherAnonym {
    float[] arr;



    public float[] sum(float[] values) {
        CrunchOperation co = new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                float[] temp = new float[values.length];
                temp[0] = values[0];
                for (int i = 0; i < values.length - 1; i++) {
                    temp[i + 1] = values[i] + values[i + 1];
                }
                values = temp;
                arr = values;
            }
        };
        co.crunch(values);
        return arr;

    }

    float[] swirl(float[] values) {
        CrunchOperation co = new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                for (int i = 0; i < values.length; i++) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, values.length);
                    int randomNum2 = ThreadLocalRandom.current().nextInt(0, values.length);
                    float temp = values[randomNum];
                    values[randomNum] = values[randomNum2];
                    values[randomNum2] = temp;
                    arr = values;
                }
            }
        };
        co.crunch(values);
        return arr;
    }

    float[] divide(float[] values) {
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
                arr = values;

            }
        };
        co.crunch(values);
        return arr;
    }

    float[] substract(float[] values) {
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
        return arr;
    }

    float[] average(float[] values) {
        CrunchOperation co = new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                float temp = 0;
                for (float v : values) {
                    temp += v;
                }
                temp = temp / values.length;
                values[Methoden.findMax(values)] = temp;
                arr = values;
            }
        };
        co.crunch(values);
        return arr;
    }




}

