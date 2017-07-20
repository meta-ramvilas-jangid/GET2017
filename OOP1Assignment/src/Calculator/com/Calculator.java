package Calculator.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Expression;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.plaf.PanelUI;

public class Calculator {

	public static void main(String[] arg) {
		Layout calLayout = new Layout();
		calLayout.setVisible(true);
	}
}

class Display {
	// Operation op=new Operation();
	// create JTextFiels
	JTextField jText = new JTextField();

	void setDisplay() {
		jText.setText("" + ExpressionString.expression);
	}
}

abstract class Buttons extends JButton implements ActionListener {
}

class ArithmaticOPerator extends Buttons {

	ArithmaticOPerator(int numbersOfButtons) {
		/**
		 * create arithmaticOperators buttons like bAdd,bSub,bMulti,bDiv add
		 * label to each button as required
		 */
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * when any specific button pressed then add that button label to
		 * expression String;
		 */
     	ExpressionString.expression.append("add specific label");
		Display d = new Display();
		d.setDisplay();
	}
}

class Numbers extends Buttons {
	/**
	 * create numbers buttons from 0 to 9 add label to each button as required
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * when any specific button pressed then add that button label to
		 * expression String;
		 */
		ExpressionString.expression.append("add specific label");
	}
}

class FunctionalOPerator extends Buttons {
	FunctionalOPerator(int numbersOfButtons) {
		/**
		 * create FunctionalOperators buttons like mod,log,i/x add label to each
		 * button as required
		 */
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * when any specific button pressed then add that button label to
		 * expression String;
		 */
		ExpressionString.expression.append("add specific label");
	}
}

class special extends Buttons {
	/**
	 * create special buttons like "." , "00" add label to each button as
	 * required
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * when any specific button pressed then add that button label to
		 * expression String;
		 */
		ExpressionString.expression.append("add specific label");
	}
}

class EvaluateButton extends Buttons {
	JButton bEvaluate = new JButton("=");
	/**
	 * check which button is pressed using (e.getSource==buttonNsme) append
	 * specific value of pressed button to StringBuffor sb when "=" valued
	 * button pressed then create operation object and call
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bEvaluate) {
			new Operation();
		}
	}
}

class Clear extends Buttons {
	// create bClear
	@Override
	public void actionPerformed(ActionEvent e) {
		ExpressionString.expression.replace(0,ExpressionString.expression.length(), "0");
	}
}

class Operation {
	void stringParser() {
		/**
		 * it use the ExpressionString.expression StringBuffer to parse the operation using stack
		 * and update String buffer to output of String parsing
  		 */
		ExpressionString.expression.replace(0,ExpressionString.expression.length(), "output of String parser");	
	}
}

class Layout extends JFrame {
	Layout() {
		Display d = new Display();
		/**
		 * setTitle default size of windowApp Using specific layout add display
		 * and various buttons like
		 * arithmaticButtons,functionalButton,evaluateButton,clearButton add
		 * WindowAdeptorListner to perform window closing operation
		 */
	}
}