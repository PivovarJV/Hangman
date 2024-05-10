import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
    //метод добавляющий слова из файла в лист
    public static List<String> words() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("Words"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        scanner.close();
        return words;
    }

    // метод берущий рандомное слово из списка
    public static String getRandomWord(List<String> words) {
        if (words.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndedx = random.nextInt(words.size());
        return words.get(randomIndedx);
    }
    // метод скрывающий слово за маской
    public static String markWord(String word) {
        StringBuilder maskedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            maskedWord.append("*");
        }
        return maskedWord.toString();
    }
}
