package software.ulpgc.kata3.architecture.control;
import software.ulpgc.kata3.architecture.io.BarchartLoader;
import software.ulpgc.kata3.architecture.view.BarchartDisplay;

import java.io.IOException;

public class ToggleStatisticCommand implements Command {
    private final BarchartDisplay display;
    private final BarchartLoader loader;
    private int i = 0;

    public ToggleStatisticCommand(BarchartLoader loader, BarchartDisplay display) {
        this.loader = loader;
        this.display = display;
    }

    @Override
    public void execute() throws IOException {
        display.show(loader.load(i++ % 2));
    }
}

