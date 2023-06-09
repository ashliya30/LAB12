package exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class RainFallDisplay {

	public static void main(String[]args)
	{
		// 1. Declare output file 
				String sourceFile = "RainFall.txt";
				System.out.println("Reading data from " + sourceFile + "\n");
				
		// 2. Create stream to read data

				try {
					
					double rainfall=0;
					double totalrainfall = 0;
					double noOfRecords=0;
					double averageRainfall=0;
					DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));
					
					// 2. Read values in the array from the stream
					for (int i = 0; i < 6; i++) {
						rainfall = dis.readDouble();
						System.out.println("Day " + (i + 1) + ": " + rainfall + " mm");
						
						// Calculate total utilization
						totalrainfall += rainfall;
						noOfRecords ++;
						
					}
					
					// Close stream
					dis.close();
					//System.out.println();
					
					// Calculate average rainfall
					averageRainfall = totalrainfall / noOfRecords;
					String formattedAverage = String.format("%.1f", averageRainfall);
					System.out.print("\nAverage rainfall for Simpang Ampat : "+ formattedAverage + "%");
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					System.out.println("End of program. Check out " + sourceFile); 

				}

	}
	
}
