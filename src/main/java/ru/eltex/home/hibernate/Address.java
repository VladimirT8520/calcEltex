package ru.eltex.home.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "address")
public class Address {
   @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private String home;

    @OneToMany(mappedBy = "address",fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Collection<User> clients;
}
