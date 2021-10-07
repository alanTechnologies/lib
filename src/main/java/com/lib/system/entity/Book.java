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
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "BOOK_CONTENT")
    private byte[] bookContent;

    @Column(name = "AVAILABLE")
    private Boolean available;
}
