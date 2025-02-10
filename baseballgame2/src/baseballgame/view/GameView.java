package baseballgame.view;

public class GameView {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다!");
    }

    public void askForInput(int randNumSize) {
        System.out.print(randNumSize + "자리 숫자를 입력하세요: ");
    }

    public void showResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println("결과: " + strikes + " 스트라이크, " + balls + " 볼");
        }
    }

    public void showWinMessage(int randNumSize) {
        System.out.println(randNumSize + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void askRetry() {
        System.out.print("게임을 다시 하시겠습니까? (Y/N): ");
    }

    public void showInvalidRetryMessage() {
        System.out.println("Y 또는 N을 입력하세요.");
    }
}
