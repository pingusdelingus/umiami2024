package lab02;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	public Matrix(){}
	
	// constructor 1 - Constructor for new zero matrix
	public Matrix(int rowDim, int colDim){
		/*  DONE !: Lab Part 1
			* write a constructor that would create a matrix
			* of correct size and initialize it to 0. 
		*/


    this.numRows = rowDim;
    this.numColumns = colDim;
    

    this.data = new int[rowDim][colDim];

    
    



	}// end of the Matrix Constructor 
	
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		/*  TODO: Lab Experiment 1.3
			*  1) put the numRows to be the number of 1D arrays in the 2D array
			*  2) specify the numColumns and set it
			*  3) be careful of special cases you are supposed to handle them properly
			*  4) create a new matrix to hold the data
			*  5) copy the data over
		*/
	 this.data = d;
	 this.numRows = d.length;
	 this.numColumns = d[0].length;
	 


	}	
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
      		
		/* TODO: Lab part 1
		 	* replace the below return statement with the correct code, 
			* you must return a String that represents this matrix, as 
			* specified in the instruction for M1
			* anything else IS NOT acceptable
		 */


   int jdex;
   int index;
   String myString = "";
   for(index = 0; index <= this.numRows -1; index++){

      for (jdex = 0; jdex <= this.numColumns- 1;jdex++){
      myString +=data[index][jdex] + " "; 


      }// end of inner loop
    myString += "\n"; 
    



   }// end of outer for loop
		return myString; // placeholder		
	}
	
	/**
	 * @Override
	 * This method overrides the `equals` method of the `Object` class.
	 * 
	 * Compares this Matrix to another Object for equality. If the Object 
	 * is not an instance of the Matrix class, the method returns false. 
	 * If it is a Matrix, the method checks whether the two matrices have 
	 * the same dimensions and elements in the same order.
	 *
	 * @param o The Object to compare to this Matrix.
	 * @return true if the input Object is a Matrix with the same dimensions 
	 *         and elements as this Matrix; false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix) o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		/* TODO: Assignment part 1
			* Replace the below return statement with the correct code.
			* You must return the correct value after determining if 
			* this matrix is equal to the input matrix.
			* 
			* 
		*/
		if(this.numColumns != m.numColumns || this.numRows != m.numRows) {
			return false;
		}
		int index;
		int jdex;
		for(index = 0; index < this.numRows; index++) {
			for (jdex = 0; jdex < this.numColumns;jdex ++) {
				if (m.data[index][jdex] != this.data[index][jdex]) {
					return false;
				}
				
			}// end of innfer
		}// end of outer
		return true; // placeholder
	}// end of 

	/**
	 * Computes the transpose of this Matrix.
	 * 
	 * This method creates a new Matrix that is the transpose of this Matrix.
	 * The transpose of a matrix is obtained by flipping the matrix over its diagonal, 
	 * switching the row and column indices of the matrix.
	 *
	 * @return A new Matrix that is the transpose of this Matrix.
	 */
	public Matrix transpose() {
		
		int index;
		int jdex;
		Matrix resultMatrix = new Matrix(this.numColumns, this.numRows);
		
	
		
		for(index = 0; index < this.numColumns; index++) {
			for(jdex = 0; jdex < this.numRows; jdex++) {
				resultMatrix.data[index][jdex] = this.data[jdex][index];
				//System.out.println(resultMatrix.data[index][jdex]);
				
				
				
				
				
				
			}// end of the inner loop 
			
			
			
		}// end of the outer loop
		
		/* TODO: Assigment Part 2
		* Replace the below return statement with the correct code.
		* Implement the logic to compute the transpose of this matrix.
		*/
		return resultMatrix;
		
		
		
	}

	/**
	 * Adds this Matrix to another Matrix.
	 * 
	 * This method checks if the two matrices are compatible for addition, i.e., 
	 * they have the same dimensions. If they are not compatible, the method returns null. 
	 * If they are compatible, the method computes the sum of the two matrices and returns 
	 * the resulting Matrix.
	 *
	 * @param m The Matrix to add to this Matrix.
	 * @return A new Matrix that is the sum of this Matrix and the input Matrix, or 
	 *         null if the matrices are not compatible for addition.
	 */
	public Matrix add(Matrix m) {
		/* TODO: Assignment part 3
			* Replace the below return statement with the correct code.
			* This function must check if the two matrices are compatible for addition.
			* If not, return null. If they are compatible, create a new matrix and fill it in with
			* the correct values for matrix addition.
		*/
		if(this.numColumns != m.numColumns || this.numRows != m.numRows) {
			return null;
		}
		
		Matrix returnMatrix = new Matrix(this.numRows, this.numColumns);
		
		int index, jdex;
		for (index = 0; index < this.numRows; index++) {
			
			for(jdex = 0; jdex < this.numColumns; jdex++) {
				
				returnMatrix.data[index][jdex] = this.data[index][jdex] + m.data[index][jdex];
				
				
				
				
				
			}// end of inner loop
			
		}// end of outer loop
		
		return returnMatrix; // placeholder
	}

	/**
	 * Multiplies this Matrix by another Matrix.
	 * 
	 * This method checks if the two matrices are compatible for multiplication, i.e., 
	 * the number of columns in this matrix is equal to the number of rows in the input Matrix.
	 * If they are not compatible, the method returns null. If they are compatible, the method 
	 * computes the product of the two matrices and returns the resulting Matrix.
	 *
	 * @param m The Matrix to multiply with this Matrix.
	 * @return A new Matrix that is the product of this Matrix and the input Matrix, or 
	 *         null if the matrices are not compatible for multiplication.
	 */
	public Matrix mult(Matrix m) {
		/* TODO: Assignment part 4
			* Replace the below return statement with the correct code.
			* This function must check if the two matrices are compatible for multiplication.
			* If not, return null. If they are compatible, determine the dimensions of 
			* the resulting matrix and fill it in with the correct values for matrix multiplication.
		*/
		
		
		int index, jdex, kdex;
		if (this.numColumns != m.numRows) {
			System.out.println("This is not possible");
			return null;
		}
		Matrix returnMatrix = new Matrix(this.numRows, m.numColumns);
		
		for (index  = 0; index < this.numRows; index++) {
			for (jdex = 0; jdex < m.numColumns; jdex++) {
				for(kdex = 0; kdex < m.numRows; kdex ++) {
					returnMatrix.data[index][jdex] += this.data[index][kdex] * m.data[kdex][jdex];
				}
			}
		}
		return returnMatrix;
		
	}
	


}

