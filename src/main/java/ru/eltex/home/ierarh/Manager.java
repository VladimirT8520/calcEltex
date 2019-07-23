package ru.eltex.home.ierarh;

public class Manager extends User{
    private String[] sales;
    private String type;
    public Manager(String fio,String phone,String email,Integer id, String[] sales){
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
}
