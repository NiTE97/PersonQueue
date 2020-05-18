package com.company;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class NumberCruncherAnonym {
    private float[] arr;
    private float[] edited;

    public void deleteArray(){
        edited = null;
    }

    public NumberCruncherAnonym(float [] values){
        setArray(values);
    }

    public void setArray(float [] values){
        this.arr = values;
    }

    public void setNewArray(float [] values){
        this.edited = values;
    }

    public float [] getNewNumbers(){
        return edited;
    }


    public float[] getNumbers() {
        return arr;
    }

    public void crunch(String [] operations) {
        float [] tempArr;

        for (String operation : operations) {

            if (edited != null){
                tempArr = edited;
            }else{
                tempArr = arr;
            }

            switch (operation) {
                case "sum" :
                    sum(tempArr);
                    break;
                case "swirl":
                    swirl(tempArr);
                    break;
                case "divide":
                    divide(tempArr);
                    break;
                case "subtract":
                    subtract(tempArr);
                    break;
                case "average":
                    average(tempArr);
                    break;
            }
        }
        edited = getNewNumbers();
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
                setNewArray(values);
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
                    float temp = tempArr[randomNum];
                    tempArr[randomNum] = tempArr[randomNum2];
                    tempArr[randomNum2] = temp;
                    setNewArray(tempArr);
                }
                if(Arrays.equals(tempArr, values)){
                    crunch(values);
                }
            }
        };
        co.crunch(values);

    }

    void divide(float[] values) {
        CrunchOperation co = new CrunchOperation() {
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
                setNewArray(temp2);

            }
        };
        co.crunch(values);

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
                setNewArray(values);
            }
        };
        co.crunch(values);
    }

    void average(float[] values) {
        CrunchOperation co = new CrunchOperation() {
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
                setNewArray(tempArr);
            }
        };
        co.crunch(values);
    }
}