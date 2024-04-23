package org.odev12;
import java.sql.*;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.StatementException;

public class Main {
    public static void main(String[] args) {

        String server = "sql11.freemysqlhosting.net";
        String databaseName = "sql11678198";
        String username = "sql11678198";
        String password = "wVJ6TIBGWB";
        int portNumber = 3306;
        
        String url = "jdbc:mysql://" + server + ":" + portNumber + "/" + databaseName;
        Jdbi jdbi = Jdbi.create(url, username, password);
        try (Handle handle = jdbi.open()) {
            handle.execute("INSERT INTO ogrenciler (ad,soyad) VALUES (?,?)", "Meliha","İPEK");
            int deletedCount = handle.execute("DELETE FROM ogrenciler WHERE ogrenciID = ?", 1);
            System.out.println(deletedCount + " satır silindi.");
            handle.createQuery("SELECT * FROM ogrenciler")
                .mapToMap()
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
