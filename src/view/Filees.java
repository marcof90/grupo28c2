package view;

import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.InputStream;
//import java.io.OutputStream;
import java.util.Properties;


public class Filees {

    public static void main(String[] args) {

        try {
            InputStream ins = new FileInputStream("./data/data.properties");

            Properties prop = new Properties();

            prop.load(ins);

            System.out.println(prop.getProperty("numero67"));
        } catch (Exception e) {
            //TODO: handle exception
        }
        /*try {
            

            OutputStream ous = new FileOutputStream("./data/data.properties");

            var prop = new Properties();

            //prop.setProperty("nombre", "marco");
            //prop.setProperty("edad", "31");

            for (int i = 0; i < 100; i++) {

                prop.setProperty("numero"+i ,(i * 3)+"");

            }


            prop.store(ous, null);

            //System.out.println(prop);

        } catch (Exception e) {

            //TODO:handle exception
        }
    */
    }
    
    
}
