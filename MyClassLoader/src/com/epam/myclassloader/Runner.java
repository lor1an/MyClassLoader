package com.epam.myclassloader;

import java.io.*;
import java.util.Scanner;

public class Runner {

    public static void main(String[] argv) throws Exception {
//
//        while (true) {
//
//            String uname1 = "lor1an";
//            String uname2 = "Anatolii_Hlazkov";
//            String pathToRecompilngClass = "com.epam.myclassloader.TestModule";
//            String pathToClasses = "C:\\Users\\Anatolii_Hlazkov\\Documents\\NetBeansProjects\\MyClassLoader\\MyClassLoader\\build\\classes\\com\\epam\\myclassloader";
//            ClassLoader loader
//                    = new MyClassLoader(new String[]{pathToClasses});
//            Class clas = Class.forName(pathToRecompilngClass, true, loader);
//            Object object = clas.newInstance();
//            System.out.println(object);
//
//            // System.out.println("You can edit class file for another output.");
//            //   System.out.println("Do you want to change message? y/n");
//            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
////            if (console.readLine().equalsIgnoreCase("y")) {
////                System.out.println("New message must be the same length as the old.");
////                BufferedReader n = new BufferedReader(new FileReader(".\\build\\classes\\com\\epam\\myclassloader\\TestModule.class"));
////                String str = "";
////                String resultString = "";
////                while ((str = n.readLine()) != null) {
////                    resultString += str;
////                }
////                
////                String[] mass = resultString.split(TestModule.SEPARATOR);
////                for (int i = 0; i < mass.length; i++) {
////                    if (mass[i].contains(TestModule.beginMark)
////                            && !mass[i].contains("java/lang/Object")) {
////                        String currentMessage = mass[i];
////                        currentMessage = currentMessage.replace(TestModule.beginMark, "");
////                        currentMessage = currentMessage.replace(TestModule.endMark, "");
////                        int currentMessageLength = currentMessage.length();
////                        System.out.println("Current message: " + currentMessage);
////                        System.out.println("Current length is " + currentMessageLength);
////                        System.out.println("Type new message: ");
////                        String newMessage = console.readLine();
////                        System.out.println(currentMessage);
////                        System.out.println(newMessage);
////                        newMessage = TestModule.beginMark + newMessage + TestModule.endMark;
////                        mass[i] = newMessage;
////                    }
////                }
////                for (String mas : mass) {
////                    resultString += mas;
////                }
////                OutputStream f = new FileOutputStream(".\\build\\classes\\com\\epam\\myclassloader\\TestModule.class");
////                f.write(resultString.getBytes());
////                System.out.println("\n");
////        }else {
//            System.out.println("Finish the program? y/n");
//            if (console.readLine().equalsIgnoreCase("y")) {
//                return;
//            }
//            System.out.println("\n");
//        }
        for (;;) {
            System.out.println("ii");
            String exit;
            String uname1 = "lor1an";
            String uname2 = "Anatolii_Hlazkov";
            String pathToClasses = "C:\\Users\\" + uname2 + "\\Documents\\NetBeansProjects\\MyClassLoader\\MyClassLoader\\build\\classes";
            ClassLoader loader = new MyClassLoader(new String[]{pathToClasses});
            Class clas = Class.forName("com.epam.myclassloader.TestModule", true, loader);
            Object object = clas.newInstance();
            System.out.println(object);
            exit = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if (exit.equalsIgnoreCase("exit") || exit.equalsIgnoreCase("e")) {
                break;
            }
        }
    }
}
//}
