package baseballgame2.util;

import java.util.Random;
import java.util.HashSet;

public class RandomNumberUtil {

    public int[] generateRandomNum() {
        Random random = new Random();

        HashSet<Integer> randomNumber = new HashSet<>();
        int randomNumSize = random.nextInt(5) + 1; // 1~5 자리 숫자 생성


        while (randomNumber.size() < randomNumSize) {
            randomNumber.add(random.nextInt(10)); // 0~9 사이의 숫자
        }


        return randomNumber.stream().mapToInt(Integer::intValue).toArray();
    }
}
