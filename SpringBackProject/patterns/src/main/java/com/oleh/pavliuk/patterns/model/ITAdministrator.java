package com.oleh.pavliuk.patterns.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "it_administrator")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ITAdministrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "itAdministrator", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Employee> employees;
}
