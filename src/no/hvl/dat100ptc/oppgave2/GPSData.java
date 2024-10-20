package no.hvl.dat100ptc.oppgave2;

import java.util.Scanner;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

    private GPSPoint[] gpspoints;
    protected int antall = 0;

    public GPSData(int n) {
        //setter antall rader i tabellen og setter variable antall til 0.
        
        GPSPoint[]refTabell = new GPSPoint[n];
        
        gpspoints=refTabell;
        antall = 0;    
        
    }

    public GPSPoint[] getGPSPoints() {
        //retunerer objektet på tabellen
        
        return this.gpspoints;
    }
    
    protected boolean insertGPS(GPSPoint gpspoint) {
      // setter en verdi inni variablet gpspointet der "antall" bestemer, etter hvor mange rader det er .
        
        if (antall < gpspoints.length) {
        gpspoints[this.antall] = gpspoint;    
        antall++;
        return true;
        }
        
        else {
        return false;
        }
    }

    public boolean insert(String time, String latitude, String longitude, String elevation) {
        // Setter inn et objekt in i tabellen lest fra et notat. Settet inn i forhold til insertGPS metoden.
        
    int timeTall = GPSDataConverter.toSeconds(time);
    
    double latitudeTall = Double.parseDouble(latitude);
    double longitudeTall = Double.parseDouble(longitude);
    double elevationTall = Double.parseDouble(elevation);
    
        GPSPoint gpspoint = new GPSPoint(timeTall, latitudeTall, longitudeTall, elevationTall);
        
        return insertGPS(gpspoint);
        
            
    }

    public void print() {
  // skriver ut alle objetne i tabelen fra 0 til antall rader i tabellen.
        
    System.out.println("====== GPS Data - START ======");
    int i = 0;
    while(i < gpspoints.length && gpspoints[i]!=null) {
        gpspoints[i].toString();
        i++;
    }
    System.out.println("====== GPS Data - SLUTT ======");
    }
}