package lab01;
import java.util.HashMap;




public class SumExperiment {
	
	/**
	 * This method checks an array for any pair of values that add up to 20.
	 * If such a pair is found, it returns the index of the smallest value in that pair.
	 * If no such pair is found, it returns -1.
	 *
	 * @param array an array of integers to be inspected
	 * @return the index of the smallest value in the pair that sums to 20, or -1 if no such pair exists
     * @author Esteban Morales
	 */
	public static int checkSum(int[] array){
		// This function will inspect the input to find any pair of values that add up to 20
		// if it find such a pair, it will return the *index* of the smallest value
		// if it does not find such as pair, it will return -1;

    
		
	// This algorithm will run at ~O(n) time complexity as opposed to the
    // brute force O(n^2) algorithm
    // We will run at O(n) space complexity as well.
    
		
		
		
		
    // While we could implement a 2 pointer solution as we are guaranteed
    // that the array is sorted, this HashMap solution will work for any 
    // possible array given, sorted or not.

		
	//this will hold our (index,value) pairs that we have seen thus far
    HashMap<Integer, Integer> seenValues = new HashMap<Integer, Integer>();
    
    
    // this is our target sum 
    final int target = 20;
    int index;

    // we loop through all of the elements in the array, if we
    // reach a number that has it's complement in the HashMap we return the 
    // smallest index, if not, we put the number:index in our HashMap and we
    // continue looking through the array. 
    for (index = 0; index < array.length; index ++) {
    	
    	
    	// this is our complement or "missing" to get to the sum
    	int missing = target - array[index];
    	
    	
    	if (seenValues.containsKey(missing)) {
    		
    		return Math.min(seenValues.get(missing), index);
    	}else {
    		seenValues.put(array[index], index);
    	}
    	
    }// end of for loop
   // we return -1 if the array does not contain 2 numbers that sum to our target of 20
  
    return -1;
	
	}// end of checkSum METHOD
	
	
	public static void main(String[] args) {
		int[] array1 = new int[]{5, 7, 8, 9, 10, 15, 16};
		if (checkSum(array1) != 0)
			System.err.println("TEST1 FAILED");
		
		int[] array2 = new int[]{3, 5, 8, 9, 10, 15, 16};
		if (checkSum(array2) != 1)
			System.err.println("TEST2 FAILED");

		
		int[] array3 = new int[]{3, 4, 6, 9, 10, 14, 15};
		if (checkSum(array3) != 2)
			System.err.println("TEST3 FAILED");
		
		int[] array4 = new int[]{6, 7, 8, 9, 10, 15, 16};
		if (checkSum(array4) != -1)
			System.err.println("TEST4 FAILED");
		
		System.out.println("Done!!!");
	}
}
