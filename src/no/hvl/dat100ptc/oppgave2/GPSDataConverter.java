package no.hvl.dat100ptc.oppgave2;
import no.hvl.dat100ptc.TODO;
import java.lang.Double;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import java.lang.Integer;
import java.lang.String;

public class GPSDataConverter {

    
    private static int TIME_STARTINDEX = 11; 

    public static int toSeconds(String timestr) {
    
        String hr = timestr.substring(TIME_STARTINDEX, 13);
        String min = timestr.substring(14,16);
        String sec = timestr.substring(17,19);
        int hrTall = Integer.parseInt(hr);
        int minTall = Integer.parseInt(min);
        int secTall = Integer.parseInt(sec);
        
        int secs = hrTall*60*60 + minTall*60 + secTall;
        
        return secs;
    }
    
    
    public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
        int timeTall = toSeconds(timeStr);
        double latitudeTall = Double.parseDouble(latitudeStr);
        double longitudeTall = Double.parseDouble(longitudeStr);
        double elevationTall = Double.parseDouble(elevationStr);
        
        GPSPoint gpspoint = new GPSPoint(timeTall, latitudeTall, longitudeTall, elevationTall);
        System.out.print(gpspoint);
        return gpspoint;
        
    }
    
}