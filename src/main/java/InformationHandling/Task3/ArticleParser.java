package InformationHandling.Task3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleParser {
    private final InputStream inputStream = getClass().getResourceAsStream(
        "/InformationHandling_task3/article.html");

    private String getContent() {
        try (ByteArrayOutputStream content = new ByteArrayOutputStream()){
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1)
                content.write(buffer, 0, length);
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<String> getPartsWithReferences() {
        List<String > data = new ArrayList<>();

        String article = getContent();

        String pattern = "[А-Я](((э\\.д\\.с[.]?)|[^.!?]|)*?([Рр]ис\\.[^)]+?\\)))+((э\\.д\\.с[.]?)|[^.!?])*?[.!?]";

        Pattern p = Pattern.compile(pattern, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(article);

        while (m.find())
            data.add(m.group());

        return data;
    }

    public List<String> getPartsWithWrongReferenceOrder() {
        List<String> data = this.getPartsWithReferences();
        List<String> result = new ArrayList<>();
        String pattern = "[Рр]ис\\.\\s?\\d+";

        Pattern p = Pattern.compile(pattern, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m;

        for (String str : data) {

            m = p.matcher(str);
            int max = Integer.MIN_VALUE;
            boolean isContinue = true;

            while (m.find() && isContinue) {
                String s = m.group().replaceAll("[^0-9]", "");
                int pictureNum = Integer.parseInt(s);
                if (pictureNum < max) {
                    isContinue = false;
                    result.add(str);
                }
                max = pictureNum;
            }
        }
        return result;
    }
}
