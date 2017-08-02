package resubmitoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuestionUtility {
	Scanner scan = new Scanner(System.in);
	/**
	 * 
	 * @param filePath
	 * @return a 2D string matrix splitting the file input with ','
	 */

	String ques;
	String name;
	String ans = "";
	static int[] count = new int[5];
	List<Question> l = new ArrayList<Question>();

	public void setName(String name) {
		this.name = name;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public String getName() {
		return name;
	}

	public String getAns() {
		return ans;
	}

	public void read(String filePath) {
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			while (s != null) {
				String answer = askQuestion(s);
				ans = ans + ", " + answer;
				s = br.readLine();
			}
			ans = ans + ".\n";
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

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
			if (index == 1) {
				l.add(new Question(option));
			}
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
			// System.out.println("this is single select question");
			ans.trim();
			int singleOption = Integer.parseInt(ans);

			count[singleOption - 1] = count[singleOption - 1] + 1;

		}
		return ans;
	}

	/**
	 * 
	 * @param question
	 *            asked by servey system
	 * @param al
	 *            list that contain possible answer
	 * @param index
	 *            if index is 4 then qustion is single select of multiple select
	 * @return if valid answer then return answer if not valid then paticipant
	 *         have to retypr the answer
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
				try {
					if (ans.length() < 3 && Integer.parseInt(ans) > 0) {
						validate = true;
					} else {
						System.out.println("Invalid ans pls retype");
					}
				} catch (NumberFormatException e) {
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

	void sort() {
		Iterator<Question> itr = l.iterator();
		Collections.sort(l);
		while (itr.hasNext()) {
			System.out.println("" + itr.next().ques);
		}

	}

}
