package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.control.ToggleStatisticCommand;
import software.ulpgc.kata3.architecture.io.MockBarchartLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainFrame frame = new MainFrame();
        MockBarchartLoader loader = new MockBarchartLoader();
        frame.put("toggle", new ToggleStatisticCommand(frame.barchartDisplay(), loader));
        frame.barchartDisplay().show(loader.load(0));
        frame.setVisible(true);
    }
}