/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.giantrj.CariFile.handler.DB;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    private String databasePath = "jdbc:ucanaccess://./database/carifile.accdb;memory=true"; // Path ke database ODB

    @SuppressWarnings("CallToPrintStackTrace")
    public DBHandler(List<File> files) {
        String connectionString = databasePath;

        try (Connection connection = DriverManager.getConnection(connectionString)) {
           
            deleteTable();
            // Reset ID
            String resetID = """
                             CREATE TABLE daftarfile (
                                 id AUTOINCREMENT PRIMARY KEY,
                                 pathfile TEXT(255),
                                 namafile TEXT(255)
                             );""";
            try (Statement resetIDStatement = connection.createStatement()) {
                resetIDStatement.executeUpdate(resetID);
            }

            // Masukkan data baru ke dalam tabel Files
            String query = "INSERT INTO daftarfile (pathfile, namafile) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                for (File file : files) {
                    preparedStatement.setString(1, file.getParent());
                    preparedStatement.setString(2, file.getName());
                    preparedStatement.executeUpdate();
                }
            }
            
            // buat index supaya cepat pencarian
            try (Statement indexStatement = connection.createStatement()) {
                indexStatement.executeUpdate("CREATE INDEX idx_pathfile ON daftarfile (pathfile);");
                indexStatement.executeUpdate("CREATE INDEX idx_namafile ON daftarfile (namafile);");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public List<String> searchFiles(String searchText) {
        List<String> results = new ArrayList<>();
        String connectionString = databasePath;

        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String query = "SELECT pathfile, namafile FROM daftarfile WHERE namafile LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + searchText + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String path = resultSet.getString("pathfile");
                    String namafile = resultSet.getString("namafile");
                    results.add(path + File.separator + namafile);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    private void deleteTable(){
         // Hapus semua baris dari tabel Files
        String connectionString = databasePath;
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String deleteQuery = "DROP TABLE daftarfile";
            try (Statement deleteStatement = connection.createStatement()) {
                deleteStatement.executeUpdate(deleteQuery);
            }
        } catch (Exception ex) {
           // ex.printStackTrace();
            System.out.println("Tabel daftarfile tidak ditemukan");
            System.out.println("Buat Tabel daftarfile baru");
        }
    }
}

