package Models;

public class Players {


    public String Player_Name;
    public String Team_Name;
    public String Type;

    public Players(){

    }

    public Players(String Player_name, String Team_Name, String Type){
        this.Player_Name=Player_name;
        this.Team_Name=Team_Name;
        this.Type=Type;
    }

    public String getPlayer_Name() {
        return Player_Name;
    }

    public String getTeam_Name() {
        return Team_Name;
    }

    public String getType() {
        return Type;
    }
    public String toString(){
        return Player_Name + ", " + Team_Name + ", " + Type;
    }
}
