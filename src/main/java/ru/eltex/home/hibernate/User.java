package ru.eltex.home.hibernate;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="User")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Getter
  @Setter
  private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    @Getter
    @Setter
    private Passport passport;

    @Getter
    @Setter
    private String fio;

    @Getter
    @Setter
    private String sex;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String birthday;

    @Getter
    @Setter
    private String regday;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @Getter
    @Setter
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor_id")
    @Getter
    @Setter
    private Collection<Doctor> doctor;

}
