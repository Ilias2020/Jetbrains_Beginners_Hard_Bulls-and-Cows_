import java.util.Scanner;

public class GameLog {
    public static void gameLog(String code) {
        System.out.println("Okay, let's start a game!");
        int codeInt = Integer.parseInt(code);

        String answer = "";
        int turn = 1;
        while (!answer.equals(code)) {

            System.out.printf("Turn %d:\n", turn);
            answer = gameTurn(codeInt);
            turn++;
        }
    }
    public static String gameTurn(int codeInt) {
        String code = String.valueOf(codeInt);
        char[] codeChar = code.toCharArray();
        String answer;
        answer = new Scanner(System.in).nextLine();
        char[] answerChar = answer.toCharArray();
        int bull = 0;
        int cow = 0;

        for (int i = 0; i < answer.length(); i++) {
            if (answerChar[i] == codeChar[i]) {
                bull++;
                codeChar[i] = 'a';
            }
        }
        for (int j = 0; j < answer.length(); j++) {
            for (int k = 0; k < answer.length(); k++) {
                if (answerChar[k] == codeChar[j]) {
                    cow++;
                    codeChar[j] = 'a';
                    break;
                }
            }
        }
        if (bull == 4) {
            System.out.println("Grade: 4 bulls." +
                    "Congratulations! You guessed the secret code.");
        } else if (bull > 0 && cow > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n", bull, cow);
        } else if (bull > 0) {
            System.out.printf("Grade: %d bull(s).\n", bull);
        } else if (cow > 0) {
            System.out.printf("Grade: %d cow(s).\n", cow);
        } else {
            System.out.println("Grade: None.");
        }
        return answer;
    }
}