package ru.nsk.eltex.home;

import java.math.BigInteger;

public class Bigint {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("2");
        a = a.pow(1000);
        System.out.println("2^1000 = " + a);
    }
}
