package com.example.sportsinfo;

public class nbaTeamModel {
    private String team_name;
    private String abbreviation;
    private String Team_id;
    private String conference;
    private String division;

    //constructor
    public nbaTeamModel(String team_name, String abbreviation, String team_id, String conference, String division) {
        this.team_name = team_name;
        this.abbreviation = abbreviation;
        this.Team_id = team_id;
        this.conference = conference;
        this.division = division;
    }


    //getter's
    public String getTeam_name() {
        return team_name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getTeam_id() {
        return Team_id;
    }

    public String getConference() {
        return conference;
    }

    public String getDivision() {
        return division;
    }
}
