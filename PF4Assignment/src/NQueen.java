public class NQueen {
	int slash[][];           // helper matrices 
	int backslash[][];       // helper matrices
	boolean slashLook[];      // array to tell us which slash diagonals are occupied
	boolean backslashLook[];  //arrays to tell us which backslash diagonals are occupied
	boolean colLookup[];      // arrays to tell us which columns are occupied
	/**
	 * constructor initalize helper matrices
	 * only when object create
	 */
	NQueen(int size){
		slash=new int[size][size]; 
	    backslash=new int[size][size];
	    slashLook=new boolean[2*size-1];
	    backslashLook=new boolean[2*size-1];
	    colLookup=new boolean[size]; 
		for (int r=0; r<size; r++){
			  for (int c=0; c<size; c++){
				  slash[r][c] = r + c;
				  backslash[r][c]=r-c+size-1;
			  }
	    }
	}
	/* A Optimized function to check if a queen can be placed on board[row][col] */
	boolean isSafe(int row, int col)
	{
	   if (slashLook[slash[row][col]] || backslashLook[backslash[row][col]] || colLookup[row]){
		   return false;
	   }
	   return true;
	}
	/* It mainly uses isSafe() to solve the problem. It returns false if queens cannot be placed, 
	 * otherwise return true.
	 *there may be more than one solutions, this function prints one of the feasible solutions.
	 */
	boolean solveNQueensUtil(int board[][], int startRow, int dimensionOfMatrix){
		/*If all queens are placed
	    then return true */
		if(startRow>=dimensionOfMatrix){
			for(int y=0;y <dimensionOfMatrix; y++){
				for(int z=0; z<dimensionOfMatrix; z++){
					System.out.print(board[y][z]);
				}
		        System.out.println();
	        }
			System.out.println();
		    return true;
	    }
	    for (int i=0; i<dimensionOfMatrix; i++){
	    	if(isSafe(i,startRow)){      
	    		board[i][startRow] = 1;
	            colLookup[i] = true;
	            slashLook[slash[i][startRow]] = true;
	            backslashLook[backslash[i][startRow]] = true;
                if(solveNQueensUtil(board, startRow + 1, dimensionOfMatrix)){
                	return true;
                }
                /* If placing queen in board[i][col]
                 * doesn't lead to a solution, then backtrack 
                 * Remove queen from board[i][col]
                 */
	            board[i][startRow] = 0;
	            colLookup[i] = false;
	            slashLook[slash[i][startRow]] = false;
	            backslashLook[backslash[i][startRow]] = false;
	        }
	    }
	    return false;
	}
}
