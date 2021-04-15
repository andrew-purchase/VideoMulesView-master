package Queries;

public class PlayerQueries {
    public static String PlayersQuery(String type){
        return "SELECT DISTINCT player_name FROM video WHERE video_type = " + "'" + type + "'"
                + " and team_name = 'University of Central Mis'";
    }

    public static String VideosQuery(String name){
        return "SELECT video_name FROM video WHERE player_name = " + "'" + name + "'";
    }

    public static String VideoLink (String videoName){
        return "SELECT video_link FROM video WHERE video_name = " + "'" + videoName + "'";
    }

    public static String TeamList(){
        return "SELECT DISTINCT team_name FROM video WHERE team_name != 'University of Central Mis'";
    }

    public static String PitcherList(String teamName){
        return "SELECT DISTINCT player_name FROM video WHERE team_name = '" + teamName + "';";
//        return "SELECT DISTINCT player_name FROM video where team_name = 'University of Central Mis'";
//        return "SELECT DISTINCT player_name FROM video";
    }


}
