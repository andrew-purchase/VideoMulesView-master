package Queries;

public class PlayerQueries {
    public static String PlayersQuery(String type){
        return "SELECT DISTINCT player_name FROM video WHERE video_type = " + "'" + type + "'"
                + " and team_name = 'University of Central Mis' ORDER BY player_name";
    }

    public static String VideosQuery(String name){
        return "SELECT video_name FROM video WHERE player_name = " + "'" + name + "'ORDER BY video_name";
    }

    public static String VideoLink (String videoName){
        return "SELECT video_link FROM video WHERE video_name = " + "'" + videoName + "'";
    }

    public static String TeamList(){
        return "SELECT DISTINCT team_name FROM video WHERE team_name != 'University of Central Mis' ORDER BY team_name";
    }

    public static String PitcherList(String teamName){
        return "SELECT DISTINCT player_name FROM video WHERE team_name = '" + teamName + "'ORDER BY player_name;";
//        return "SELECT DISTINCT player_name FROM video where team_name = 'University of Central Mis'";
//        return "SELECT DISTINCT player_name FROM video";
    }

    public static String InsertNewPlayer(String player_name, String video_name, String video_link, String type){
        return "INSERT INTO `video` (`player_name`, `team_name`, `video_name`, `video_link`, `Year`, `video_type`) VALUES " +
                "('" + player_name + "','University of Central Mis','" + video_name + "','" + video_link +"',NULL,'" +
                type + "')";
    }

    public static String InsertNewOpponentVideo(String player_name, String player_link, String video_name, String player_type, String team_name){
        return "INSERT INTO `video` (`player_name`, `team_name`, `video_name`, `video_link`, `video_type`) VALUES " +
                "('" + player_name + "','" + team_name + "','" + video_name + "','" + player_link + "','" +
                player_type + "')";
    }

    public static String DeletePlayer (String player_name, String video_name){
        return "DELETE FROM `UCM_Baseball_Video_Control`.`video` WHERE (`video_name` = '" + video_name + "') AND (`player_name` = '"
                + player_name + "')";
        //return "DELETE FROM `UCM_Baseball_Video_Control`.`video` WHERE (`video_link` = '" + video_link + "')";
    }


}
