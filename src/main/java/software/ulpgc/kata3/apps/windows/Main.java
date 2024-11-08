package software.ulpgc.kata3.apps.windows;


import software.ulpgc.kata3.architecture.io.MockBarchartLoader;
import software.ulpgc.kata3.architecture.control.ToggleStatisticCommand;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        MockBarchartLoader loader = new MockBarchartLoader();
        mainFrame.put("toggle", new ToggleStatisticCommand(loader, mainFrame.barchartDisplay()));
        mainFrame.barchartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }

}