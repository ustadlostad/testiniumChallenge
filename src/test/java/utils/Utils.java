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

        String data = "";

        CSVReader csvReader = new CSVReader(new FileReader("files/userData.csv"));

        List<String[]> val = csvReader.readAll();

        data = val.get(row)[column];

        return data;
    }
}

