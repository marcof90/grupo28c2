package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import model.Transaction;
import model.Wallet;


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

    public Connection getConnect() {
        return connect;
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
            e.printStackTrace();
        } catch (IOException e) {
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

    public void insertUser(String nombre) {
        String sql = "INSERT INTO `users`(`name`, `user_status`) VALUES ('"+nombre+"',1)";
        excuteInsertStatement(sql);
        insertWallet();
    }

    public void insertWallet() {
        String sql = "INSERT INTO `wallets`(`user_id`) SELECT MAX(id) FROM users";
        excuteInsertStatement(sql);
    }

    public void insertTransaction(Wallet wallet) {
        Transaction t = wallet.getTransactions().get(wallet.getTransactions().size()-1);
        String sql = "INSERT INTO `transactions`(`saldo`, `transaction_type`, `wallet_id`) "+
                    "VALUES ('"+t.getAmount()+"','"+t.getType()+"','"+wallet.getId()+"')";
        excuteInsertStatement(sql);
    }
    public void insertTransaction(int amount, int type, int id) {
        String sql = "INSERT INTO `transactions`(`saldo`, `transaction_type`, `wallet_id`) "+
                    "VALUES ('"+amount+"','"+type+"','"+id+"')";
        excuteInsertStatement(sql);
    }

    public void updateSaldoWallet(int saldo, int id) {
        String sql = "UPDATE `wallets` SET saldo = "+saldo +" WHERE id = "+id;
        excuteInsertStatement(sql);
    }

    public ResultSet getUsersDB() {
        String sql = "SELECT * FROM users";    
        return executeQueryStatement(sql);
    }

    public ResultSet getWalletUser(int id) {
        String sql = "SELECT * FROM wallets WHERE user_id = "+id;
        return executeQueryStatement(sql);
    }

    public ResultSet getWalletTransaccions(int id) {
        String sql = "SELECT * FROM transactions WHERE wallet_id = "+id;
        return executeQueryStatement(sql);
    }



    public ResultSet executeQueryStatement(String sql){
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void excuteInsertStatement(String sql) {
        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
