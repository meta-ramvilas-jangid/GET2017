package Assignment1;

import java.io.IOException;

public class InToPost {
	
	private MyStack<String> theStack;
	private String input;
	private String output = "";
	public InToPost(String in) {
		input = in;
		theStack = new MyStack<String>();
   }
   
	public String doTrans() {
		for (int j = 0; j < input.length(); j++) {
			String ch = ""+input.charAt(j);
			switch (ch) {
            	case "+": 
            	case "-":
            		gotOper(ch, 1); 
            		break; 
	            case "*": 
	            case "/":
	               gotOper(ch, 2); 
	               break; 
	            case "(": 
	               theStack.push(ch);
	               break;
	            case ")": 
	               gotParen(ch); 
	               break;
	            default: 
	               output = output + ch; 
	               break;
			}
		}
		
		while (!theStack.list.isEmpty()) {
			output = output + theStack.pop();
		}
		System.out.println(output);
		return output; 
	}
	
	public void gotOper(String opThis, int prec1) {
		while (!theStack.list.isEmpty()) {
			String opTop = theStack.pop();
			if (opTop.equals("(")) {
				theStack.push(opTop);
				break;
			} else {
				int prec2;
				
				if (opTop.equals("+") || opTop.equals("-"))
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) { 
					theStack.push(opTop);
					break;
				} 
				else output = output + opTop;
			}
		}
		theStack.push(opThis);
	}
   
	public void gotParen(String ch) { 
		while (!theStack.list.isEmpty()) {
			String chx = theStack.pop();
			if (chx.equals("(")) 
				break; 
			else output = output + chx; 
		}
	}
	
	public static void main(String[] args) throws IOException {
	      String input = "1+2*4/5-7+3/6";
	      String output;
	      InToPost theTrans = new InToPost(input);
	      output = theTrans.doTrans(); 
	      System.out.println("Postfix is " + output + '\n');
	   }
}
