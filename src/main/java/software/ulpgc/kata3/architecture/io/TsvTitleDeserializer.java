package software.ulpgc.kata3.architecture.io;


import software.ulpgc.kata3.apps.windows.Title;

public class TsvTitleDeserializer implements TitleDeserializer {

    @Override
    public Title deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    private Title deserialize(String[] split) {
        return new Title(split[0],split[1],split[2],split[3],toBoolean(split[4]), toInt(split[5]),toInt(split[6]), toInt(split[7]),split[8]);
    }

    private boolean toBoolean(String line) {
        if (line.equals("1")) return true;
        return false;
    }

    private int toInt(String line) {

        if (line != null && !line.equals("\\N")) return Integer.parseInt(line);
        return 0;
    }

}
