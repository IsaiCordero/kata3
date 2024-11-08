package software.ulpgc.kata3.architecture;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TitleDeserializer deserializer = new TsvTitleDeserializer();
        TitleReader file = new TsvFileTitleReader(new File("title.basics.tsv"), deserializer);
        List<Title> titles = file.load();
        HashMap<String, String> map = new HashMap<>();
        for (Title title : titles) {
            map.put(title.getOriginalTitle(), title.getGenres());
        }

        for (String key : map.keySet()) {
            System.out.println(key + "\t" + map.get(key));
        }
    }
}
