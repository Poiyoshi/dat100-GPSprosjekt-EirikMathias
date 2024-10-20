package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
		
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[]tabellLatitud = new double[gpspoints.length];
		int i = 0;
		for(GPSPoint e : gpspoints) {
			
			tabellLatitud[i]=e.getLatitude();
			i++;
		}
		return tabellLatitud;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[]tabellLongitud = new double[gpspoints.length];
		int i = 0;
		for(GPSPoint e : gpspoints) {
			
			tabellLongitud[i]=e.getLongitude();
			i++;
		}
		return tabellLongitud;

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		//henter gpspoint1 verdier
		double latitude1 = gpspoint1.getLatitude();
		double longitude1 = gpspoint1.getLongitude();
	
		//henter gpspoint2 verdier
		double latitude2 = gpspoint2.getLatitude();
		double longitude2 = gpspoint2.getLongitude();
		
		//omgjør latitude til radian verdi
		double latitude1Radian = toRadians(latitude1);
		double latitude2Radian = toRadians(latitude2);
		
		// Radian omgjøring 2-1
		double latitude2_1 = toRadians( latitude2 - latitude1 );
		double longitude2_1 = toRadians( longitude2 - longitude1 );
		
		//Regner ut gitte formler med fra input
//		double a = Math.pow((sin(latitude2_1/2)),2)+cos(latitude1Radian)*cos(latitude2Radian)*Math.pow((sin(longitude2_1/2)),2);
		double a = compute_a(latitude1Radian, latitude2Radian, latitude2_1, longitude2_1);
//		double c = 2* atan2(sqrt(a) , sqrt(1-a));
		double c = compute_c(a);
		double d = R*c; 
		
		return d;
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		
		double a = Math.pow((sin(deltaphi/2)),2)+cos(phi1)*cos(phi2)*Math.pow((sin(deltadelta/2)),2);
		
		return a;

	}

	private static double compute_c(double a) {
		
		double c = 2* atan2(sqrt(a) , sqrt(1-a));
		
		return c;

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int tid1 = gpspoint1.getTime();
		int tid2 = gpspoint2.getTime();
		
		int tidSec = tid2-tid1;
		
		double distanseAtilB = distance(gpspoint1, gpspoint2);
		
		double speed = distanseAtilB/tidSec;
		
		return speed;
	}

	public static String formatTime(int secs) {

		int hh = secs/3600;
		int hhRest = secs % 3600;
		int mm = hhRest/60;
		int mmRest = hhRest % 60;
		int ss = mmRest;

		 String tideneSkillet = String.format("%02d:%02d:%02d", hh, mm, ss);

		String tiden = String.format("%10s", tideneSkillet);
		return tiden;
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = String.format("%10.2f", d);
		System.out.println("denne" + str);
		return str;
		
	}
}