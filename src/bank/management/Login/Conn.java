
package bank.management.Login;
import java.sql.*;

public class Conn {
     Connection c;
     Statement s;
    
    public Conn(){   //constructor 
       
        //handle exception handling for mysql is external handling that why hadling runtime exception
        
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");
            s = c.createStatement();
        }  catch(Exception e){
           System.out.println(e);
            
        }
    }

   
    
}
