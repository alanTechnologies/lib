package com.lib.system.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="RENTBOOK", schema = "lib")
public class RentBook {

    @Id
    @Column
    private Long id;

    @OneToOne
    private Book book;

    @Column
    private LocalDate startDay;

    @Column
    private LocalDate endDay;





}
