package racingcar.view;

import racingcar.car.RacingCars;
import racingcar.util.StringSeparator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarNameUserInputView {

    public Optional<RacingCars> inputCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] separatedCarNames = StringSeparator.separate(scanner.nextLine());
        List<String> carNames = toCollection(separatedCarNames);

        try {
            return Optional.of(RacingCars.of(carNames));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public List<String> toCollection(String[] separatedCarNames) {
        return Arrays.stream(separatedCarNames).collect(Collectors.toList());
    }
}
