package racingcar.util;

public class SequentialDriveValueGenerator implements DriveValueGenerator {

    private final int[] sequenceNumber;

    public SequentialDriveValueGenerator(int[] sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public int generate() {
        return 0;
    }
}
