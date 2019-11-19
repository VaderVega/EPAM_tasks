package IOStreams.Task1;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/IOStreams/Task1/code.txt";
        String outputFilePath = "src/main/resources/IOStreams/Task1/output.txt";

        ByteIO byteIO = new ByteIO(inputFilePath, outputFilePath);
        byteIO.write(outputFilePath);
    }
}
