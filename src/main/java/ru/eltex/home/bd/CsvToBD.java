package ru.eltex.home.bd;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CsvToBD {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Users";
    private static final String username = "root";
    private static final String password = "**********";
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE if NOT EXISTS Developer ("
            + "id INT(10)AUTO_INCREMENT PRIMARY KEY,"
            + "number INTEGER NOT NULL,"
            + "lastname TEXT NOT NULL,"
            + "phone INTEGER NOT NULL,"
            + "email TEXT NOT NULL,"
            + "language TEXT NOT NULL)";
    private static final String INSERT_PERSON_QUERY = "INSERT INTO Developer (number, lastname, phone, email, language) VALUES (?, ?, ?, ?, ?)";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL,username,password)){
            try (Statement statement = conn.createStatement()){
                statement.execute(CREATE_TABLE_QUERY);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
            try (CSVReader reader =new CSVReader(new FileReader("file.csv"));
                 PreparedStatement preparedStatement =conn.prepareStatement(INSERT_PERSON_QUERY)){
                String[] record;
                while ((record = reader.readNext()) != null){
                    preparedStatement.setInt(1,Integer.valueOf(record[0]));
                    preparedStatement.setString(2, record[1]);
                    preparedStatement.setInt(3,Integer.valueOf(record[2]));
                    preparedStatement.setString(4, record[3]);
                    preparedStatement.setString(5, record[4]);
                    preparedStatement.executeUpdate();
                }
            }
            catch(IOException exc) {
                exc.printStackTrace();
            }
            catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }

    }
}
