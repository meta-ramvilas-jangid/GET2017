import java.util.ArrayList;
import java.util.List;

public class TowersOfHanoi {
	protected List<String> moves;								
	
	//constructor to initialize the list
	public TowersOfHanoi(){												
		moves= new ArrayList<String>();
	}
	
	/*
	 * method to find the move and add it to list 
	 * return the list of moves
	 */
	public List<String> calculateMoves(String start, String destination, String auxiliary, int noOfDisks){
		if(noOfDisks <= 0 || noOfDisks > Integer.MAX_VALUE || start.length() > 1 || destination.length() > 1 || auxiliary.length() > 1){
			throw new IllegalArgumentException();																		
		}else if(noOfDisks==1){																							
			moves.add("move top disk from "+start+" to "+destination);													
		}else{																											
			calculateMoves(start, auxiliary, destination, noOfDisks-1);													
			calculateMoves(start, destination, auxiliary, 1);															
			calculateMoves( auxiliary, destination, start, noOfDisks-1);												
		}
		return moves;																									
		
	}


}
