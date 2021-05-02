package racingcar;

import racingcar.util.DriveValueGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.AttemptCountUserInputView;
import racingcar.view.CarNameUserInputView;
import racingcar.view.RacingResultsOutputView;
import racingcar.view.WinningCarsOutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RacingGame racingGame = initGame(scanner);
        racingGame.start();
        scanner.close();
    }

    private static RacingGame initGame(Scanner scanner) {
        CarNameUserInputView carNameUserInputView = new CarNameUserInputView();
        AttemptCountUserInputView attemptCountUserInputView = new AttemptCountUserInputView();
        DriveValueGenerator driveValueGenerator = new RandomNumberGenerator();
        RacingResultsOutputView racingResultsOutputView = new RacingResultsOutputView();
        WinningCarsOutputView winningCarsOutputView = new WinningCarsOutputView();

        return new RacingGame(
                scanner,
                carNameUserInputView,
                attemptCountUserInputView,
                driveValueGenerator,
                racingResultsOutputView,
                winningCarsOutputView
        );
    }
}
