package view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Files {
    
    public static void main(String[] args) {
        
        try {

            InputStream ins = new FileInputStream("./data/data.properties");
            Properties prop = new Properties();

            prop.load(ins);

            System.out.println(prop.getProperty("numero67"));
            
        } catch (Exception e) {

        }

        /* try {
            
            OutputStream ous = new FileOutputStream("./data/data.properties");
            Properties prop = new Properties();

            for (int i = 1; i <= 100; i++){
                prop.setProperty("numero" + i, Integer.toString(i * 3));
            }

            prop.store(ous, null);

            ous.close();

        } catch (Exception e) {
            
        } */
    }

}
