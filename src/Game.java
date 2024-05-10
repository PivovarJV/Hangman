import java.util.Scanner;

public class Game {
    public static void startGame() {
        String secretWord = ReadFile.getRandomWord(ReadFile.words());
        String guesseWord = ReadFile.markWord(secretWord);
        int attempts = 7;

        System.out.println(secretWord);

        Scanner scanner = new Scanner(System.in);

        while (attempts > 0 && !secretWord.toLowerCase().equals(guesseWord)) {
            System.out.println("Отгаданное слово: " + guesseWord);
            System.out.println("Количесвто попыток: " + attempts);
            System.out.print("Введите букву: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (secretWord.toLowerCase().contains(String.valueOf(guess))) {
                StringBuilder newGuessWord = new StringBuilder(guesseWord);
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.toLowerCase().charAt(i) == guess) {
                        newGuessWord.setCharAt(i,toLowerCase(guess));
                    }
                }
                guesseWord = newGuessWord.toString();
                System.out.println("Буква \"" + guess + "\" угадана");
            } else {
                attempts--;
                switch (attempts) {
                    case 6 :
                        TheMainGallows.mainMaps();
                        break;
                    case 5 :
                        TheMainGallows.mainMapsSecond();
                        break;
                    case 4 :
                        TheMainGallows.mainMapsThree();
                        break;
                    case 3 :
                        TheMainGallows.mainMapsFor();
                        break;
                    case 2 :
                        TheMainGallows.mainMapsFive();
                        break;
                    case 1 :
                        TheMainGallows.mainMapsSix();
                        break;
                    case 0 :
                        TheMainGallows.mainMapsSeven();
                        break;
                }
                System.out.println("Буквы \"" + guess + "\" нет в слове");
            }
        }

        if (secretWord.toLowerCase().equals(guesseWord)) {
            System.out.println("Поздравляю, Вы отгадали слвоо!");
            restartGame();
        } else {
            System.out.println("К сожалению, вы исчерпали все попытки");
            restartGame();
        }
        scanner.close();
    }

    public static char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    public static void restartGame() {
        while (true) {
            System.out.println("Хотите сыграть еще раз?");
            System.out.println("\"Y\"(Да)\" N\"(Нет)");
            Scanner scanner1 = new Scanner(System.in);
            String answer = scanner1.nextLine();
            if (answer.equals("Y")) {
                startGame();
                scanner1.close();
            } else if (answer.equals("N")) {
                System.out.println("Всего хорошего!");
                scanner1.close();
                break;
            } else {
                System.out.println("Ввод некорректный, попробуйте еще раз");
            }
        }
    }
}
