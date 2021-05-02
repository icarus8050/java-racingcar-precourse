package racingcar.car;

import java.util.List;

public class RacingResult {

    private final List<RacingCarInfo> racingCarInfos;

    public RacingResult(List<RacingCarInfo> racingCarInfos) {
        this.racingCarInfos = racingCarInfos;
    }

    public List<RacingCarInfo> getRacingCarInfos() {
        return racingCarInfos;
    }

    public WinningCars electWinningCars() {
        int maxDistance = findMaxDistance();
        return findWinningCarsByMaxDistance(maxDistance);
    }

    private int findMaxDistance() {
        int max = 0;
        for (RacingCarInfo racingCarInfo : racingCarInfos) {
            max = Math.max(max, racingCarInfo.getDistance());
        }
        return max;
    }

    private WinningCars findWinningCarsByMaxDistance(int maxDistance) {
        WinningCars winningCars = new WinningCars(maxDistance);
        for (RacingCarInfo racingCarInfo : racingCarInfos) {
            winningCars.addWinningCarInfoIfMaxDistance(racingCarInfo);
        }
        return winningCars;
    }
}
