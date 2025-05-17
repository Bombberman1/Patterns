package com.oleh.pavliuk.patterns.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    private UserAccount userAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workstation_id", referencedColumnName = "id")
    private Workstation workstation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mentor_id", referencedColumnName = "id")
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "hr_manager_id")
    @JsonBackReference
    private HRManager hrManager;

    @ManyToOne
    @JoinColumn(name = "it_administrator_id")
    @JsonBackReference
    private ITAdministrator itAdministrator;
}
