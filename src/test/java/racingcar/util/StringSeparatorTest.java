package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSeparatorTest {

    @Test
    @DisplayName("쉼표를 기준으로 문자열을 분리한다")
    void separate() {
        String[] separatedStrings = StringSeparator.separate("hello, world, java, car");
        assertThat(separatedStrings.length).isEqualTo(4);
    }

    @Test
    @DisplayName("분리된 문자열의 앞뒤 공백은 제거된다")
    void frontAndBackSpacesAreNotExist() {
        String[] separatedStrings = StringSeparator.separate("hello, world, java, car");
        assertThat(separatedStrings[0]).isEqualTo("hello");
        assertThat(separatedStrings[1]).isEqualTo("world");
        assertThat(separatedStrings[2]).isEqualTo("java");
        assertThat(separatedStrings[3]).isEqualTo("car");
    }
}
