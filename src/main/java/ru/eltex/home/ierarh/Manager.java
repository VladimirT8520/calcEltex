package ru.eltex.home.ierarh;
import java.io.IOException;
import java.io.PrintWriter;

public class Manager extends User{
    private String[] sales;
    private String type;
    public Manager(String fio,String phone,String email,String id, String[] sales){
        super(fio, phone, email, id);
        this.sales = sales;
    }
    public Manager(){
    }

    public String[] getSales() {
        return sales;
    }

    public void setSales(String[] sales) {
        this.sales = sales;
    }

    public String toCSV() throws IOException {
        PrintWriter printWriter = new PrintWriter("file.csv");
        printWriter.println(this.getId()+"; "+this.getFio() + "; " + this.getPhone() + "; " + this.getEmail() + "; " + this.getSales());
        printWriter.close();
        return null;
    }
}
