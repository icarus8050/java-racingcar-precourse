package racingcar.view;

import racingcar.util.StringSeparator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarNameUserInputView {

    public List<String> inputCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] separatedCarNames = StringSeparator.separate(scanner.nextLine());
        return toCollection(separatedCarNames);
    }

    public List<String> toCollection(String[] separatedCarNames) {
        return Arrays.stream(separatedCarNames).collect(Collectors.toList());
    }
}
