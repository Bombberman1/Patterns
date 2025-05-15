package com.oleh.pavliuk.patterns.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    // @OneToOne(cascade = CascadeType.ALL)
    // private UserAccount userAccount;

    // @OneToOne(cascade = CascadeType.ALL)
    // private Workstation workstation;

    // @ManyToOne
    // private Mentor mentor;
}
