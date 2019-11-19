package IOStreams.Task3;

import java.io.*;

public class EncodingChanger {
    private StringBuilder builder = new StringBuilder();

    public String read(String path, String code) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), code))) {

            while (reader.ready()) {
                builder.append(reader.readLine().concat(" :" + code));
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return builder.toString();
    }

    public void changeToUTF16(String inputFilePath, String outputFilePath) {
        String text;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(inputFilePath), "utf-8"));

             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                     new FileOutputStream(new File(outputFilePath)), "utf-16"))) {

            while ((text = reader.readLine()) != null) {
                writer.write(text);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
