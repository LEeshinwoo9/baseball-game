package baseballgame1.service;

import java.util.HashMap;
import java.util.Map;

public class CompareService {
    public int[] compareNumbers(int[] userNumbers, int[] randNumArray) {
        int strikes = 0;
        int balls = 0;
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < randNumArray.length; i++) {
            numMap.put(randNumArray[i], i);
        }

        for (int i = 0; i < userNumbers.length; i++) {
            if (numMap.containsKey(userNumbers[i])) {
                if (numMap.get(userNumbers[i]) == i) {
                    strikes++;
                } else {
                    balls++;
                }
            }
        }

        return new int[]{strikes, balls};
    }
}
