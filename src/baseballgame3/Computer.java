package baseballgame3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Computer {
    private int[] randomNumbers;

    public void generateRandomNum() {
        Random random = new Random();
        Set<Integer> numberSet = new HashSet<>();

        int randomNumSize = random.nextInt(5) + 1; // 1~5자리 숫자 생성

        while (numberSet.size() < randomNumSize) {
            int num = random.nextInt(10); // 0~9 사이의 숫자
            numberSet.add(num);
        }

        this.randomNumbers = numberSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getRandomNumbers() {
        return randomNumbers;
    }

    public int getRandomNumberSize() {
        return randomNumbers.length;
    }

}

