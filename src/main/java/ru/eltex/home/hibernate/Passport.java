package ru.eltex.home.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    @Setter
    private long id;

    @OneToOne(mappedBy = "passport")
    @Getter
    @Setter
    private User user;

    @Setter
    @Getter
    private String series;

    @Getter
    @Setter
    private String number;

}
