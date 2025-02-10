package baseballgame1.controller;
import baseballgame1.view.GameView;
import baseballgame1.service.RandomNumberService;
import baseballgame1.service.InputValidationService;
import baseballgame1.service.CompareService;
import java.util.Scanner;

public class BaseballGame {


    public class baseballGame {
        private final Scanner scanner = new Scanner(System.in);
        private final GameView gameView = new GameView();
        private final RandomNumberService randomNumberService = new RandomNumberService();
        private final InputValidationService inputValidationService = new InputValidationService();
        private final CompareService compareService = new CompareService();


        public void playGame() {
            gameView.startGame();

            while (true) {
                int[] randNumArray = randomNumberService.generateRandomNum();
                int randNumSize = randNumArray.length;

                if (!playRound(randNumArray, randNumSize)) {
                    break;
                }
            }
            scanner.close();
        }

        private boolean playRound(int[] randNumArray, int randNumSize) {
            while (true) {
                gameView.askForInput(randNumSize);

                int[] userNumbers = getValidUserInput(randNumSize);
                int[] result = compareService.compareNumbers(userNumbers, randNumArray);
                gameView.showResult(result[0], result[1]);

                if (result[0] == randNumSize) {
                    gameView.showWinMessage(randNumSize);
                    return askRetry();
                }
            }
        }

        private int[] getValidUserInput(int randNumSize) {
            while (true) {
                String userInput = scanner.nextLine().replaceAll("\\s+", "");


                if (!inputValidationService.validateEmptyInput(userInput)) continue;
                if (!inputValidationService.validateNumericInput(userInput)) continue;
                if (!inputValidationService.validateLength(userInput, randNumSize)) continue;

                return inputValidationService.getValidUserInput(userInput);
            }
        }
        public boolean askRetry() {
            while (true) {
                gameView.askRetry();
                String retry = scanner.nextLine().trim().toUpperCase();

                if (retry.equals("Y")) {
                    return true;
                }
                if (retry.equals("N")) {
                    return false;
                }

                gameView.showInvalidRetryMessage();
            }
        }

        public void main(String[] args) {
            new baseballGame().playGame();
        }
    }
}
