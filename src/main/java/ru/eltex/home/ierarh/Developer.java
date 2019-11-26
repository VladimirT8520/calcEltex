package ru.eltex.home.ierarh;

public class Developer extends User{
    private String[] language;

    public Developer(String fio, String phone, String email, Integer id, String[] language) {
//        super(fio, phone, email, id);
        this.language = language;
    }

    public Developer() {
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }
}
