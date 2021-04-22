package Models;

import Queries.PlayerQueries;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.sql.*;
import java.util.ArrayList;


    public class DbConnection {
        public static Statement stmt;
        public static void InitializeDB() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //I had to change "fDriver" to "Driver" -Andrew
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

        //need to make generic
        public static void FillTeamList (ListView<String> view) throws Exception {
            ArrayList<String> team_name = new ArrayList<>();
            String teamQuery = PlayerQueries.TeamList();
            ResultSet rs = stmt.executeQuery(teamQuery);
            while (rs.next()) {
                team_name.add(rs.getString("team_name"));
            }
            for (String p : team_name){
                view.getItems().add(p);
            }
        }
        public static void FillTeamList2 (ChoiceBox<String> view) throws Exception {
            ArrayList<String> team_name = new ArrayList<>();
            String teamQuery = PlayerQueries.TeamList();
            ResultSet rs = stmt.executeQuery(teamQuery);
            while (rs.next()) {
                team_name.add(rs.getString("team_name"));
            }
            for (String p : team_name){
                view.getItems().add(p);
            }
        }

        public static void FillPitcherList (String teamName, ListView<String> view) throws Exception {
            ArrayList<String> pitcher_name = new ArrayList<>();
            String playerQuery = PlayerQueries.PitcherList(teamName);
            ResultSet rs = stmt.executeQuery(playerQuery);
            while (rs.next()) {
                pitcher_name.add(rs.getString("player_name"));
            }
            for (String p : pitcher_name){
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
        public static String ReturnVideoLink2(String videoName) throws Exception{
            String videoQuery = PlayerQueries.VideoLink(videoName);
            ResultSet rs = stmt.executeQuery(videoQuery);
            String name="";
            while (rs.next()){
                name = rs.getString("video_link");
            }
            return name;
        }
        public static void addNewPlayer(String name, String vName, String vLink, String type) throws SQLException {
            String newPlayerQuery=PlayerQueries.InsertNewPlayer(name, vName, vLink, type);
            stmt.executeUpdate(newPlayerQuery);
        }
        public static void addNewOpponentVideo(String player_name, String player_link, String video_name, String player_type, String team_name) throws SQLException {
            String newOpponentQuery=PlayerQueries.InsertNewOpponentVideo(player_name, player_link, video_name, player_type, team_name);
            stmt.executeUpdate(newOpponentQuery);
        }
        public static void DeletePlayer (String player_name, String video_name) throws SQLException {
            String deletePlayer = PlayerQueries.DeletePlayer(player_name, video_name);
            stmt.executeUpdate(deletePlayer);
        }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        InitializeDB();
    }

}
