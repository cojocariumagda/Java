package lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingletonDatabase {
    private static SingletonDatabase single_instance = null;
    public Connection conn;
    private SingletonDatabase() throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/MusicAlbums";
        Properties props = new Properties();
        props.setProperty("user", "dba");
        props.setProperty("password", "sql");
        conn = DriverManager.getConnection(url, props);
    }

    public static SingletonDatabase getInstance()
    {
        if (single_instance == null)
        {
            try {
                single_instance = new SingletonDatabase();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return single_instance;
    }

    public void closeConnection() throws SQLException {
            conn.close();
    }
}
