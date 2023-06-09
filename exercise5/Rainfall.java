package exercise5;

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

public class Rainfall {

	public static void main(String[]args)
	{
		// 1. Declare output file 
		String outFile = "RainFall.txt";
			
		// 2. Data declaration
		double rainfalldata[] = {0.0,4.0,1.0,0.0,6.0,19.0};
		
		try {
				// 3. Create stream to read data
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
			
				//4. insert the data into the file
				// Process data
				for (double rainfall : rainfalldata) {
					dos.writeDouble((double) rainfall);
				}
					
				// 6. Flush for each writing
				dos.flush();
				
				// 7. Close stream
				dos.close();
				// indicate end of the program - if success
				System.out.println("Rainfall data has been written to the file: " + outFile);
					
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("End of program. Check out " + outFile); 

			}
	}

}




