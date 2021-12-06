package com.example.sportsinfo;

public class tableModel {
    String Team_id;
    String Team_points;
    String Won;
    String Lost;
    String Draw;
    String GD;

    public tableModel(String team_id, String team_points, String won, String lost, String draw, String GD) {
        this.Team_id = team_id;
        this.Team_points = team_points;
        this.Won = won;
        this.Lost = lost;
        this.Draw = draw;
        this.GD = GD;
    }

    public String getTeam_id() {
        return Team_id;
    }

    public String getTeam_points() {
        return Team_points;
    }

    public String getWon() {
        return Won;
    }

    public String getLost() {
        return Lost;
    }

    public String getDraw() {
        return Draw;
    }

    public String getGD() {
        return GD;
    }
}
