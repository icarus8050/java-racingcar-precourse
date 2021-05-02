package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class RacingResults {

    private final List<RacingCarInfo> racingCarInfos;

    public RacingResults(List<RacingCarInfo> racingCarInfos) {
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

    public static class WinningCars {
        private final int maxDistance;
        private final List<RacingCarInfo> winningCars;

        public WinningCars(int maxDistance) {
            this.maxDistance = maxDistance;
            this.winningCars = new ArrayList<>();
        }

        private void addWinningCarInfoIfMaxDistance(RacingCarInfo racingCarInfo) {
            if (racingCarInfo.getDistance() == maxDistance) {
                winningCars.add(racingCarInfo);
            }
        }

        public List<RacingCarInfo> getWinningCars() {
            return winningCars;
        }
    }
}
