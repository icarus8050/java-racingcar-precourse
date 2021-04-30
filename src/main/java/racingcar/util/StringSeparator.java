package racingcar.util;

public class StringSeparator {
    public static String[] separate(String commaSeparatedString) {
        String[] separatedString = commaSeparatedString.split(",");
        removeSpace(separatedString);
        return separatedString;
    }

    private static void removeSpace(String[] split) {
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
    }
}
