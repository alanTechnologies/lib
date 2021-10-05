package com.lib.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private String university;
    private Integer numberOfLateReturnings;

}
