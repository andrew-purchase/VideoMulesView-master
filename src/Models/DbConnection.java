package Models;

import javax.sql.rowset.CachedRowSet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;


    public class DbConnection {
        public static void InitializeDB() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver loaded");
            Connection myConn = DriverManager.getConnection
                    ("jdbc:mysql://BigOunce.duckdns.org:50931/UCM_Baseball_Video_Control?serverTimezone=UTC","madera" ,"java-project");
            System.out.println("Database connected");
            Statement stmt = myConn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM player");

            while (rs.next()){

                System.out.println(rs.getString(1));
            }
        }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        InitializeDB();
    }

}
