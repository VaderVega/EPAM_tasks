package ExceptionsAndErrors.Task1;

import java.io.*;
import java.nio.file.NotDirectoryException;
import java.util.Arrays;

public class FileManager {
    String path = "src/main/resources/ExceptionsAndErrors/Task1";
    private File file = new File(path);

    public void createFile(String fileName) {
        String pathToFile = file.getPath() + '/' + fileName + ".txt";
        try {
            File newFile = new File(pathToFile);
            if (newFile.exists())
                throw new FileNotFoundException("File " + fileName + " is already exist.");
            else {
                newFile.createNewFile();
                System.out.println("File " + fileName + " successfuly created.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String fileName) {
        String pathToFile = file.getPath() + '/' + fileName + ".txt";
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(pathToFile))
        )) {
            String lineToRead;
            while ((lineToRead = reader.readLine()) != null)
                System.out.println(lineToRead);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String fileName, String text) {
        String pathToFile = file.getPath() + '/' + fileName + ".txt";
        File file = new File(pathToFile);

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(
                new FileWriter(pathToFile, true)
        ))) {
            if (file.exists()) {
                writer.write(text);
                writer.close();
                System.out.println("Text writnig complete.");
            }
        } catch (IOException e) {
            System.out.println("Text insertion failed.");
        }
    }

    public void deleteFile(String fileName) {
        String pathToFile = file.getPath() + '/' + fileName + ".txt";
        try {
            File delfile = new File(pathToFile);
            if (!delfile.isFile() & !delfile.exists()) {
                System.out.println("is not a file or file doesent exist");
            } else {
                delfile.delete();
                System.out.println("file : \"" + fileName + "\" is already deleted");
            }
        } catch (NullPointerException e) {
            System.err.println("file not found");
        }
    }

    public void showFiles() {
        file = new File(file.getPath());
        String[] fileList = file.list();
        for (String s : fileList)
            System.out.println(s);
        System.out.println();
    }

    public void upDirectory() {
        try {
            file = new File(file.getParent());
            System.out.println("\n" + file.getAbsolutePath() + "\n");
        } catch (NullPointerException e) {
            System.out.println("Current directory is root.");
        }
    }

    public void downDirectory(String directory) {
        try {
            file = new File(file.getPath() + File.separator + directory);
            if (!file.isDirectory()) {
                file = new File(file.getParent());
                throw new NotDirectoryException(file.toString());
            }
            System.out.println("\n" + file.getAbsolutePath() + "\n");
        } catch (NullPointerException | NotDirectoryException e) {
            System.out.println("Wrong directory name.");
        }
    }
}
