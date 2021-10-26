package com.lib.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book", schema = "lib")
@JsonIgnoreProperties
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] bookContent;

    @Column
    private Boolean available;

    @Column
    private String url;

    @Column
    private Integer stock;

}
