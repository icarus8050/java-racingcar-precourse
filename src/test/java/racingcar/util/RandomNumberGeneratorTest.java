package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0이상 9이하의 랜덤 숫자 생성")
    void generateTest() {
        DriveValueGenerator driveValueGenerator = new RandomNumberGenerator();
        int generate = driveValueGenerator.generate();
        assertThat(generate).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
