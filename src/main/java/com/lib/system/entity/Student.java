package com.lib.system.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="student",schema="lib")
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<RentBook> rentBook;


}
