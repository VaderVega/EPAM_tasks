package InformationHandling.Task2;


import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class QuestionApp {
    private ResourceBundle bundle;


    private Locale locale = Locale.US;

    private Scanner sc = new Scanner(System.in);

    public QuestionApp() {
        bundle = ResourceBundle.getBundle("InformationHandling_task2/questionapp", locale);
    }


    public void setLocale() {
        System.out.println("Choose the language: 1 - rus; 2 - eng");

        int chosenLang = sc.nextInt();

        switch (chosenLang) {
            case 1:
                locale = new Locale("ru", "RU");
                bundle = ResourceBundle.getBundle("InformationHandling_task2/questionapp", locale);
                break;
            case 2:
                locale = new Locale("en", "US");
                bundle = ResourceBundle.getBundle("InformationHandling_task2/questionapp", locale);
                break;
            default:
                setLocale();
        }
    }

    public void getChosenQuestion(int number) {
        int chosenQuestion = sc.nextInt();
        String str = bundle.getString(new StringBuilder().append("q").append(number).toString());
        System.out.println(str);
    }

    public void getAnswer() {

    }

}
