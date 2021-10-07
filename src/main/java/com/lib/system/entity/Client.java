package com.lib.system.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CLIENT")
@Builder
public class Client {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String gender;



}
