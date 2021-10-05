package com.lib.system.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {


    private long id;
    private String name;
    private int age;
    private String gender;
    private String university;
    private int numberOfLateReturnings;



}
