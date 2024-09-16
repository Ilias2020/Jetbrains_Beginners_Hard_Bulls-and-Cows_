import java.util.Scanner;

public class RandomNumber {
    public static String randomNumber() {
        System.out.println("Please, enter the secret code's length:");
        int input = new Scanner(System.in).nextInt();
        StringBuilder num;
        if (input > 10) {
            System.out.printf("Error: can't generate a secret number with a " +
                    "length of %d because there aren't enough unique digits.\n", input);
            num = new StringBuilder();
        } else {
            long pseudoRandomNumber = System.nanoTime();
            do {
                num = new StringBuilder(Long.toString(pseudoRandomNumber % 10));
                pseudoRandomNumber /= 10;
            } while (num.toString().equals("0"));

            while (num.length() != input) {
                num.append(pseudoRandomNumber % 10);
                pseudoRandomNumber /= 10;
                num = checkUniqueDigit(num);
                if (pseudoRandomNumber == 0) {
                    pseudoRandomNumber = System.nanoTime();
                }
            }
        }
        return num.toString();
    }

    public static StringBuilder checkUniqueDigit(StringBuilder num) {
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(i) == num.charAt(j)) {
                    num.deleteCharAt(j);
                }
            }
        }
        return num;
    }
}