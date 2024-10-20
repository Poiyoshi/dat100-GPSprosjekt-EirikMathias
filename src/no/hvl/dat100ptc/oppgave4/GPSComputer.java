package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double distance = 0;

		for(int i = 0 ; i < gpspoints.length-1;i++) {
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
		
		}
	System.out.print(distance);
	return distance;
		
	}

	public double totalElevation() {
 
		double[]tabellElevation = new double[gpspoints.length];
		int i = 0;
		for(GPSPoint e : gpspoints) {
			
			tabellElevation[i]=e.getElevation();
			i++;
		}
		double hPunkt = GPSUtils.findMax(tabellElevation);
	return hPunkt;
		
	}

	public int totalTime() {
	
		return gpspoints[gpspoints.length - 1].getTime() - gpspoints[0].getTime();
		
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		
		for(int i = 0 ; i < gpspoints.length-1 ; i++) {
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}
		return speeds;
	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
	double[] speeds = new double[gpspoints.length-1];
		
		for(int i = 0 ; i < gpspoints.length-1 ; i++) {
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}
		maxspeed = GPSUtils.findMax(speeds);
		
		return maxspeed;
	}
	

	public double averageSpeed() {
		double average = 0;
		
		
		double D = totalDistance();
		double T = totalTime();
		
		average = D/T;
		
		return average;
		
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;
		double t;
		double met = 0;	
		double speedmph = speed * MS;
		
		t = secs/3600.0;
		

		    if (speedmph < 10) {
		        met = 4.0;
		    } else if (speedmph < 12) {
		        met = 6.0;
		    } else if (speedmph < 14) {
		        met = 8.0;
		    } else if (speedmph < 16) {
		        met = 10.0;
		    } else if (speedmph < 20) {
		        met = 12.0;
		    } else {
		        met = 16.0;
		    }
		
		kcal = met * weight * t;
		System.out.println(kcal);
		return kcal;

	}

	public double totalKcal(double weight) {
		
		  double totalKcal = 0;

		    for (int i = 0; i < gpspoints.length - 1; i++) {
		        int time = gpspoints[i + 1].getTime() - gpspoints[i].getTime(); 
		        double speed = GPSUtils.speed(gpspoints[i], gpspoints[i + 1]); 

		        totalKcal += kcal(weight, time, speed);
		    }
		    System.out.println("------>" + totalKcal);
		    return totalKcal;
	
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {
	

	String tTime = String.format("%-15s:%11s", "Total time", GPSUtils.formatTime(totalTime()) );
	String tDistance = String.format("%-15s:%11d %2s", "Total time", totalDistance(), "km");
	String tElevation = String.format("%-15s:%11d %1s", "Total time", totalElevation(), "m" );
	String mSpeed = String.format("%-15s:%11d %4s", "Total time", maxSpeed(), "km/t" );
	String aSpeed = String.format("%-15s:%11d %4s", "Total time", averageSpeed(), "km/t");
	String energi = String.format("%-15s:%11d %4s", "Total time", totalKcal(WEIGHT), "kcal");
	
	System.out.println("==============================================");
	System.out.println(tTime);
	System.out.println(tDistance);
	System.out.println(tElevation);
	System.out.println(mSpeed);
	System.out.println(aSpeed);
	System.out.println(energi);
	System.out.println("==============================================");
	}

}