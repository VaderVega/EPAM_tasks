package ExceptionsAndErrors.Task1;

import java.util.Scanner;

public class ConsoleController {
    FileManager fileManager = new FileManager();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        String command = "";
        String dir;
        showCommandList();

        while (!command.equals("exit")) {
            command = scanner.next();
            switch (command) {
                case "help":
                    showCommandList();
                    break;
                case "show":
                    fileManager.showFiles();
                    break;
                case "up":
                    fileManager.upDirectory();
                    break;
                case "down":
                    dir = scanner.next();
                    fileManager.downDirectory(dir);
                    break;
                case "create":
                    dir = scanner.next();
                    fileManager.createFile(dir);
                case "read":
                    dir = scanner.next();
                    fileManager.readFile(dir);
                case "write":
                    dir = scanner.next();
                    String text = scanner.nextLine();
                    fileManager.writeToFile(dir, text);
                case "delete":
                    dir = scanner.next();
                    fileManager.deleteFile(dir);
                default:
                    System.out.println("Wrong command!");
                    break;
            }
        }
    }

    public void showCommandList() {
        System.out.println(
                "help                       - print all commands \n" +
                "show                       - print all content in directory \n" +
                "up                         - up to parent directory \n" +
                "down +text                 - down to lower directory \n" +
                "create +text               - create new .txt file \n" +
                "read +filename             - read .txt file\n" +
                "write +filename +text      - write new .txt file \n" +
                "delete +filename           - delete .txt file \n" +
                "exit                       - close program \n");
    }


}
