package racingcar.car;

import racingcar.util.DriveValueGenerator;

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

    public RacingResults race(DriveValueGenerator numberGenerator) {
        drive(numberGenerator);
        return getRacingResults();
    }

    private void drive(DriveValueGenerator numberGenerator) {
        for (RacingCar racingCar : racingCars) {
            racingCar.drive(numberGenerator.generate());
        }
    }

    private RacingResults getRacingResults() {
        List<RacingCarInfo> racingCarInfos = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            racingCarInfos.add(new RacingCarInfo(racingCar.getCarName(), racingCar.getDistance()));
        }
        return new RacingResults(racingCarInfos);
    }
}
