package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class WinningCars {
    private final int maxDistance;
    private final List<RacingCarInfo> racingCarInfos;

    public WinningCars(int maxDistance) {
        this.maxDistance = maxDistance;
        this.racingCarInfos = new ArrayList<>();
    }

    void addWinningCarInfoIfMaxDistance(RacingCarInfo racingCarInfo) {
        if (racingCarInfo.getDistance() == maxDistance) {
            racingCarInfos.add(racingCarInfo);
        }
    }

    public List<RacingCarInfo> getRacingCarInfos() {
        return racingCarInfos;
    }
}
