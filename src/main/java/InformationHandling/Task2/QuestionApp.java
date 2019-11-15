package InformationHandling.Task2;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


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

    public void getChosenQuestion() {
        String str = bundle.getString(new StringBuilder().append("q").append(sc.nextInt()).toString());
        System.out.println(str);
    }

    public void getAllQuestions() {
        Set<String> keys = bundle.keySet();
        AtomicInteger num = new AtomicInteger(1);
        List<String> questions = keys.stream().limit(7)
                .map(x -> bundle.getString(x))
                .peek(x -> System.out.println(num.getAndIncrement() + ". " + x))
                .collect(Collectors.toList());
    }

    public void getAnswer() {
        String str = bundle.getString(new StringBuilder().append("a").append(sc.nextInt()).toString());
        System.out.println(str);
    }

}
