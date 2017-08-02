package resubmitoop;

/**
 * Question class to read operation
 * write operation and send the input to the Survey
 */
import java.io.*;
import java.util.*;

public class Question extends QuestionUtility implements Comparable<Question> {
    
    public Question(String ques){
    	this.ques=ques;
    }
	
    /**
	 * overriding the Comparable interface
	 */
	@Override
	public int compareTo(Question o) {
		// TODO Auto-generated method stub					
		String str1 = ques; 
		String str2 = o.ques;
		return str1.compareTo(str2);
	}
	
}