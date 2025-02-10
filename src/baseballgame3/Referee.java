package baseballgame3;

public class Referee {
    public Result judge(int[] computerNumbers, String userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < userNumbers.length(); i++) {
            int userDigit = Character.getNumericValue(userNumbers.charAt(i));

            for (int j = 0; j < computerNumbers.length; j++) {
                if (userDigit == computerNumbers[j]) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                    break;
                }
            }
        }

        return new Result(strikes, balls);
    }
}
