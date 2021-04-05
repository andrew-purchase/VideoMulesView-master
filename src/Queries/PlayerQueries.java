package Queries;

public class PlayerQueries {
    public static String PlayersQuery(String type){
        return String.format("SELECT\n" +
                "player_name\n" +
                "FROM\n" +
                "   'player'    \n" +
                "WHERE\n" +
                "   'video_type' = '%s';",type);
    }
}
