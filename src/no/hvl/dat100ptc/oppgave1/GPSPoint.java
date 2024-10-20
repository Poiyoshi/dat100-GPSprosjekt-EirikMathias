package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

     private int time = 0;
    private double latitude = 0;
    private double longitude = 0;
    private double elevation = 0;
    
    public GPSPoint(int time, double latitude, double longitude, double elevation) {

        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        

        
    }

    public int getTime() {
        System.out.println(this.time);
        return this.time;
        
    }

    public void setTime(int time) {
                
        this.time = time;
        
    }

    public double getLatitude() {
        System.out.println(this.latitude);
    return this.latitude;
        
        
    }

    public void setLatitude(double latitude) {
        
        this.latitude = latitude;
        
    }

    public double getLongitude() {
        System.out.println(this.longitude);
        return this.longitude;
        
    }

    public void setLongitude(double longitude) {
        
        this.longitude = longitude;
        
    }

    public double getElevation() {
        System.out.println(this.elevation);
        return this.elevation;
        
    }

    public void setElevation(double elevation) {
        
        this.elevation = elevation;
        
    }
    
    public String toString() {
        
        String str = "";
        
        str += time + " (" + latitude + "," + longitude + ") " + elevation + "\n";
        
        return str;
        
    }
}