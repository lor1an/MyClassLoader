
import java.io.*;

public class Test {

    public static void main(String[] argv) throws Exception {

        for (;;) {

            ClassLoader loader = new DynamicClassOverloader(new String[]{".","","C:\\Users\\lor1an\\Documents\\NetBeansProjects\\MyClassLoader\\MyClassLoader\\build\\classes"});

      // текущий каталог "." будет единственным каталогом поиска
            Class clazz = Class.forName("TestModule", true, loader);

            Object object = clazz.newInstance();

            System.out.println(object);

            new BufferedReader(new InputStreamReader(System.in)).readLine();

        }

    }

}
