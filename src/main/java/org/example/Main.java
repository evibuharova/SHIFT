package org.example;
import java.io.*;

public class Main {
//    public static void main(String[] args) throws Exception {
//        System.out.println("Argument count: " + args.length);//        for (int i = 0; i < args.length; i++) {
//            System.out.println("Argument " + i + ": " + args[i]);//        }
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));//        FileInputStream fileName=new FileInputStream(reader.readLine());
//        while (fileName.available()>0){//            System.out.print((char)fileName.read());}
//        reader.close();//        fileName.close();

    public static void main(String[] args) {
        readeFile("/Users/evi/Documents/SHIFTNEW/files/in1.txt", false);
        readeFile("/Users/evi/Documents/SHIFTNEW/files/in2.txt", true);
    }
    public static void readeFile(String fileName, boolean append) {
        BufferedReader reader;
        FileWriter writerInteger;
        FileWriter writerFloat;
        FileWriter writerString;
        int countLinesIntegers=0;
        int countLinesFloats=0;
        int countLinesStrings=0;
        String statistic="-s";
        String fullStatistic="-f";
        int maxValueInteger=Integer.MIN_VALUE;
        int minValueInteger=Integer.MAX_VALUE;
        float maxValueFloat=Float.MIN_VALUE;
        float minValueFloat=Float.MAX_VALUE;
        int sumInteger=0;
        float sumFloat=0f;
        int averageInteger=0;
        float averageFloat=0;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            writerInteger = new FileWriter("src/outInteger.txt", append);
            writerFloat = new FileWriter("src/outFloat.txt", append);
            writerString = new FileWriter("src/outString.txt", append);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                //регулярное выражение для поиска целых чисел
                boolean isInteger = line.matches("\\d+");
                //регулярное выражение для поиска чисел с точкой чисел, а также отрицательных и в степени
                boolean isFloat = line.matches("^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$");
                System.out.println(isInteger);
                if (isInteger) {
                    try {
                        int intLine=Integer.parseInt(line);
                        writerInteger.append(line);
                        writerInteger.append("\n");
                        sumInteger=intLine+sumInteger;
                        countLinesIntegers ++;
                        if (minValueInteger > intLine) {
                            minValueInteger=intLine;
                        }
                        if (maxValueInteger < intLine) {
                            maxValueInteger=intLine;
                        }

                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (isFloat) {
                    try {
                        float floatLine=Float.parseFloat(line);
                    writerFloat.append(line);
                    writerFloat.append("\n");
                    sumFloat=floatLine+sumFloat;
                        countLinesFloats ++;
                        if (minValueFloat > floatLine) {
                            minValueFloat=floatLine;
                        }
                        if (maxValueFloat < floatLine) {
                            maxValueFloat=floatLine;
                        }
                } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                } else
                {
                    try
                    {
                        writerString.append(line);
                        writerString.append("\n");
                        countLinesStrings ++;
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                line = reader.readLine();
            }
            writerInteger.flush();
            writerFloat.flush();
            writerString.flush();
            reader.close();
            averageInteger=(sumInteger/countLinesIntegers);
            averageFloat=(sumFloat/countLinesFloats);
            if (statistic=="-s")
            {
            System.out.println("Count of integer`s line is " + countLinesIntegers);
            System.out.println("Count of float`s line is " + countLinesFloats);
            System.out.println("Count of string`s line is " + countLinesStrings);
            System.out.println("Min value of integer`s line is " + minValueInteger);
            System.out.println("Max value of integer`s line is " + maxValueInteger);
            System.out.println("Min value of float`s line is " + minValueFloat);
            System.out.println("Max value of float`s line is " + maxValueFloat);
            System.out.println("Sum integers is " + sumInteger);
            System.out.println("Sum floats is " + sumFloat);
            System.out.println("Average integers is " + averageInteger);
            System.out.println("Average floats is " + averageFloat);
            }
            else if (statistic=="-f") {

            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}