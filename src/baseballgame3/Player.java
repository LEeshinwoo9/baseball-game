package baseballgame3;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private Scanner scanner = new Scanner(System.in);
    private String userInput;

    public String getInput(int expectedLength) {
        while (true) {
            System.out.print(expectedLength + "자리 숫자를 입력하세요: ");
            userInput = scanner.nextLine().replaceAll("\\s+", "");;

            if (validateInput(userInput, expectedLength)) {
                return userInput;
            }
        }
    }

    private boolean validateInput(String userInput, int expectedLength) {
        return validateEmptyInput(userInput) &&
                validateNumericInput(userInput) &&
                validateLength(userInput, expectedLength) &&
                validateNoDuplicates(userInput);
    }

    private boolean validateEmptyInput(String userInput) {
        if (userInput.isEmpty()) {
            System.out.println("입력값이 비어 있습니다. 다시 입력하세요.");
            return false;
        }
        return true;
    }

    private boolean validateNumericInput(String userInput) {
        if (!userInput.matches("\\d+")) { // 숫자가 아닌 문자 포함 체크
            System.out.println("숫자만 입력해야 합니다. 다시 입력하세요.");
            return false;
        }
        return true;
    }

    private boolean validateLength(String userInput, int expectedLength) {
        if (userInput.length() != expectedLength) {
            System.out.println(+ expectedLength + "자리 숫자를 입력해야 합니다. 다시 입력하세요.");
            return false;
        }
        return true;
    }

    private boolean validateNoDuplicates(String userInput) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : userInput.toCharArray()) {
            if (!uniqueChars.add(c)) {
                System.out.println("중복된 숫자가 있습니다. 다시 입력하세요.");
                return false;
            }
        }
        return true;
    }
}



