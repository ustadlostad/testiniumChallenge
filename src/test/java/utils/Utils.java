package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils {

    public String readCsv(int row, int column) throws IOException, CsvException {

        CSVReader csvReader = new CSVReader(new FileReader("files/userData.csv"));

        List<String[]> val = csvReader.readAll();

        return val.get(row)[column];
    }

    public void writeTxt(String text) throws IOException {
        FileWriter writer = new FileWriter("files/itemData.txt", true);
        writer.write(text + "\n");
        writer.close();
    }
}

