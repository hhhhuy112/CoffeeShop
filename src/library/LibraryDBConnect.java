package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class LibraryDBConnect {
  private Connection conn = null;

    public Connection getConnectMySQL() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Properties prop = new Properties();
        File file = new File("conf.Properties");
        FileInputStream file1 = new FileInputStream(file);
        prop.load(file1);
        String username = prop.getProperty("username");
        String db = prop.getProperty("db");
        String host = prop.getProperty("host");
        String port = prop.getProperty("port");
        String pass = prop.getProperty("pass");
                        String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useUnicode=true&characterEncoding=UTF-8";

        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, pass);
        return conn;
    }

    public void closeDb() throws SQLException {
        conn.close();
    }
}
