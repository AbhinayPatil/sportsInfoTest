package com.example.sportsinfo;

public class footballFixModel {
   private String img_url_home;
    private String img_url_away;
    private String home_score;
    private String away_score;
    private String home_team;
    private String away_team;
    private String date;
    private String venue;
    private String status;
    private String ht_score;
    private String ft_score;
    private String time;

    //constructor
    public footballFixModel(
            String img_url_home, String img_url_away,
            String home_score, String away_score, String home_team, String away_team, String date, String venue, String status, String ht_score, String ft_score,String time) {
        this.img_url_home = img_url_home;
        this.img_url_away = img_url_away;
        this.home_score = home_score;
        this.away_score = away_score;
        this.home_team = home_team;
        this.away_team = away_team;
        this.date = date;
        this.venue = venue;
        this.status = status;
        this.ht_score = ht_score;
        this.ft_score = ft_score;
        this.time = time;
    }

    //getter

    public String getImg_url_home() {
        return img_url_home;
    }

    public String getImg_url_away() {
        return img_url_away;
    }

    public String getHome_score() {
        return home_score;
    }

    public String getAway_score() {
        return away_score;
    }

    public String getHome_team() {
        return home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public String getStatus() {
        return status;
    }

    public String getHt_score() {
        return ht_score;
    }

    public String getFt_score() {
        return ft_score;
    }

    public String getTime() {
        return time;
    }
}
