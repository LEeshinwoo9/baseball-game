import java.util.*;

public class BaseballGame {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                playGame(scanner);

                if (!askRetry(scanner)) {
                    break;
                }
            }
            scanner.close();
        }

        // 게임 실행 메서드
        public static void playGame(Scanner scanner) {
            int[] randomNumbers = generateRandomNumbers();
            int numSize = randomNumbers.length;

            System.out.println("\n🎯 숫자 야구 게임을 시작합니다!");

            while (true) {
                String userInput = getUserInput(scanner, numSize);
                int[] userNumbers = convertInputToArray(userInput);
                int[] result = calculateResult(randomNumbers, userNumbers);

                printResult(result[0], result[1]);

                if (result[0] == numSize) {
                    System.out.println("🎉 " + numSize + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
        }

        // 랜덤 숫자 생성 메서드
        public static int[] generateRandomNumbers() {
            Random random = new Random();
            int numSize = random.nextInt(5) + 1;
            int[] numbers = new int[numSize];

            for (int i = 0; i < numSize; i++) {
                numbers[i] = random.nextInt(10);
            }
            return numbers;
        }

        // 사용자 입력 받기 (예외 처리 포함)
        public static String getUserInput(Scanner scanner, int size) {
            while (true) {
                System.out.print(size + "자리 숫자를 입력하세요: ");
                String input = scanner.nextLine().trim(); // 공백 제거

                if (!input.matches("\\d+")) {
                    System.out.println("⚠️ 숫자만 입력하세요!");
                    continue;
                }
                if (input.length() != size) {
                    System.out.println("⚠️ " + size + "자리 숫자를 입력하세요!");
                    continue;
                }
                return input;
            }
        }

        // 문자열 숫자를 int 배열로 변환
        public static int[] convertInputToArray(String input) {
            return input.chars().map(c -> c - '0').toArray();
        }

        // 스트라이크 & 볼 판정 (Depth 최적화)
        public static int[] calculateResult(int[] randomNumbers, int[] userNumbers) {
            int strikes = 0, balls = 0;
            Map<Integer, Integer> numMap = new HashMap<>();

            for (int i = 0; i < randomNumbers.length; i++) {
                numMap.put(randomNumbers[i], i);  // 숫자와 인덱스를 매핑
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

        // 결과 출력
        public static void printResult(int strikes, int balls) {
            if (strikes == 0 && balls == 0) {
                System.out.println("⚾ 낫싱");
            } else {
                System.out.println("🎯 결과: " + strikes + " 스트라이크, " + balls + " 볼");
            }
        }

        // 게임 재시작 여부 확인
        public static boolean askRetry(Scanner scanner) {
            while (true) {
                System.out.print("게임을 다시 하시겠습니까? (Y/N): ");
                String retry = scanner.nextLine().trim().toUpperCase();

                if (retry.equals("Y")) return true;
                if (retry.equals("N")) return false;

                System.out.println("⚠️ Y 또는 N을 입력하세요!");
            }
        }
    }





