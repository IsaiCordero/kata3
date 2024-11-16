package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.apps.windows.Title;
import software.ulpgc.kata3.architecture.model.Barchart;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MockBarchartLoader implements BarchartLoader {
    @Override
    public Barchart load(int id) throws IOException {
        TitleDeserializer deserializer = new TsvTitleDeserializer();
        TitleReader file = new TsvFileTitleReader(new File("title.basics.tsv"), deserializer);
        List<Title> titles = file.read();
        return switch (id){
            case 0 -> barchart0(titles);
            case 1 -> barchart1(titles);
            default -> null;
        };
    }
    private Barchart barchart0(List<Title> titles){
        Barchart barchart = new Barchart("Year the movies came out", "Years", "Amount");
        int year90to00 = 0;
        int year00to10 = 0;
        int year10to20 = 0;
        for (Title title : titles){
            int year = title.getStartYear();
            if(year >= 1890 && year < 1900) year90to00++;
            barchart.put("1890-1900", year90to00);
            if(year >= 1900 && year < 1910) year00to10++;
            barchart.put("1900-1910", year00to10);
            if(year >= 1910 && year < 1920) year10to20++;
            barchart.put("1910-1920", year10to20);
        }
        return barchart;
    }

    private Barchart barchart1(List<Title> titles){
        Barchart barchart = new Barchart("Type of the movies", "Type", "Amount");
        int typeShort = 0;
        int typeMovie = 0;
        for (Title title : titles){
            String type = title.getType();
            if(type.equals("short")) typeShort++;
            barchart.put("Shorts", typeShort);
            if(type.equals("movie")) typeMovie++;
            barchart.put("Movies", typeMovie);
        }
        return barchart;
    }

}
