package com.oleh.pavliuk.patterns.utility;

import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

@Component
public class CSVGenerator {
    public void generateCSV(String filename, int count) {
        Faker faker = new Faker(Locale.ENGLISH);
        Random random = new Random();

        String[] hrManagerNames = {
            "Alice Johnson", "Bob Smith", "Carol Davis", "David Wilson", "Emma Thompson"
        };
        String[] itAdminNames = {
            "Frank Miller", "Grace Lee", "Henry White", "Irene Hall", "Jack Lewis"
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            writer.writeNext(new String[]{
                    "emp_name", "emp_position", "emp_start_date",
                    "account_username", "account_email", "account_password",
                    "workstation_location", "workstation_os",
                    "mentor_name", "mentor_department",
                    "hrmanager_name",
                    "itadmin_name"
            });

            for (int i = 0; i < count; i++) {
                // Employee
                String empName = faker.name().fullName();
                String empPosition = faker.job().position();
                String empStartDate = "";
                if (random.nextDouble() < 0.7) {
                    Date startDate = faker.date().past(1000, java.util.concurrent.TimeUnit.DAYS);
                    empStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
                }

                // UserAccount
                String userUsername = faker.name().username();
                String userEmail = faker.internet().emailAddress();
                String userTempPassword = faker.internet().password();

                // Workstation
                String workstationLocation = faker.address().city();
                String workstationOS = faker.options().option("Windows 10", "Windows 11", "Ubuntu", "Fedora", "MacOS");

                // Mentor
                String mentorName = "";
                String mentorDepartment = "";
                if (random.nextDouble() < 0.7) {
                    mentorName = faker.name().fullName();
                    mentorDepartment = faker.company().industry();
                }

                // HRManager
                String hrManagerName = hrManagerNames[random.nextInt(hrManagerNames.length)];

                // ITAdministrator
                String itAdminName = itAdminNames[random.nextInt(itAdminNames.length)];

                writer.writeNext(new String[]{
                        empName, empPosition, empStartDate,
                        userUsername, userEmail, userTempPassword,
                        workstationLocation, workstationOS,
                        mentorName, mentorDepartment,
                        hrManagerName,
                        itAdminName,
                });
            }

            System.out.println("CSV file generated: " + filename);
        } catch (IOException e) {
            System.err.println("CSV file error: " + e.getMessage());
        }
    }
}
