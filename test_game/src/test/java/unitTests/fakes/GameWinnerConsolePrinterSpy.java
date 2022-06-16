package unitTests.fakes;

import ru.otus.game.*;
import java.util.List;

public class GameWinnerConsolePrinterSpy implements GameWinnerPrinter {
    private final List<String> actualFlow;

    public GameWinnerConsolePrinterSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }
    @Override
    public void printWinner(Player winner) {
        actualFlow.add("Победитель: %s%n" + winner.getName());
    }
}
