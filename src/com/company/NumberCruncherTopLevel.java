package com.company;

public class NumberCruncherTopLevel implements CrunchOperation {
    private float[] arr;
    private float [] edited;

    public void deleteArray(){
        edited = null;
    }

    public void setArr(float[] values) {
        this.arr = values;
    }

    public void setNewArr(float[] values) {
        this.edited = values;
    }

    public NumberCruncherTopLevel(float[] values) {
        setArr(values);
    }

    @Override
    public void crunch(float[] values) {
    }

    public void sum(float[] values) {
        NumberCruncherTopLevel nc = new Sum(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    public void swirl(float[] values) {
        NumberCruncherTopLevel nc = new Swirl(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    public void divide(float[] values) {
        NumberCruncherTopLevel nc = new Divide(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    public void subtract(float[] values) {
        NumberCruncherTopLevel nc = new Subtract(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    public void average(float[] values) {
        NumberCruncherTopLevel nc = new Average(values);
        nc.crunch(values);
        edited = nc.getNewNumbers();
    }

    public float[] getNumbers() {
        return arr;
    }

    public float[] getNewNumbers() {
        return edited;
    }


    public void crunch(String[] operations) {
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
}


