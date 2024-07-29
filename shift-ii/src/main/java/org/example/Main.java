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
            BufferedReader reader;

            try {
                reader = new BufferedReader(new FileReader("in1.txt"));
                String line = reader.readLine();

                while (line != null) {
                    System.out.println(line);
                    // read next line
                    line = reader.readLine();
                }

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
