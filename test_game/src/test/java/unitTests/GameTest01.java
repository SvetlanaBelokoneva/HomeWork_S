package unitTests;

import unitTests.fakes.*;
import ru.otus.game.*;
import java.util.List;
import java.util.ArrayList;
import static java.lang.System.out;

public class GameTest01 {
    public void equalsFlows(List<String> unExpectedFlow, List<String> actualFlow){
        if (unExpectedFlow.size() == actualFlow.size()) {
            for (int i = 0; i < unExpectedFlow.size(); i++) {
                if (unExpectedFlow.equals(actualFlow)) {
                    throw new AssertionError(String.format("Победителем не может быть ни оди из участников, ибо ничья \"%s\" = \"%s\"",
                                                           unExpectedFlow,
                                                           actualFlow));
                }
            }
        }
    }
    public void testGameDeadHeat() {
        String scenario = "Тест на ничью";

        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");
        List<String> winPlayer1Flow = List.of("Победитель: %s%n" + player1.getName());
        List<String> winPlayer2Flow = List.of("Победитель: %s%n" + player2.getName());
        List<String> actualFlow = new ArrayList<>();

        try {
            Dice diceSpy = new DiceSpy();
            GameWinnerConsolePrinterSpy win = new GameWinnerConsolePrinterSpy(actualFlow);
            Game game = new Game(diceSpy, win);
            game.playGame(player1, player2);

            equalsFlows(winPlayer1Flow, actualFlow);

            equalsFlows(winPlayer2Flow, actualFlow);

            out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
