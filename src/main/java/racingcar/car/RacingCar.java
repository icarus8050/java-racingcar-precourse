package racingcar.car;

import java.util.Objects;

class RacingCar {
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_DRIVE_CONDITION = 4;

    private final String carName;
    private final Distance distance;

    private RacingCar(String carName) {
        this.carName = carName;
        this.distance = new Distance();
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

    public void drive(int value) {
        if (value >= MIN_DRIVE_CONDITION) {
            this.distance.addUnit();
        }
    }

    public int getDistance() {
        return distance.getValue();
    }
}
