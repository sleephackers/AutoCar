package com.example.root.myautocar;

public class CarStats {
    private  String Carname;
    private Double lat;
    private Double lng;
    private Integer fuel;
    private Float speed;

    public CarStats(String carname, Double mylat, Double mylng, Integer myfuel, Float myspeed) {
        Carname = carname;
        speed = myspeed;
        lat=mylat;
        lng=mylng;
        fuel=myfuel;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getCarname() {
        return Carname;
    }

    public void setCarname(String carname) {
        Carname = carname;
    }
}
