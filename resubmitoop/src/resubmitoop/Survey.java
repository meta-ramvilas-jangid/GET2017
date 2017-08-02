package resubmitoop;

/**
 * Survey class that perform read operation, write operation 
 * calculate percentage distribution
 * reports A and B created
 */
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Survey {

	public static void main(String args[]) {
		Scanner scan = null;
		try {
			QuestionUtility obj = new QuestionUtility();
			scan = new Scanner(System.in);

			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			char ch = 'y';
			while (ch == 'y') {
				System.out
						.println("If yout want to take part on survay press y else n (y/n)");
				String cStr = sc.next();
				ch = cStr.charAt(0);
				if (ch == 'y' || ch == 'Y') {
					Survey s = new Survey();
					System.out.print("Enter your name : ");
					obj.setName(new Scanner(System.in).nextLine());

					String ans = obj.getAns() + obj.getName();
					obj.setAns(ans);
				
					new Survey().takeSurvey(obj);
				}
			}
			generatereport1(obj);
			generatereport2(obj);
			obj.sort();
		} catch (Exception except) {
			scan.close();
		}
	}

	void takeSurvey(QuestionUtility obj) {

		obj.read("abc.txt");
	}

	static void generatereport1(QuestionUtility q) {
		try {
			FileWriter fw = new FileWriter("Report1-A.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(q.getAns());
			bw.flush();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void generatereport2(QuestionUtility q) {
		try {
			FileWriter fw = new FileWriter("report2.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Overall Rating, Single Select, (1/2/3/4/5)" + "\n");
			double sum = 0;
			for (int index = 0; index < 5; index++) {
				sum = sum + q.count[index];
			}
			for (int index = 0; index < 5; index++) {
				bw.write(index + 1 + " - " + (q.count[index] * 100) / sum + "%"
						+ "\n");
			}
			bw.flush();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}