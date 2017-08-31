import java.util.Scanner;

public class SortMenu {
	static Scanner keyboard;

	public static void showMenu() {
		boolean flag = true;
		do {
			keyboard = new Scanner(System.in);
			System.out.println("select the sorting type");
			System.out.println("1. Comparison Based Sorting");
			System.out.println("2. Linear Sorting");
			System.out.println("3. Exit");
			switch (keyboard.nextInt()) {
			case 1:
				showMenu(1);
				break;
			case 2:
				showMenu(2);
				break;
			case 3:
				System.exit(0);

			default:
				System.out.println("Wrong input !! tryAgain");
				flag = false;
				break;

			}

		} while (!flag);
	}

	public static void showMenu(int type) {
		int noOfElements = Input.getNoOfElements(keyboard);
		if (type == 1) {

			if (noOfElements <= 10 && noOfElements > 0) {
				Output.showOutput(BubbleSort.bubbleSort(Input.getInput(keyboard, noOfElements)));
			} else {
				Output.showOutput(QuickSort.quickSort(Input.getInput(keyboard, noOfElements)));
			}
		} else if (type == 2) {
			int arr[]=Input.getInput(keyboard, noOfElements);
			
			if (SortUtil.getMax(arr,arr.length)>=100) {
				Output.showOutput(RadixSort.radixSort(arr));
			} else {
				Output.showOutput(CountingSort.countingSort(arr));
			}
		}

	}

	
	 
	public static void main(String[] args) {

		SortMenu.showMenu();
	}

}
