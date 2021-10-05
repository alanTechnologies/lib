package com.lib.system.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private Double price;
    private String title;
    private String author;
    private String genre;
    private String brand;
    private String language;
    private Integer year;
    private Boolean avaialable;
    private byte[] bookContent;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", title=" + title +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", brand='" + brand + '\'' +
                ", language='" + language + '\'' +
                ", year='" + year + '\'' +
                ", avaialable=" + avaialable +
                '}';
    }
}
