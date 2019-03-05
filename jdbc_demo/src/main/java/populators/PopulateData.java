package populators;

import static java.lang.Math.random;

import converters.Convert;

public class PopulateData {
    public void moreData(String file, int rowsToGenerate) {
        Convert value = new Convert();
        Csv.Writer writer = new Csv.Writer(file).delimiter(',');
        for (int i = 0; i < rowsToGenerate; i++) {
            writer
                    .value(value.toString((int) (random() * 999)))
                    .value(value.toString(999 + (int) (random() * 9999)))
                    .value(value.toString((int) (random() * 10)))
                    .value(value.toString((int) (random() * 999)))
                    .value(value.toString(random() * 999))
                    .value(value.toString(random() * 10))
                    .value("1")
                    .value("2008-06-01 00:00:00.000")
                    .newLine();
        }
        writer.close();
    }
}
