package ru.eltex.home.ierarh;

import java.io.IOException;
import java.io.PrintWriter;

public class Developer extends User implements CSV{
    private String language;


    public Developer(String fio, String phone, String email, String id, String language) {
        super(fio, phone, email, id);
        this.language = language;
    }

    public Developer() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String toCSV() throws IOException {
        PrintWriter printWriter = new PrintWriter("file.csv");
        printWriter.println(this.getId()+"; "+this.getFio() + "; " + this.getPhone() + "; " + this.getEmail() + "; " + this.getLanguage());
        printWriter.close();
        return null;
    }
}
