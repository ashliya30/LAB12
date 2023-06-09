package exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class RainFallInput
{
	public static void main(String[]args)
	{
		// 1. Declare output file 
		
		try {
			
			String sourceFile = "RainFallOutput.txt";
			System.out.println("Reading data from " + sourceFile + "\n");
			
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));
			
			// Variables for processing byte-based data
			
			String station_Id ;
            String station_Name;
            String district_Name ;

			int stationCount = 0;
			int districtCount = 0;
			int stationTotalRainfall = 0;
			
			 // Variables for average rainfall calculation
			 int[] totalRainfall = new int[6];
			 int[] stationRainfallCount = new int[6];
			 
			
						
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				station_Id = dis.readUTF();
				station_Name = dis.readUTF();
				district_Name= dis.readUTF();
				
				System.out.println("Station ID : " +station_Id);
				System.out.println("Station name : "+station_Name);
				System.out.println("District name : "+district_Name);
				
				// 2. Read values in the array from the stream
				for (int i1 = 0; i1 < 6; i1++) {
						 
						 int data = dis.readInt();
						 stationTotalRainfall += data;
						 totalRainfall[i1] += data;
						 stationRainfallCount[i1]++;

						 System.out.println("Day " + (i1 + 1) + ": " + data);
					 }

					 double stationAvgRainfall = stationTotalRainfall / 6.0;
					 System.out.println("Average Rainfall: " + stationAvgRainfall);
					 System.out.println();
					 stationCount++;
					 districtCount++;
			
				}
				 dis.close();

				 System.out.println("Number of Stations: " + stationCount);
				 System.out.println("Number of Districts: " + districtCount);
				 System.out.println("Average Rainfall for Each Day:");
				 for (int i = 0; i < 6; i++) {
					 double averageRainfall = totalRainfall[i] / (double) stationRainfallCount[i];
					 System.out.println("Day " + (i + 1) + ": " + averageRainfall);
				 }

				

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}