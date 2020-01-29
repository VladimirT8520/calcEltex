package ru.eltex.home.ierarh;
import java.io.*;

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
        /*PrintWriter printWriter = new PrintWriter("file.csv",);
        printWriter.println(this.getId()+","+this.getFio() + "," + this.getPhone() + "," + this.getEmail() + "," + this.getLanguage());
        printWriter.close();
        return null;*/
        OutputStream outputStream = new FileOutputStream("file.csv", true);
        Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
        PrintWriter printWriter = new PrintWriter(writer, true);
        printWriter.println(this.getId()+","+this.getFio() + "," + this.getPhone() + "," + this.getEmail() + "," + this.getLanguage());
        printWriter.close();
        return null;
    }
}
