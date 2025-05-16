package com.oleh.pavliuk.patterns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleh.pavliuk.patterns.repository.*;
import com.oleh.pavliuk.patterns.utility.CSVGenerator;
import com.oleh.pavliuk.patterns.utility.CSVImporter;

@Service
public class CSVService {
    private static final String CSV_FILE_PATH = "csv_data/employees.csv";
    private static final int CSV_FILE_ROWS = 1000;

    @Autowired private CSVImporter csvImporter;
    @Autowired private CSVGenerator csvGenerator;

    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private UserAccountRepository userAccountRepository;
    @Autowired private WorkstationRepository workstationRepository;
    @Autowired private MentorRepository mentorRepository;
    @Autowired private HRManagerRepository hrManagerRepository;
    @Autowired private ITAdministratorRepository itAdministratorRepository;

    private void clearDatabase() {
        employeeRepository.deleteAll();
        userAccountRepository.deleteAll();
        workstationRepository.deleteAll();
        mentorRepository.deleteAll();
        hrManagerRepository.deleteAll();
        itAdministratorRepository.deleteAll();
    }

    public void generate_csv() {
        csvGenerator.generateCSV(CSV_FILE_PATH, CSV_FILE_ROWS);
    }

    public void import_csv() {
        clearDatabase();
        csvImporter.importFromCSV(CSV_FILE_PATH);
    }
}
