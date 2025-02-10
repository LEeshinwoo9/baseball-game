package baseballgame1.service;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberService {

    public int[] generateRandomNum() {
        Random random = new Random();
        int randomNumSize = random.nextInt(5) + 1;

        int[] randomNum = new int[randomNumSize];
        Arrays.setAll(randomNum, i -> random.nextInt(10));

        return randomNum;
    }
}
