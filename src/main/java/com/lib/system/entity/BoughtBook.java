package com.lib.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="boughtbook", schema = "lib")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoughtBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="book_id")
    private Book book;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate maxReturnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    @JsonBackReference
    private Client  client;

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", startDate=" + startDate +
                        ", maxReturnDate=" + maxReturnDate;
    }
}
