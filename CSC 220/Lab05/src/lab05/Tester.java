package lab05;

public class Tester {

    //TODO: You will need to write your own test for the Lab and the Assginment
    // Hint: You will need a main method to run your tests
    
    /*
     * Suggested Testing Strategy for Lab:
     *  1. Create an empty **SortedBinarySet**.
     *  2. Check its size and whether it is empty.
     *  3. Start adding a few numbers to your **SortedBinarySet** and ensure they are added properly (i.e., they are in the sorted order, and the other member variables reflect the changes).
     *  4. Continue adding values to your **SortedBinarySet** until you go beyond its original capacity. Ensure no errors occur in this case and that the **SortedBinarySet** does indeed grow.
     *  5. Test your `clear()` method to see if all elements are removed from the **SortedBinarySet**.
     */
	
	
	public static void main(String[] args) {
		
		double[] test = {1.0, 3.0, 12.0, 3.0};
		double[] chk = {1.0,5.0, 12.0};
		SortedBinarySet set = new SortedBinarySet(test);
		System.out.println(set);
		int ans = set.findIndex(12.0);
		System.out.println(ans);
//		set.insert(13.0);
//		System.out.println(set);
//		
		
		
//		System.out.println("inserting 9.0");
		
		
		
//		System.out.println(set);
////		set.insert(8.0);
////		System.out.println(set);
//		set.remove(4.0);
//		System.out.println(set);
		boolean ans1 = set.containsAll(chk);
		System.out.println(ans1);
		
		
		
		// part 3
		double[] large = new double[100000];
		
		
		for(int index = 0; index < 100000; index++) {
			large[index] = Math.random()* index - Math.random() / 2;
			//System.out.println(large[index] + " just added.");
		}
		SortedBinarySet time = new SortedBinarySet(large);
		long start = System.nanoTime();
		time.findIndex(1.0);
		long end = System.nanoTime();
		
		System.out.println(end - start);
		System.out.println("man that was slow");
		
	}// end of main method

}// end of tester class
