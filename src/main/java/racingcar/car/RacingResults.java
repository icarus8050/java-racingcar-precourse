package racingcar.car;

import java.util.List;

public class RacingResults {
    public static final int FIRST_ARRAY_INDEX = 0;

    private final List<RacingCarInfo> racingCarInfos;
    private int index;

    public RacingResults(List<RacingCarInfo> racingCarInfos) {
        this.racingCarInfos = racingCarInfos;
        this.index = FIRST_ARRAY_INDEX;
    }

    public boolean hasNextResult() {
        return index > getRacingCarsLastIndex();
    }

    private int getRacingCarsLastIndex() {
        return racingCarInfos.size() - 1;
    }

    public RacingCarInfo nextResult() {
        return racingCarInfos.get(index++);
    }
}
