package com.lib.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="student",schema="lib")
@Builder
@JsonIgnoreProperties
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
    @JsonManagedReference
    private List<RentBook> rentBook;


}
