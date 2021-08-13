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

            prop.forEach((key, value) -> System.out.println(key+" "+value));

            // System.out.println(prop.getProperty("numero67"));

        } catch (Exception e) {
            //TODO: handle exception
        }

        /* try {
            
            OutputStream ous = new FileOutputStream("./data/data.properties");

            Properties prop = new Properties();

            // prop.setProperty("nombre", "Marco");
//            prop.setProperty("edad", "31");

            for (int i = 1; i <= 100; i++) {
                prop.setProperty("numero"+i, (i*3)+"");
            }

            prop.store(ous, null);
            
            ous.close();

            System.out.println(prop);

        } catch (Exception e) {
            //TODO: handle exception
        } */
    }
}
