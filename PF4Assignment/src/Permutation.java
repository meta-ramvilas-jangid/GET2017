import java.util.ArrayList;
import java.util.List;
public class Permutation {

	protected List<String> permutations;
	protected int startIndex;
	//constructor to initialize the list
	public Permutation(){
		permutations = new ArrayList<String>();
		startIndex=0;
	}
	/*
	 * method to swap 
	 */
	public void swap(char[] arr, int i, int j){
		char temp ;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	//method to generate the permutation of string
	public List<String> permute(String str){
		if(str.isEmpty()){													
			throw new IllegalArgumentException("String cannot be empty");	
		}else if(str.equals(null)){										
			throw new NullPointerException();								
		}else{																
			char[] charArray = str.toCharArray();							
			int l=startIndex,i;												
			if(l == charArray.length){										 
				if(!(permutations.contains(str))){							
				permutations.add(str);										
				}
			}else{															
				for(i = l; i < charArray.length; i++){						
					swap(charArray, l, i);									
					startIndex++;
					permute(String.valueOf(charArray));						
					swap(charArray, l ,i);									
					startIndex = l;											
				}
			}
		}
		return permutations;												
	}
}
