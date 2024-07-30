package org.example;
import java.io.*;

public class Main {

//    public static void main(String[] args) throws Exception {
//        System.out.println("Argument count: " + args.length);
//        for (int i = 0; i < args.length; i++) {
//            System.out.println("Argument " + i + ": " + args[i]);
//        }
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream name=new FileInputStream(reader.readLine());
//        while (name.available()>0){
//            System.out.print((char)name.read());}
//        reader.close();
//        name.close();


    public static void main(String[] args) {
        readeFile("in1.txt", false);
        readeFile("in2.txt", true);

    }

    public static void readeFile(String fileName, boolean append) {
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
                System.out.println(line);
                //регулярное выражение для поиска целых чисел
                boolean isInteger = line.matches("\\d+");
                //регулярное выражение для поиска чисел с точкой чисел, а также отрицательных и в степени
                boolean isFloat = line.matches("^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$");
                System.out.println(isInteger);
                if (isInteger) {
                    try {
                        writerInteger.append(line);
                        writerInteger.append("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (isFloat) {
                    try {
                        writerFloat.append(line);
                        writerFloat.append("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        writerString.append(line);
                        writerString.append("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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