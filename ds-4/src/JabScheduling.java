import java.util.Scanner;

public class JabScheduling {
	static Scanner scan = new Scanner(System.in);
	static PriorityQueue pq = new PriorityQueue();

	public static void main(String[] args) {
		boolean flag = true;
		do {
			System.out.println("\nPriority Queue Operations\n");
			System.out.println("1. insert");
			System.out.println("2. remove");
			System.out.println("3. check empty");
			System.out.println("4. give size ");
			System.out.println("5. clear");
			System.out.println("6. size");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				new JabScheduling().options();
				break;
			case 2:
				System.out.println("\nJob removed \n\n" + pq.remove());
				break;
			case 3:
				System.out.println("\nEmpty Status : " + pq.isEmpty());
				break;
			case 4:
				System.out.println("New Capacity Status : "
						+ pq.increaseCapacity());
				break;
			case 5:
				System.out.println("\nPriority Queue Cleared");
				pq.clear();
				break;
			case 6:
				System.out.println("\nSize = " + pq.size());
				break;
			case 7:
				flag = false;
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
		} while (flag);
	}

	private void options() {
		boolean flag = true;
		do {
			System.out.println("\nSelect Profile\n");
			System.out.println("1. Chair");
			System.out.println("2. Professor");
			System.out.println("3. Graduate Students");
			System.out.println("4. Undergraduate Students");
			System.out.println("5. exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				pq.insert("Chair", 4);
				break;
			case 2:
				pq.insert("Professor", 3);
				break;
			case 3:
				pq.insert("Graduate Students", 2);
				break;
			case 4:
				pq.insert("Undergraduate Students", 1);
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
		} while (flag);
	}
}