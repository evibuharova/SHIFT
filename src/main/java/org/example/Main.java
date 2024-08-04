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
        Statistic statistic=new Statistic("-f");
        readeFile("/Users/evi/Documents/SHIFTNEW/files/in1.txt", false, statistic);
        readeFile("/Users/evi/Documents/SHIFTNEW/files/in2.txt", true, statistic);
        statistic.printStatistic();
    }

    public static void readeFile(String fileName, boolean append,Statistic statistic) {
        BufferedReader reader;
        FileWriter writerInteger;
        FileWriter writerFloat;
        FileWriter writerString;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            writerInteger = new FileWriter("src/outInteger.txt", append);
            writerFloat = new FileWriter("src/outFloat.txt", append);
            writerString = new FileWriter("src/outString.txt", append);

            String line = reader.readLine();
            while (line != null) {
                //регулярное выражение для поиска целых чисел
                boolean isInteger = line.matches("\\d+");
                //регулярное выражение для поиска чисел с точкой чисел, а также отрицательных и в степени
                boolean isFloat = line.matches("^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$");
                if (isInteger) {
                    writerInteger.append(line);
                    writerInteger.append("\n");

                    int intLine = Integer.parseInt(line);
                    statistic.collectIntegers(intLine);
                } else if (isFloat) {
                    writerFloat.append(line);
                    writerFloat.append("\n");

                    float floatLine = Float.parseFloat(line);
                    statistic.collectFloat(floatLine);
                } else {
                    writerString.append(line);
                    writerString.append("\n");
                    
                    statistic.collectString();
                }
                line = reader.readLine();
            }
            writerInteger.flush();
            writerFloat.flush();
            writerString.flush();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}