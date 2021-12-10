package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Utils {

    public String readCsv(int row, int column) throws IOException, CsvException {

        CSVReader csvReader = new CSVReader(new FileReader("files/userData.csv"));

        List<String[]> val = csvReader.readAll();

        String data = val.get(row)[column];

        return data;
    }

    public void writeTxt(String text) throws IOException {
        FileWriter writer = new FileWriter("files/itemData.txt",true);
        writer.write(text + "\n");
        writer.close();
    }
}

