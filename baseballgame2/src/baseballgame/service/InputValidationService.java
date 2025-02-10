package baseballgame.service;

public class InputValidationService {


    public boolean validateEmptyInput(String userInput) {
        if (userInput.isEmpty()) {
            System.out.println("입력값이 비어 있습니다. 다시 입력하세요.");
            return false;
        }
        return true;
    }


    public boolean validateNumericInput(String userInput) {
        if (!userInput.matches("\\d+")) { //
            System.out.println("숫자만 입력해야 합니다. 다시 입력하세요.");
            return false;
        }
        return true; //
    }



    public boolean validateLength(String userInput, int randNumSize) {
        if (userInput.length() != randNumSize) {
            System.out.println(randNumSize + "자리 숫자를 입력해야 합니다. 다시 입력하세요.");
            return false;
        }
        return true;
    }
}
