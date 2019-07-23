package ru.eltex.home.ierarh;

import com.sun.tools.jdeprscan.CSV;

public abstract class User {
    private String fio;
    private String phone;
    private String email;
    private Integer id;

    public User(String fio, String phone, String email, Integer id) {
        this.email = email;
        this.fio = fio;
        this.phone = phone;
        this.id = id;
    }
    public User(){}

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
