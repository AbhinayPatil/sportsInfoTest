package com.example.sportsinfo;

public class islTeamModel {
    private String isl_team_name;
    private String isl_team_logo;
    private String isl_team_shortForm;
    private String isl_team_id;

    public islTeamModel(String isl_team_name, String isl_team_logo, String isl_team_shortForm, String isl_team_id) {
        this.isl_team_name = isl_team_name;
        this.isl_team_logo = isl_team_logo;
        this.isl_team_shortForm = isl_team_shortForm;
        this.isl_team_id = isl_team_id;
    }

    public String getIsl_team_name() {
        return isl_team_name;
    }

    public String getIsl_team_logo() {
        return isl_team_logo;
    }

    public String getIsl_team_shortForm() {
        return isl_team_shortForm;
    }

    public String getIsl_team_id() {
        return isl_team_id;
    }
}
