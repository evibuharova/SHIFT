package org.example;

public class Statistic {

    String statisticType;
    int countLinesIntegers = 0;
    int countLinesFloats = 0;
    int countLinesStrings = 0;

    int maxValueInteger = Integer.MIN_VALUE;
    int minValueInteger = Integer.MAX_VALUE;
    float maxValueFloat = Float.MIN_VALUE;
    float minValueFloat = Float.MAX_VALUE;

    int sumInteger = 0;
    float sumFloat = 0f;
    int averageInteger = 0;
    float averageFloat = 0;

    public Statistic(String statisticType){
        this.statisticType=statisticType;
    }
    public void collectIntegers(int intLine){
        sumInteger = intLine + sumInteger;
        if (minValueInteger > intLine) {
            minValueInteger = intLine;
        }
        if (maxValueInteger < intLine) {
            maxValueInteger = intLine;
        }
        countLinesIntegers++;
    }

    public void collectFloat(float floatLine) {
        sumFloat = floatLine + sumFloat;
        if (minValueFloat > floatLine) {
            minValueFloat = floatLine;
        }
        if (maxValueFloat < floatLine) {
            maxValueFloat = floatLine;
        }
        countLinesFloats++;
    }
    public void collectString(){
        countLinesStrings++;
    }
    public  void printStatistic () {
        if (statisticType == "-s") {
            System.out.println("Count of integer`s line is " + countLinesIntegers);
            System.out.println("Count of float`s line is " + countLinesFloats);
            System.out.println("Count of string`s line is " + countLinesStrings);

        } else if (statisticType == "-f") {
            averageInteger = (sumInteger / countLinesIntegers);
            averageFloat = (sumFloat / countLinesFloats);
            System.out.println("Min value of integer`s line is " + minValueInteger);
            System.out.println("Max value of integer`s line is " + maxValueInteger);
            System.out.println("Min value of float`s line is " + minValueFloat);
            System.out.println("Max value of float`s line is " + maxValueFloat);
            System.out.println("Sum integers is " + sumInteger);
            System.out.println("Sum floats is " + sumFloat);
            System.out.println("Average integers is " + averageInteger);
            System.out.println("Average floats is " + averageFloat);
        }
    }
}
