package InformationHandling.Task2;

import java.util.Scanner;

public class Main {
    boolean isQuestionsShowed;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuestionApp app = new QuestionApp();

        String showAnswer = "4 - Show answer";
        String[] Options = new String[]{
                "1 - Show the questions list",
                "2 - Change locale",
                "3 - Quit"
        };

        System.out.println("Welcome to Question App! Choose the option (type the number of chosen option and press ENTER):");
        while (true) {
            System.out.println();
            for (String s : Options) {
                System.out.println(s);
            }

            int option = sc.nextInt();
            switch (option) {
                case 1:
                    app.getAllQuestions();
                    System.out.println();
                    System.out.println("1 - Show answer\n2 - Back to menu");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Enter the number of the question you want to get an answer to");
                            app.getAnswer();
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 2:
                    app.setLocale();
                    break;
                case 3:
                    return;
            }

        }
    }
}
