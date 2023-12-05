// package db ini berfungsi untuk menghubungkan ke database
package db;

// Modul 9 (Pertemuan 10) - Studi Kasus

// import library untuk menghubungkan ke database
import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
    // method untuk menghubungkan ke database
    private final static String DB_URL = "jdbc:mysql://localhost:3306/pp2_biodata";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "";

    // instance dari class MySqlConnection
    private static MySqlConnection instance;

    // method untuk menghubungkan instance ke database
    public static MySqlConnection getInstance() {
        if (instance == null) {
            instance = new MySqlConnection();
        }
        return instance;
    }

    // method untuk menghubungkan ke database
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}