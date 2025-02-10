package baseballgame2.util;

import java.util.stream.Stream;

public class ParseUtil {

    public int[] getValidUserInput(String userInput) {
        return Stream.of(userInput.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
