package racingcar.car;

class Distance {
    public static final int DISTANCE_UNIT = 1;

    private int value;

    public Distance() {
        this.value = 0;
    }

    public void addUnit() {
        value += DISTANCE_UNIT;
    }

    public int getValue() {
        return value;
    }
}
