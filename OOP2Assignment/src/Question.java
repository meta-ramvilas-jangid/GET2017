import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @author Ram
 * class to sorted questions
 */
class Question implements Comparable<Question> {
	String quesNo = "";
	String question = "";
	String type = "";
	String options = "";
	static List<Question> listOfQuestion;   //list of objects

	Question(String lineOfQuestion) {
		StringTokenizer st = new StringTokenizer(lineOfQuestion, ".,");
		quesNo = st.nextToken().trim();
		question = st.nextToken().trim();
		type = st.nextToken().trim();
		if (st.hasMoreElements()) {
			options = st.nextToken().trim();
		}
	}
    /**
     * inbuild call by Collection.sort();
     * compare two questions and return 1,0,-1 respectively
     */
	@Override
	public int compareTo(Question ques) {
		return question.compareTo(ques.question);
	}

	/**
	 * function for Sorting objects
	 */
	public static void sortQuestions() {
		Collections.sort(listOfQuestion);
	}

	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		listOfQuestion = new ArrayList<Question>();
		FileReader fr;
		try {
			fr = new FileReader("question.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = null;
			while ((s = br.readLine()) != null) {
				ls.add(s);
				System.out.println(s);
			}
			Question[] Q = new Question[ls.size()];
			for (int i = 0; i < ls.size(); i++) {
				Q[i] = new Question(ls.get(i));
				listOfQuestion.add(Q[i]);
			}
			System.out.println("\nThe sorted list of questions is\n");
			Question.sortQuestions();
			for (Question str : listOfQuestion) {
				System.out.println(str.question);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}