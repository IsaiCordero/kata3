package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.apps.windows.Title;

import java.io.IOException;
import java.util.List;

public interface
TitleReader {
    List<Title> read() throws IOException;
}