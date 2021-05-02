package racingcar.util;

public class SequentialDriveValueGenerator implements DriveValueGenerator {

    private final int[] sequenceNumber;
    private int index;

    public SequentialDriveValueGenerator(int[] sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
        this.index = 0;
    }

    @Override
    public int generate() {
        int generatedNumber = sequenceNumber[index++];
        index %= sequenceNumber.length;
        return generatedNumber;
    }
}
