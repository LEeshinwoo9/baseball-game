package baseballgame.controller;

import baseballgame2.util.ParseUtil;
import baseballgame2.view.GameView;
import baseballgame2.util.RandomNumberUtil;
import baseballgame2.service.InputValidationService;
import baseballgame2.service.CompareService;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
    private final Scanner scanner = new Scanner(System.in);
    private final GameView gameView = new GameView();
    private final RandomNumberUtil randomNumberService = new RandomNumberUtil();
    private final InputValidationService inputValidationService = new InputValidationService();
    private final CompareService compareService = new CompareService();
    private final ParseUtil parseUtil = new ParseUtil();

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

            return parseUtil.getValidUserInput(userInput);
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

    public static void main(String[] args) {
        new BaseballGame().playGame();
    }
}
