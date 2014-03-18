
import java.io.*;

public class Test {

    public static void main(String[] argv) throws Exception {

        for (;;) {
            System.out.println("ii");
            String exit;
            String uname1 = "lor1an";
            String uname2 = "Anatolii_Hlazkov";
            String pathToClasses = "C:\\Users\\" + uname2
                    + "\\Documents\\NetBeansProjects\\MyClassLoader\\MyClassLoader\\build\\classes";
            ClassLoader loader
                    = new DynamicClassOverloader(new String[]{".", "", pathToClasses});

            Class clas = Class.forName("TestModule", true, loader);
            Object object = clas.newInstance();
            System.out.println(object);
            exit = new BufferedReader(new InputStreamReader(System.in)).readLine();

            if (exit.equalsIgnoreCase("exit") || exit.equalsIgnoreCase("e")) {
                break;
            }

        }

    }

}
