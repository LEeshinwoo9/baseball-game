package baseballgame3;

import java.util.Scanner;

public class GameManager {
    private final Computer computer;
    private final Player player;
    private final Referee referee;
    private final Scanner scanner;

    public GameManager() {
        this.computer = new Computer();
        this.player = new Player();
        this.referee = new Referee();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        boolean playAgain = true;

        while (playAgain) {
            computer.generateRandomNum();  // 새로운 랜덤 숫자 생성
            int numberSize = computer.getRandomNumberSize();
//            int[] randomNum = computer.getRandomNumbers();
//            System.out.println(Arrays.toString(randomNum));
            boolean isGameOver = false;
            while (!isGameOver) {
                String userNumbers = player.getInput(numberSize);
                Result result = referee.judge(computer.getRandomNumbers(), userNumbers);

                System.out.println(result);

                if (result.isCorrect(numberSize)) {
                    System.out.println("정답입니다! 게임 종료.");
                    isGameOver = true;
                    playAgain = askReplay();  // 게임 다시 시작 여부 확인
                }
            }
        }

        System.out.println("게임을 종료합니다.");
    }

    private boolean askReplay() {
        while (true) {
            System.out.print("다시 플레이하시겠습니까? (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다. 'Y' 또는 'N'을 입력하세요.");
            }
        }
    }
}

