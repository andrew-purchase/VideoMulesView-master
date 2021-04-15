package Models;

public class Videos {
    public String Player_Name;

    public String Team_Name;
    public String Video_Link;
    public String Video_Name;
    public String Type;

    public Videos(){}

    public Videos(String Player_name, String Team_Name,String Video_Link,String Video_Name, String Type){
        this.Player_Name=Player_name;
        this.Team_Name=Team_Name;
        this.Video_Link=Video_Link;
        this.Video_Name=Video_Name;
        this.Type=Type;
    }

    public String getPlayer_Name() {
        return Player_Name;
    }

    public String getTeam_Name() {
        return Team_Name;
    }

    public String getVideo_Link() {
        return Video_Link;
    }

    public String getVideo_Name() {
        return Video_Name;
    }

    public String getType() {
        return Type;
    }

    public String toString(){
        return Player_Name + ", " + Team_Name + ", " + Video_Link + ", " + Video_Name + ", " + Type;
    }
}

