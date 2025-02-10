package baseballgame2.service;


public class CompareService {
    public int[] compareNumbers(int[] userNumbers, int[] randNumArray) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < randNumArray.length; i++) {
            for (int j = 0; j < randNumArray.length; j++) {
                if (userNumbers[i] == randNumArray[j]) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                }
            }

        }
        return new int[]{strikes, balls};
    }
}
