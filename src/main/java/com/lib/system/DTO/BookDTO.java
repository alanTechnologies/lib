package com.lib.system.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {

    private Long id;
    private Double price;
    private String title;
    private String author;
    private String genre;
    private String brand;
    private String language;
    private Integer year;
    private Boolean available;
    private String url;
    private Integer stock;




}
