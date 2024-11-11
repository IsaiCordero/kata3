package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Barchart;
import software.ulpgc.kata3.apps.windows.Title;

import java.io.IOException;
import java.io.File;
import java.util.List;

public class MockBarchartLoader implements BarchartLoader {



    @Override
    public Barchart load(int id) throws IOException {
        TitleDeserializer deserializer = new TsvTitleDeserializer();
        TitleReader file = new TsvFileTitleReader(new File("title.basics.tsv"), deserializer);
        List<Title> titles = file.read();
        return switch (id) {
            case 0 -> barchart0(titles);
            case 1 -> barchart1(titles);
            default -> null;
        };

    }

    private Barchart barchart0(List<Title> titles){

        Barchart barchart = new Barchart("Year the movies came out", "Years", "Movies");
        int year90To00 = 0;
        int year00To10 = 0;
        int year10To20 = 0;
        for (Title title : titles) {
            int year = title.getStartYear();

            if (year >= 1890 && year < 1900) year90To00++;
            barchart.put("1890-1900", year90To00);

            if (year >= 1900 && year < 1910) year00To10++;
            barchart.put("1900-1910", year00To10);

            if (year >= 1910 && year < 1920) year10To20++;
            barchart.put("1910-1920", year10To20);

        }
        return barchart;
    }

    private Barchart barchart1(List<Title> titles) {
        Barchart barchart = new Barchart("Type of the movies", "Type", "Amount");
        int typeShort = 0;
        int typeMovie = 0;
        for (Title title : titles) {
            String Type = title.getType();
            if(Type.equals("short")) typeShort++;
            barchart.put("shorts", typeShort);
            if(Type.equals("movie")) typeMovie++;
            barchart.put("movies", typeMovie);
        }
        return barchart;
    }
}

