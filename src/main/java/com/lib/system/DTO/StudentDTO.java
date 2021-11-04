package com.lib.system.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    private Long id;
    private String name;
    private Integer age;
    private String cnp;
    private String genre;
    private String university;
    private Integer numberOfLateReturnings;
    private boolean isValidForRental;
}
