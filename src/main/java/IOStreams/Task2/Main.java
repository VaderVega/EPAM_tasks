package IOStreams.Task2;

import IOStreams.Task1.ByteIO;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/IOStreams/Task2/code.txt";
        String outputFilePath = "src/main/resources/IOStreams/Task2/output.txt";

        SymbolIO symbolIO = new SymbolIO(inputFilePath, outputFilePath);
        symbolIO.write(outputFilePath);
    }
}
