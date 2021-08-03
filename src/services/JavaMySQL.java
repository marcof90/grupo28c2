package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JavaMySQL {

    private Connection connect;
    private String url;
    private String user;
    private String password;

    public JavaMySQL() {
        super();
        getProperties();
        connectDB();
    }

    public void getProperties() {
        try {
            InputStream ins = new FileInputStream("./data/db.properties");
            Properties prop = new Properties();
            prop.load(ins);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection connectDB() {
        try {
            connect = DriverManager.getConnection(url, user, password);
            boolean isValid = connect.isValid(500);
            System.out.println(isValid ? "Connected" : "Failed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }

}
