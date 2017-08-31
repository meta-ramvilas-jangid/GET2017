import java.util.Scanner;

public class Input {
	public static int[] getInput(Scanner sc, int length) {

		int arrayInput[] = new int[length];
		for (int index = 0; index < arrayInput.length; index++) {
			System.out.print("Enter element " + (index + 1) + " :");
			arrayInput[index] = sc.nextInt();
		}
		return arrayInput;

	}

	public static int getNoOfElements(Scanner sc) {
		System.out.println("enter no of elements of integer array");
		return sc.nextInt();

	}

	public static int getChoice(Scanner sc) {
		return sc.nextInt();
	}

}