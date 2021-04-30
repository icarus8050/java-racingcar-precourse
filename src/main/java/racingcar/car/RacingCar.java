package racingcar.car;

import java.util.Objects;

public class RacingCar {
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;

    private final String carName;

    private RacingCar(String carName) {
        this.carName = carName;
    }

    public static RacingCar of(String carName) {
        Objects.requireNonNull(carName);
        validateCarNameLength(carName);
        return new RacingCar(carName);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() < MIN_NAME_LENGTH || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
