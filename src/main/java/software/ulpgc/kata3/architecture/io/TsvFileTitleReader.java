package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.apps.windows.Title;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvFileTitleReader implements TitleReader {
    private final File file;
    private final TitleDeserializer deserializer;

    public TsvFileTitleReader(File file, TitleDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Title> read() {
        try {
            return read(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Title> read(FileReader fileReader) throws IOException {
        return read(new BufferedReader(fileReader));
    }

    private List<Title> read(BufferedReader reader) throws IOException {
        reader.readLine();
        List<Title> titles = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            titles.add(deserializer.deserialize(line));
        }
        return titles;
    }
}
