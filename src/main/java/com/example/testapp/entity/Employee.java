package com.example.testapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "employee")
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private Long employeeId;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender Gender;
    @Column(name = "dataOfBirth")
    private LocalDate dataOfBirth;
    @Column(name = "jobTitle")
    public String jobTitle;
    @JoinColumn(name = "departmentId")
    @ManyToOne
    private Department department;

    @Override
    public Long getId() {
        return null;
    }
}
