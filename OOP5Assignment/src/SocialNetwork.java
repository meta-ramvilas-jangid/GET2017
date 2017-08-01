import java.util.*;

public class SocialNetwork {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Record record = new Record();
		FileHandling obj = new FileHandling();
		String file = obj.read("Users.txt"); // read all the information of
												// users
		Graph node = new Graph(file);
		file = obj.read("Connection.txt"); // read connections of user
		Connection con = new Connection(file);
		do {
			System.out.println("\n1. Login");
			System.out.println("2. SignUp");
			System.out.println("3. Show Social Network");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			int input = scan.nextInt();
			String name = "", userId = "";
			boolean flag = true;
			switch (input) {
			case 1:
				System.out.println("enter your userID ");
				userId = scan.next();
				while (!node.checkNode(userId)) { // check if user exist in
													// social network
					System.out.println("enter a valid userID ");
					userId = scan.next();
				}
				System.out.println("Welcome !! " + node.printName(userId));
				do {
					System.out.println("\n1. Edit profile");
					System.out.println("2. Delete profile");
					System.out.println("3. Add Record");
					System.out.println("4. Delete Record");
					System.out.println("5. Show Records");
					System.out.println("6. Add connection");
					System.out.println("7. Delete connection");
					System.out.println("8. Show profile");
					System.out.println("9. Back");
					input = scan.nextInt();
					switch (input) {
					case 1:
						System.out.println("Edit your name");
						name = new Scanner(System.in).nextLine();
						node.editNode(userId, name);
						break;
					case 2:
						node.deleteNode(userId);
						flag = false;
						break;
					case 3:
						System.out.println("Add id of your record");
						String recordId = new Scanner(System.in).nextLine();
						System.out.println("Add title of your record");
						name = new Scanner(System.in).nextLine();
						System.out.println("Add content of record");
						String content = new Scanner(System.in).nextLine();
						record.createRecord(recordId, userId, content, name);
						break;
					case 4:
						System.out
								.println("Enter id of record you want to delete");
						recordId = new Scanner(System.in).nextLine();
						record.deleteRecord(recordId, userId);
						break;
					case 5:
						record.printRecords(userId);
						break;
					case 6:
						System.out
								.println("Enter id of the connection you want to add as a friend");
						String friendId = new Scanner(System.in).nextLine();;
						if (node.checkNode(friendId)) {
							con.addConnection(friendId, userId);
						} else {
							System.out.println("User Id does not exist");
						}
						break;
					case 7:
						System.out
								.println("Enter id of the connection you want to remove as a friend");
						friendId = new Scanner(System.in).nextLine();;
						if (node.checkNode(friendId)) {
							con.removeConnection(friendId, userId);
						} else {
							System.out.println("User Id does not exist");
						}
						break;
					case 8:
						System.out.println("User ID : " + userId);
						System.out.println("Name : " + node.printName(userId));
						record.printRecords(userId);
						con.printConnections(userId);
						break;
					case 9:
						flag = false;
						break;
					}
				} while (flag);
				break;
			case 2:
				System.out.println("1. Signup as User");
				System.out.println("2. SignUp as Organization");
				input = scan.nextInt();
				switch (input) {
				case 1:
					System.out.println("enter your name ");
					name = new Scanner(System.in).nextLine();;
					System.out.println("enter a userID ");
					userId = new Scanner(System.in).nextLine();;
					if (node.checkNode(userId)) {
						System.out.println("User Already exist");
					} else {
						node.createNode(new User(), name, userId);
					}
					break;
				case 2:
					System.out.println("enter name of organization ");
					name = new Scanner(System.in).nextLine();;
					System.out.println("enter a userID ");
					userId = new Scanner(System.in).nextLine();;
					if (node.checkNode(userId)) {
						System.out.println("User Already exist");
					} else {
						node.createNode(new Organization(), name, userId);
					}
					break;
				}
				break;
			case 3:
				con.printNetwork();
				break;
			case 4:
				System.exit(0);
			}
		} while (true);
	}
}
