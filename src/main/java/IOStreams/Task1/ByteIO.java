package IOStreams.Task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteIO {
    private String inputFilePath;
    private String outputFilePath;

    private StringBuilder sb = new StringBuilder();
    private Pattern pattern = Pattern.compile("package|import|class|private|public|protected|final|try|catch|" +
            "void|byte|char|int|double|long|String|for|while|do|if|else|this|super|");

    public ByteIO(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public String read(String inputFilePath){
        try(FileInputStream fileInputStream = new FileInputStream(inputFilePath)) {
            int count;
            while ((count = fileInputStream.read()) != -1)
                sb.append((char)count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void write(String outputFilePath) {
        byte[] data = search().getBytes();

        try(FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {
            for (byte b : data)
                fileOutputStream.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String search() {
        Map<String, Integer> result = new HashMap<>();
        Matcher m = pattern.matcher(read(inputFilePath));

        while (m.find()) {
            String group = m.group();
            if (result.containsKey(group)) {
                Integer count = result.get(group);
                result.put(group, ++count);
            } else
                if (!group.equals(""))
                    result.put(group, 1);
        }
        return result.toString();
    }
}
