package exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program demonstrate writing data as byte using FileOutputStream.
 * 
 * 
 * @author ashliya
 *
 */

public class RainFallOutput {
	
	public static void main(String[] args) {

		//1. declaration of file name.
		String outFile = "RainFallOutput.txt";
		
		//2. list the data in array
		 String[][] rainfallData = {
	                {"2421003", "Simpang Ampat", "Alor Gajah", "0", "0", "4", "1", "0", "6"},
	                {"2322006", "Melaka Pindah", "Alor Gajah", "0", "0", "0", "0", "0", "2"},
	                /*{"2225044", "Chohong", "Jasin", "6", "0", "0", "21", "0", "39"},
	                {"2125002", "Telok Rimba", "Jasin", "13", "0", "0", "1", "1", "69"},
	                {"2223023", "Sg. Duyong", "Melaka Tengah", "37", "0", "0", "3", "0", "43"},
	                {"2222006", "Cheng (Taman Merdeka)", "Melaka Tengah", "20", "0", "0", "3", "0", "42"}*/};
		
		try (
			
			//3. create an output stream between this program and the target file
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile))) {
			
			//4. insert the data into the file
			for (String[] rainfallDatas : rainfallData) {
				
				 String station_Id = rainfallDatas[0];
	                String station_Name = rainfallDatas[1];
	                String district_Name = rainfallDatas[2];
	                String[] rainfalls = {rainfallDatas[3], rainfallDatas[4], rainfallDatas[5],rainfallDatas[6], rainfallDatas[7], rainfallDatas[8]};
				
	                dos.writeUTF(station_Id);
	                dos.writeUTF(station_Name);
	                dos.writeUTF(district_Name);
			
			
			// Writing rainfall readings
	            for (String rainfall : rainfalls) {
	            	dos.writeInt(Integer.parseInt(rainfall));
	            }
			}
				
			//5. Clear the stream
			dos.flush();
			
			//6. close the stream
			dos.close();
			
			// indicate end of the program - if success
			System.out.println("Rainfall data has been written to the file: " + outFile);

		} catch (IOException e) {
			
			// if there an error, it will display this message
			System.out.println("An error occurred while writing the rainfall data to the file: " + outFile);
		}

	}
}