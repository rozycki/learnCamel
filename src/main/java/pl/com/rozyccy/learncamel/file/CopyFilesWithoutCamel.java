package pl.com.rozyccy.learncamel.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Marcin.Rozycki on 2018-03-16.
 */
public class CopyFilesWithoutCamel {

    public static void main(String[] args) {

        // Step 1: Create a file Object to read the directories
        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        // Step 2: Read the files from the directory and iterate the files
        File[] files = inputDirectory.listFiles();
        try {
            for (File source : files) {
                if (source.isFile()) {
                    File dest = new File(outputDirectory.getPath() + File.separator + source.getName());

                    // Step 3: Create the output stream and read the files
                    OutputStream outputStream = new FileOutputStream(dest);
                    byte[] buffer = new byte[(int) source.length()];
                    FileInputStream inputStream = new FileInputStream(source);
                    inputStream.read(buffer);
                    try {
                        outputStream.write(buffer);
                    } finally {
                        // Step 4 Close the Streams
                        outputStream.close();
                        inputStream.close();
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Exception is: " + e);
            e.printStackTrace();
        }

    }
}
