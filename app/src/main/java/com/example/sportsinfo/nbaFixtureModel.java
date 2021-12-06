package com.example.sportsinfo;

public class nbaFixtureModel {
    private String home_team;
    private String away_team;
    private String home_points;
    private String away_points;
    private String date;

    //constructor
    public nbaFixtureModel(String home_team, String away_team, String home_points, String away_points, String date) {
        this.home_team = home_team;
        this.away_team = away_team;
        this.home_points = home_points;
        this.away_points = away_points;
        this.date = date;
    }

    //getter
    public String getHome_team() {
        return home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public String getHome_points() {
        return home_points;
    }

    public String getAway_points() {
        return away_points;
    }

    public String getDate() {
        return date;
    }
}
