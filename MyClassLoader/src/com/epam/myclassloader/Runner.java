package com.epam.myclassloader;

import java.io.*;
import java.util.Scanner;

public class Runner {

    public static void main(String[] argv) throws Exception {

        while (true) {
            String exit;
            String uname1 = "lor1an";
            String uname2 = "Anatolii_Hlazkov";
            String pathToClasses = "C:\\Users\\" + uname1
                    + "\\Documents\\NetBeansProjects\\MyClassLoader\\MyClassLoader\\build\\classes";
            ClassLoader loader = new MyClassLoader(new String[]{pathToClasses});
            Class clas = Class.forName("com.epam.myclassloader.RecompilingClass", true, loader);
            Object object = clas.newInstance();
            System.out.println(object);
            exit = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if (exit.equalsIgnoreCase("exit") || exit.equalsIgnoreCase("e")) {
                break;
            }
        }
    }
}
