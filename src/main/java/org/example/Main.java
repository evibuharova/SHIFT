package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
//    public static void main(String[] args) throws Exception {
//        System.out.println("Argument count: " + args.length);//        for (int i = 0; i < args.length; i++) {
//            System.out.println("Argument " + i + ": " + args[i]);//        }
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));//        FileInputStream fileName=new FileInputStream(reader.readLine());
//        while (fileName.available()>0){//            System.out.print((char)fileName.read());}
//        reader.close();//        fileName.close();

    public static void main(String[] args) {
        List<String> argsList = Arrays.asList(args);

        // "/Users/evi/Documents/SHIFTNEW/files/in1.txt"
        List<String> files = ArgsHelper.getFiles(argsList);

        String statisticType = ArgsHelper.getStatisticType(argsList);
        String outputPath = ArgsHelper.getOutputPath(argsList);
        String filePrefix = ArgsHelper.getFilePrefix(argsList);

        Statistic statistic = new Statistic(statisticType);
        for (int i = 0; i < files.size(); i++) {
            readFile(files.get(i), i!=0, statistic, outputPath, filePrefix);
        }
        statistic.printStatistic();
    }

    public static void readFile(String fileName, boolean append, Statistic statistic, String outputPath, String filePrefix) {
        BufferedReader reader;
        FileWriter writerInteger;
        FileWriter writerFloat;
        FileWriter writerString;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            writerInteger = createWriter(outputPath + filePrefix + "outInteger.txt", append);
            writerFloat = createWriter(outputPath + filePrefix + "outFloat.txt", append);
            writerString = createWriter(outputPath + filePrefix + "outString.txt", append);

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

    private static FileWriter createWriter(String path, boolean append) throws IOException {
        File file = new File(path);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists() && !parent.mkdirs()) {
            // TODO Не получилось создать файл - вывести в консоль?
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return new FileWriter(file, append);
    }

}