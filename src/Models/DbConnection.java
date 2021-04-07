package Models;

import Queries.PlayerQueries;
import javafx.scene.control.ListView;

import javax.sql.rowset.CachedRowSet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


    public class DbConnection {
        public static Statement stmt;
        public static void InitializeDB() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver loaded");
            Connection myConn = DriverManager.getConnection
                    ("jdbc:mysql://BigOunce.duckdns.org:50931/UCM_Baseball_Video_Control?serverTimezone=UTC","madera" ,"java-project");
            System.out.println("Database connected");

            stmt = myConn.createStatement();
        }

        public static void FillList (String Type, ListView<String> view) throws Exception {
            ArrayList<String> players_name = new ArrayList<>();
            String videoQuery = PlayerQueries.PlayersQuery(Type);
            ResultSet rs = stmt.executeQuery(videoQuery);
            while (rs.next()) {
                players_name.add(rs.getString("player_name"));
            }
            for (String p : players_name){
                view.getItems().add(p);
            }
        }

        public static void FillVideoList (String name, ListView<String> video) throws Exception{
            ArrayList<String> video_name = new ArrayList<>();
            String videoQuery = PlayerQueries.VideosQuery(name);
            ResultSet rs = stmt.executeQuery(videoQuery);
            while (rs.next()) {
                video_name.add(rs.getString("video_name"));
            }
            for(String v : video_name) {
                video.getItems().add(v);
            }
        }

        public static String ReturnVideoLink(String videoName) throws Exception{
            String videoQuery = PlayerQueries.VideoLink(videoName);
            ResultSet rs = stmt.executeQuery(videoQuery);
            String name="";
            while (rs.next()){
                name = rs.getString("video_link");
            }
            return name;
        }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        InitializeDB();
    }

}
