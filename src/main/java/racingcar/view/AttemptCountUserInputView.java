package racingcar.view;

import java.util.Scanner;

public class AttemptCountUserInputView {

    public int inputAttemptCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        String stringBasedCount = scanner.nextLine();
        return parseToInteger(stringBasedCount);
    }

    private int parseToInteger(String stringBasedCount) {
        try {
            return Integer.parseInt(stringBasedCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력이 가능합니다.");
        }
    }
}
