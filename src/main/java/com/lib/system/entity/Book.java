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
@Builder
@Entity
@Table(name = "BOOK", schema = "lib")
public class Book {

    @Id
    @Column
    private Long id;

    @Column
    private Double price;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String genre;

    @Column
    private String brand;

    @Column
    private String language;

    @Column
    private Integer year;

    @Column
    private byte[] bookContent;

    @Column
    private Boolean available;

    @Column
    private String url;
}
