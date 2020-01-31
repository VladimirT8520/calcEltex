package ru.eltex.home.ierarh;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
@Getter
@Setter
abstract class User implements CSV {
    private String fio;
    private String phone;
    private String email;
    private String id;

    public User(String fio, String phone, String email, String id) {
        this.email = email;
        this.fio = fio;
        this.phone = phone;
        this.id = id;
    }
    public User(){}

    public String toCSV() throws IOException {
        return this.email+"; "+this.fio+"; "+this.email +"; "+this.phone;
    }

    public void fromCSV (String str){
        String []arr = str.split("; ");
        setId(arr[0]);
        setFio(arr[1]);
        setEmail(arr[2]);
        setPhone(arr[3]);
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i <100 ; i++) {
            Developer developer = new Developer("Petrov"+i, "89529"+i, "petrov"+i+"@mail.ru", "15"+i, "java");
            developer.toCSV();
        }
    }
}
