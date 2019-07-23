package ru.eltex.home2;

import java.util.Scanner;
import ru.eltex.home2.Day;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите день недели - ");
        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.nextLine());
        if(day.ordinal()==0){
            System.out.println("Вы ввели субботу");
        }else if (day.ordinal()>=1){
            System.out.println("До субботы осталось "+day.ordinal()+" суток(и)");
        }
    }
}
