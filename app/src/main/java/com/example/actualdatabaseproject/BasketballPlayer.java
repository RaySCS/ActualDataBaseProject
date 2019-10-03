package com.example.actualdatabaseproject;

public class BasketballPlayer {

    int minutes, points, assists, steals, rebounds = 0;
    String pName = "";
    public BasketballPlayer(String n){
        pName = n;
    }

    public void addStats(int m, int p, int a, int s, int r){
        minutes = m;
        points = p;
        assists = a;
        steals = s;
        rebounds = r;
    }

    public int tellPoints(){
        return points;
    }

    public int tellMinutes(){
        return minutes;
    }


    public int tellAssists(){
        return assists;
    }

    public int tellSteals(){
        return steals;
    }

    public int tellRebounds(){
        return rebounds;
    }
}
