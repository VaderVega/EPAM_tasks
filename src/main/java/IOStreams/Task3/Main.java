package IOStreams.Task3;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/IOStreams/Task3/utf8text.txt";
        String outputFilePath = "src/main/resources/IOStreams/Task3/utf16text.txt";

        String UTF8code = "UTF-8";
        String UTF16code = "UTF-16";


        EncodingChanger encodingChanger = new EncodingChanger();
        encodingChanger.changeToUTF16(inputFilePath, outputFilePath);


        System.out.println(encodingChanger.read(outputFilePath, UTF16code));
    }
}
