package studio8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.

public class CountSteps {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("\\Users\\emily\\git\\studio-8-heinrich-lopez-ichikawa_8\\data\\steps2.csv");
		Scanner sc = new Scanner(file);
		
		int peakCount = 0;
		
		int count = 0;
		while (sc.hasNextLine()) {
		    count++;
		    sc.nextLine();
		}
		
		File file2 = new File("\\Users\\emily\\git\\studio-8-heinrich-lopez-ichikawa_8\\data\\steps2.csv");
		Scanner sc2 =  new Scanner(file2);
		
		String prevLine = sc2.nextLine();
		String[] prevVal = prevLine.split(",");
		double prev = Double.parseDouble(prevVal[2]);
		
		String line = sc2.nextLine();
		String[] val = line.split(",");
		double current = Double.parseDouble(val[2]);
		
		for(int i = 0; i < count/3; i++) {
			String nextLine = sc2.nextLine();
			String[] nextVal = nextLine.split(",");
			double next = Double.parseDouble(nextVal[2]);
			
			if(current > prev && current > next) {
				peakCount++;
			}
			
			prev = current;
			current = next;
		}
		
		System.out.println(peakCount);
		
		
	}
	
}
