package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(List<String> carNames) {
        Objects.requireNonNull(carNames);
        List<RacingCar> racingCars = createRacingCars(carNames);
        return new RacingCars(racingCars);
    }

    private static List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(RacingCar.of(carName));
        }
        return racingCars;
    }
}
