package com.oleh.pavliuk.patterns.utility;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CSVCommandLine implements CommandLineRunner {
    private static final String CSV_FILE_PATH = "csv_data/employees.csv";
    private static final int CSV_FILE_ROWS = 1000;

    @Autowired private CSVImporter csvImporter;
    @Autowired private CSVGenerator csvGenerator;

    @Override
    public void run(String... args) {
        if (args.length != 1) {
            System.out.println("No Command Line args");
            return;
        }

        switch (args[0]) {
            case "generate_csv":
                csvGenerator.generateCSV(CSV_FILE_PATH, CSV_FILE_ROWS);
                System.out.println("CSV Generated");
                break;
            case "import_csv":
                csvImporter.importFromCSV(CSV_FILE_PATH);
                System.out.println("CSV Import Success");
                break;
            default:
                break;
        }
    }
}
