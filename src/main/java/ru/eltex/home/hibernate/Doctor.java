package ru.eltex.home.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(name = "id")
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String fio;
    @Getter
    @Setter
    private Integer cabinet;
    @Getter
    @Setter
    private String birthday;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String speciality;

    @ManyToMany(mappedBy = "doctor",fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Collection <User> user;
}
