package com.oleh.pavliuk.patterns.utility;

import com.oleh.pavliuk.patterns.model.*;
import com.oleh.pavliuk.patterns.service.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CSVImporter {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired private EmployeeService employeeService;
    @Autowired private HRManagerService hrManagerService;
    @Autowired private ITAdministratorService itAdministratorService;

    private final Map<String, HRManager> hrManagerCache = new HashMap<>();
    private final Map<String, ITAdministrator> itAdminCache = new HashMap<>();

    public void importFromCSV(String path) {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String empName = line[0];
                String empPosition = line[1];
                Date empStartDate = null;
                if (!line[2].isBlank()) {
                    empStartDate = DATE_FORMAT.parse(line[2]);
                }

                String username = line[3];
                String email = line[4];
                String password = line[5];

                String location = line[6];
                String os = line[7];

                String mentorName = line[8];
                String mentorDept = line[9];

                String hrManagerName = line[10];
                String itAdminName = line[11];

                UserAccount account = UserAccount.builder()
                        .username(username)
                        .email(email)
                        .temporaryPassword(password)
                        .build();

                Workstation workstation = Workstation.builder()
                        .location(location)
                        .operatingSystem(os)
                        .build();

                Mentor mentor = null;
                if (!mentorName.trim().isEmpty() && !mentorDept.trim().isEmpty()) {
                    mentor = Mentor.builder()
                        .name(mentorName)
                        .department(mentorDept)
                        .build();
                }

                HRManager hrManager = hrManagerCache.get(hrManagerName);
                if (hrManager == null) {
                    hrManager = hrManagerService.findByName(hrManagerName).orElse(null);
                    if (hrManager == null) {
                        hrManager = HRManager.builder().name(hrManagerName).build();
                        hrManager = hrManagerService.create(hrManager);
                    }
                    hrManagerCache.put(hrManagerName, hrManager);
                }

                ITAdministrator itAdmin = itAdminCache.get(itAdminName);
                if (itAdmin == null) {
                    itAdmin = itAdministratorService.findByName(itAdminName).orElse(null);
                    if (itAdmin == null) {
                        itAdmin = ITAdministrator.builder().name(itAdminName).build();
                        itAdmin = itAdministratorService.create(itAdmin);
                    }
                    itAdminCache.put(itAdminName, itAdmin);
                }

                Employee employee = Employee.builder()
                        .name(empName)
                        .position(empPosition)
                        .startDate(empStartDate)
                        .userAccount(account)
                        .workstation(workstation)
                        .mentor(mentor)
                        .hrManager(hrManager)
                        .itAdministrator(itAdmin)
                        .build();

                employeeService.create(employee);
            }
            System.out.println("CSV import completed");
        } catch (IOException | CsvValidationException | ParseException e) {
            e.printStackTrace();
            System.err.println("Error reading CSV: " + e.getMessage());
        }
    }
}
