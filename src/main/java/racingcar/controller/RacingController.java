package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Racing;
import racingcar.util.CarUtil;
import racingcar.view.ConsoleView;

public class RacingController {

    public void play() {

        ConsoleView.inputCarNames();
        String carNames = inputCarNames();

        ConsoleView.inputRound();
        String round = inputRound();

        Racing racing = new Racing(carNames, round);

        ConsoleView.printResultInfo();

        for (int i = 0; i < racing.getRound(); i++) {
            ConsoleView.printRoundResult(racing.move());
        }

        ConsoleView.printWinner(racing.getWinner());
    }

    public String inputCarNames() {
        String carNames = "";

        while (true) {
            carNames = Console.readLine();
            try {
                CarUtil.validateCarNames(carNames);
            } catch (IllegalArgumentException e) {
                carNames = "";
                ConsoleView.printError(e.getMessage());
            }

            if (!"".equals(carNames)) {
                break;
            }
        }

        return carNames;
    }

    public String inputRound() {
        String round = "";

        while (true) {
            round = Console.readLine();
            try {
                CarUtil.validateRound(round);
            } catch (IllegalArgumentException e) {
                ConsoleView.printError(e.getMessage());
                round = "";
            }

            if (!"".equals(round)) {
                break;
            }
        }

        return round;
    }

}
