package com.company;

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
        NumberCruncherTopLevel nc = new Sum(values);
        nc.crunch(arr);
    }

    public void swirl(float[] values) {
        NumberCruncherTopLevel nc = new Swirl(values);
        nc.crunch(arr);
    }

    public void divide(float[] values) {
        NumberCruncherTopLevel nc = new Divide(values);
        nc.crunch(arr);
    }

    public void subtract(float[] values) {
        NumberCruncherTopLevel nc = new Subtract(values);
        nc.crunch(arr);
    }

    public void average(float[] values) {
        NumberCruncherTopLevel nc = new Average(values);
        nc.crunch(arr);
    }

    public float[] getNumbers() {
        return arr;
    }


    public void crunch(String[] operations) {
        for (String operation : operations) {
            switch (operation) {
                case "sum" :
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
}


