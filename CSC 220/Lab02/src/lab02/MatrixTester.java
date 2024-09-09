/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
*/
package lab02;

public class MatrixTester {
	public static void main(String[] args)
	{	
		//Experiment 1
		//Matrix M1 = new Matrix(2, 4);
		
		//Experiment 2 - do not uncomment before you finish the steps required
		//Matrix M1 = new Matrix();
		
		//Experiment 3
		// Matrix M1 = new Matrix(new int[][]
        //         {{1, 2, 3},
		// 		  {2, 5, 6}});		
		
		/*
		 * This is another example Matrix you can try 
		*/
		Matrix M2 = new Matrix(new int[][]
		                                 {{1, 2},
										  {3, 4},
										  {5, 6}});
		Matrix M1 = new Matrix(new int[][]
		                                 {{1, 2,3},
										  {3, 4,3},
										  {5, 6, 3}});
		System.out.println("This is M1 ");
		System.out.println(M1);
		
		System.out.println("This is M2");
		System.out.println(M2);
		
		Matrix M3 = M1.mult(M2);
		System.out.println(M3);
		
		//Matrix M5 = new Matrix(new int[][]
        //        {{1, 2},
		//		  {3, 4},
		//		  {5, 6}});
		//System.out.println(M2);
		//Matrix M3 = M2.transpose();
		//System.out.println(M3);
		//Matrix M6 = M2.add(M5);
		//System.out.println(M6);
		
		
		
		/* 
		 * Note that the print will not be correct until you have implemented the toString method.
		 * This is just one example of a test of making sure your constructor is working
		 * You should write more test and experiment with various constructor cases
		 */
		
		//System.out.println("M1 is: \n" + M1 + "done.");	
		
		
		
		
	}
}
