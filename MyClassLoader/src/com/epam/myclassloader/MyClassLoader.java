package com.epam.myclassloader;


import java.io.*;

public class MyClassLoader extends ClassLoader {

    public final String[] classPath;

    public MyClassLoader(String[] classPath) {
        this.classPath = classPath;
    }

    @Override
    protected synchronized Class loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class result = findClass(name);
        if (resolve) {
            resolveClass(result);
        }
        return result;
    }

    @Override
    protected Class findClass(String name) throws ClassNotFoundException {

        File f = findFile(name.replace('.', '/'), ".class");
        System.out.println("Class " + name + (f == null ? "" : " found in "
                + "\n  " + f));

        if (f == null) {
            return findSystemClass(name);
        }
        try {
            byte[] classBytes = loadFileAsBytes(f);
            Class result = defineClass(name, classBytes, 0, classBytes.length);
            return result;
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException("Format of class file incorrect for class " + name + ": " + e);
        }
    }

    private File findFile(String name, String extension) {
        for (int k = 0; k < classPath.length; k++) {
            File f = new File((new File(classPath[k])).getPath() + File.separatorChar + name.replace('/', File.separatorChar) + extension);
            if (f.exists()) {
                return f;
            }
        }
        return null;
    }

    public static byte[] loadFileAsBytes(File file)
            throws IOException {
        byte[] result = new byte[(int) file.length()];
        FileInputStream f = new FileInputStream(file);
        try {
            f.read(result, 0, result.length);
        } finally {
            try {
                f.close();
            } catch (IOException e) {
            };
        }
        return result;

    }

}
