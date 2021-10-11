package com.lib.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="STUDENT",schema="lib")
@Builder
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String cnp;

    @Column
    private String genre;

    @Column
    private String university;

    @Column
    private Integer numberOfLateReturnings;

    @Column
    private boolean isValidForRental;


}
