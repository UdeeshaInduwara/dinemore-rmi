package lk.ijse.gdse.dinemore.db;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static  DBConnection dbConnection;
    private Connection connection;

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException, IOException {
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }

    private DBConnection() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");

//        File file=new File("application.properties");
//        FileReader fileReader=new FileReader(file);
//        Properties properties=new Properties();
//        properties.load(fileReader);
//
//        String ip = properties.getProperty("ip");
//        String port = properties.getProperty("port");
//        String db = properties.getProperty("db");
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");

        String ip="localhost";
        String port="3306";
        String db="dinemore";
        String user="root";
        String password="1234";

        String url = "jdbc:mysql://" + ip + ":" + port + "/" + db;

        connection=DriverManager.getConnection(url,user,password);
    }
}

