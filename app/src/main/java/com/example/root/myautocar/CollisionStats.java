package com.example.root.myautocar;

public class CollisionStats {
    private Double clat;
    private Double clng;
    private String time;
    private String type;

    public CollisionStats(Double clng,Double clat,String time,String type) {
        this.clng = clng;
        this.clat=clat;
        this.time=time;
        this.type=type;
    }

    public Double getClat() {
        return clat;
    }

    public void setClat(Double clat) {
        this.clat = clat;
    }

    public Double getClng() {
        return clng;
    }

    public void setClng(Double clng) {
        this.clng = clng;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
