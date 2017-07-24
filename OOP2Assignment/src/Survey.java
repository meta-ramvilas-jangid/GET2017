import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * this class create two Survey Report
 * according to user's answers
 */
public class Survey {
	static String ans = "";
	String name = "";
	static int[] count = new int[5];

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		char ch = 'y';
		while (ch == 'y') {
			System.out.println("If yout want to take part on survay press y else n (y/n)");
			String cStr = sc.next();
			ch = cStr.charAt(0);
			if (ch == 'y' || ch == 'Y') {
				Survey s = new Survey();
				System.out.print("Enter your name : ");
				s.name = sc1.nextLine();
				s.ans = s.ans + s.name;
				s.takeSurvey();
			}
		}
		Survey.generatereport1();
		Survey.generatereport2();
	}
    /**
    *This fuction open the quetion.txt file and call to askQuestion class
    *askQuestion class return the answer 
    */
	void takeSurvey() {
		try {
			FileReader fr = new FileReader("question.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			while (s != null) {
				String answer = askQuestion(s);
				ans = ans + ", " + answer;
				s = br.readLine();
			}
			ans = ans + ".\n";
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /*
     * this function ask the question to participant and
     * tokenized every question in form of Question no. Qustion,Q.type and option
     * call the validateAnswer class and get return back typed answerd by participant
     * if question type is single select then 
     * then update the count array for generating report2
     */
	String askQuestion(String question) {
		Scanner sc = new Scanner(System.in);
		String describtion[] = { "QuestionNo.", "Question  ", "Q.type     ",
				"Option     " };
		int index = 0;
		String z = new String();
		StringTokenizer stn = new StringTokenizer(question, ".,");
		String option = "";
		while (stn.hasMoreTokens()) {
			option = stn.nextToken();
			System.out.println(describtion[index++] + " : " + option);
		}
		StringTokenizer validToken = new StringTokenizer(option, "(/)");
		ArrayList<String> al = new ArrayList<String>();
		while (validToken.hasMoreTokens()) {
			String choice = validToken.nextToken().trim();
			al.add(choice);
		}
		System.out.print("Your Answer : \n\n");
		String ans = validateAnswer(question, al, index);
		
		if (question.contains("Single Select")) {
			//System.out.println("this is single select question");
			ans.trim();
			int singleOption = Integer.parseInt(ans);

			count[singleOption - 1] = count[singleOption - 1] + 1;

		}
		return ans;
	}
    /**
     * it generate report1
     * participantName,answers of questions in sequence
     */
	static void generatereport1() {
		try {
			FileWriter fw = new FileWriter("report1.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(ans);
			bw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /**
     * generate report2
     * particular single select option is selected by how many participant
     */
	static void generatereport2() {
		try {
			FileWriter fw = new FileWriter("report2.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Overall Rating, Single Select, (1/2/3/4/5)" + "\n");
			double sum = 0;
			for (int index = 0; index < 5; index++) {
				sum = sum + count[index];
		    }
			for (int index = 0; index < 5; index++) {
				bw.write(index + 1 + " - " + (count[index] * 100) / sum + "%"+ "\n");
			}
			bw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /**
     * 
     * @param question asked by servey system
     * @param al list that contain possible answer 
     * @param index if index is 4 then qustion is single select of multiple select
     * @return if valid answer then return answer
     * if not valid then paticipant have to retypr the answer
     */
	String validateAnswer(String question, ArrayList<String> al, int index) {
		Scanner sc = new Scanner(System.in);
		String ans = null;
		boolean validate = false;
		while (!validate) {
			if (question.contains("Single Select") && index == 4) {
				ans = sc.nextLine();
				if (al.contains(ans)) {
					validate = true;
				} else {
					System.out.println("Invalid ans pls retype");
				}
			} else if (question.contains("Multi Select") && index == 4) {
				ans = sc.nextLine();
				StringTokenizer stn = new StringTokenizer(ans, "/");
				while (stn.hasMoreElements()) {
					if (al.contains(stn.nextToken())) {
						validate = true;
					} else {
						validate = false;
						System.out.println("Invalid ans pls retype");
					}
				}
			} else if (question.contains("Number")) {
				ans = sc.nextLine();
				try{
					if (ans.length() < 3 && Integer.parseInt(ans)>0) {
						validate = true;
					} else {
						System.out.println("Invalid ans pls retype");
					}	
				} catch(NumberFormatException e){
					System.out.println("Invalid ans pls retype");
				}
				
			} else if (question.contains("Text")) {
				ans = sc.nextLine();
				validate = true;
			} else {
				System.out.println("Invalid ans pls retype");
			}
		}
		return ans;
	}
}
