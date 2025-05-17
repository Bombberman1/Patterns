package com.oleh.pavliuk.patterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.oleh.pavliuk.patterns.model.Employee;
import com.oleh.pavliuk.patterns.service.EmployeeService;
import com.oleh.pavliuk.patterns.service.HRManagerService;
import com.oleh.pavliuk.patterns.service.ITAdministratorService;
import com.oleh.pavliuk.patterns.service.MentorService;
import com.oleh.pavliuk.patterns.service.UserAccountService;
import com.oleh.pavliuk.patterns.service.WorkstationService;

import lombok.*;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired private EmployeeService employeeService;
    @Autowired private HRManagerService hrManagerService;
    @Autowired private ITAdministratorService itAdministratorService;
    @Autowired private MentorService mentorService;
    @Autowired private UserAccountService userAccountService;
    @Autowired private WorkstationService workstationService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "index";
    }

    @GetMapping("/api/employee/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        addRelatedEntities(model);
        return "action-page";
    }

    @GetMapping("/api/employee/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        addRelatedEntities(model);
        return "action-page";
    }

    @PostMapping("/api/employee/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        if (employee.getUserAccount() != null && employee.getUserAccount().getId() != null) {
            var existing = userAccountService.getById(employee.getUserAccount().getId());
            existing.setUsername(employee.getUserAccount().getUsername());
            existing.setEmail(employee.getUserAccount().getEmail());
            existing.setTemporaryPassword(employee.getUserAccount().getTemporaryPassword());
            employee.setUserAccount(existing);
        }

        if (employee.getWorkstation() != null && employee.getWorkstation().getId() != null) {
            var existing = workstationService.getById(employee.getWorkstation().getId());
            existing.setLocation(employee.getWorkstation().getLocation());
            existing.setOperatingSystem(employee.getWorkstation().getOperatingSystem());
            employee.setWorkstation(existing);
        }

        if (employee.getMentor() != null && employee.getMentor().getId() != null) {
            var existing = mentorService.getById(employee.getMentor().getId());
            existing.setName(employee.getMentor().getName());
            existing.setDepartment(employee.getMentor().getDepartment());
            employee.setMentor(existing);
        }

        employeeService.create(employee);
        return "redirect:/";
    }

    @GetMapping("/api/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/";
    }

    private void addRelatedEntities(Model model) {
        model.addAttribute("hrManagers", hrManagerService.getAll());
        model.addAttribute("itAdministrators", itAdministratorService.getAll());
        model.addAttribute("mentors", mentorService.getAll());
        model.addAttribute("userAccounts", userAccountService.getAll());
        model.addAttribute("workstations", workstationService.getAll());
    }
}
