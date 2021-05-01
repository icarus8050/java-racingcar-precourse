package racingcar.car;

public class RacingCarInfo {
    private final String carName;
    private final int distance;

    public RacingCarInfo(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
