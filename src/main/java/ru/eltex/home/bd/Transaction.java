package ru.eltex.home.bd;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Transaction {
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE if NOT EXISTS Developer ("
            + "id INT(10)AUTO_INCREMENT PRIMARY KEY,"
            + "number INTEGER NOT NULL,"
            + "lastname TEXT NOT NULL,"
            + "phone INTEGER NOT NULL,"
            + "email TEXT NOT NULL,"
            + "language TEXT NOT NULL)";
    private static final String INSERT_PERSON_QUERY = "INSERT INTO Developer (number, lastname, phone, email, language) VALUES (10, Smith, 13131316, qwerty@mail.ru, english)";

    public static void main(String[] args) {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream("src/main/resources/db.properties");
            properties.load(fileInputStream);
            String DB_URL = properties.getProperty("db.URL");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

        try (Connection conn = DriverManager.getConnection(DB_URL, username, password)) {
            try (Statement statement = conn.createStatement()) {
                statement.execute(CREATE_TABLE_QUERY);
            }
           conn.setAutoCommit(false);
            long start = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT Developer(number, lastname, phone, email, language) VALUES (10, 'petr', 13131316, 'qwerty', 'english')");

            }
            long end = System.nanoTime();
            Statement statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM Developer WHERE number >='0'");
            Double res = (end - start) * 1e-9;

            conn.setAutoCommit(true);
            long start1 = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                Statement statement2 = conn.createStatement();
                statement2.executeUpdate("INSERT Developer(number, lastname, phone, email, language) VALUES (10, 'petr', 13131316, 'qwerty', 'english')");
            }
            long end1 = System.nanoTime();
            Double res2 = (end1 - start1) * 1e-9;
            System.out.println(res);
            System.out.println(res2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        } catch (IOException e) {
            System.err.println("Файл отсутствует!");
        }
    }
}
