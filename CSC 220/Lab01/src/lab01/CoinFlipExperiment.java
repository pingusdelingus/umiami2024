package lab01;
import java.lang.Math;


public class CoinFlipExperiment {
	
	static short numOfWins = 0;
	public static void main(String[] args) {
		// System.out.println("Hello World!");
		String resultArray[] = new String[100];
		
		short numOfWins = 0;
		
		double randomNum = Math.random();
		
		
		
		
		for (int index = 0; index < resultArray.length; index++) {
			resultArray[index] = coinFlipExperiment();
			if (resultArray[index] == "Heads") {
				numOfWins += 1;
			}
			System.out.println(resultArray[index]);
			
		}
		
		System.out.println("You have won : " + numOfWins + " number of times!");
		
		
		if (numOfWins > 50) {
			System.out.println("You are profitable!");
			
		}else {
			System.out.println("You are not profitable");
		}
		
		
		
		
		
		
		
		
	}// end of main

	
	public static String coinFlipExperiment() {
		
		double randomNum = Math.random();
		
		if (randomNum < 0.505) {
			return "Heads";
		}else {
			return "Tails";
			
		}
	}
	
	
	
	
}// end of CoinFlipExperiment CLASS