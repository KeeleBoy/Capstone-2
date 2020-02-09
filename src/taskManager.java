import java.util.LinkedList;
import java.util.Scanner;

/*
 * 
 * @Author Kyle Warchuck
 * 
 */

public class taskManager {

	public static void main(String[] args) {

		// scanner
		Scanner scnr = new Scanner(System.in);

		// initialize list
		LinkedList<Task> list = new LinkedList<>();

		// initialize list
		Task taskUno = new Task("Jay", "Get food", 111999);
		list.add(taskUno);
		boolean goAgain = true;

		while (goAgain) {

			// basic question
			// System.out.println("");
			System.out.println("Hello user, what would you like me to do?");
			System.out.println("1.List tasks 2.Add task 3.Delete task 4.Mark task complete 5.Exit: ");

			// setting up the choice options
			int choice = scnr.nextInt();
			if (choice == 1) {

				listTasks(list);

			} else if (choice == 2) {
				scnr.nextLine();
				addTask(list, scnr);

			} else if (choice == 3) {
				removeTask(list, scnr);

			} else if (choice == 4) {
				toggleComplete(list, scnr);

			} else if (choice == 5) {
				System.out.println("Are you sure you want to exit y or n:");
				scnr.nextLine();
				String choiceQuit = scnr.nextLine();
				if (choiceQuit.toLowerCase().startsWith("y")) {
					System.out.println("Bye!");
					System.exit(0);
				}

			} else {
				System.out.println("Sorry, I didn't understand that input");
				// System.out.println("Want to try again?");
			}
		}
		// was thinking about setting up the task list here
		// LinkedList<> taskList = new LinkedList<>();

	}

	// first task display the lost of tasks
	public static void listTasks(LinkedList<Task> list) {

		// Task taskUno = new Task("Jay", "Get food", 111999);

		// list.add(taskUno);
		System.out.println("    Name         Description         Due Date      Finished Status");
		System.out.println("==================================================================");
		int z = 1;

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(z + "| %4s %17s %17d %19s", list.get(i).getName(), list.get(i).getDescription(),
					list.get(i).getDueDate(), list.get(i).getComplete());
			System.out.println();
			z++;

		}

	}

	// add task method
	public static void addTask(LinkedList<Task> list, Scanner scnr) {

		System.out.println("You currently have these tasks:");
		listTasks(list);

		// taking the users choices
		System.out.println("Please enter the team member's name: ");
		String name = scnr.nextLine();
//		scnr.nextLine();

//		System.out.println(name);

		// clear scanner

		System.out.println("Please enter the tasks description: ");
		String description = scnr.nextLine();

		System.out.println("Please enter the due date: ");
		int dueDate = scnr.nextInt();

		// attempt to add their decisions to the array
		Task taskList = new Task(name, description, dueDate);
		list.add(taskList);

		// System.out.println(list);

	}

	// remove task method
	public static void removeTask(LinkedList<Task> list, Scanner scnr) {

		System.out.println("You currently have these tasks:");
		listTasks(list);

		System.out.println("Which task would you like to delete? (enter the number)");
		// Scanner scnr = new Scanner(System.in);
		// String removeChoice = scnr.nextLine();
		int removeChoice = (scnr.nextInt());
		if (removeChoice < 0 || removeChoice > list.size()) {
			System.out.println("Sorry, thats not in range");
			removeTask(list, scnr);
		} else {
			System.out.println("    Name         Description         Due Date      Finished Status");
			System.out.println("==================================================================");
			System.out.printf("%7s %19s %17d %19s", list.get(removeChoice - 1).getName(),
					list.get(removeChoice - 1).getDescription(), list.get(removeChoice - 1).getDueDate(),
					list.get(removeChoice - 1).getComplete());

			scnr.nextLine();
			System.out.println("");

			System.out.println("Are you sure you want to delete this selection? y/n:");
			String choiceSure = scnr.nextLine();
			if (choiceSure.toLowerCase().startsWith("y")) {

				// attempt to remove their choice from the linked list
				list.remove(removeChoice - 1);
			}

		}
	}

	// toggle complete
	public static void toggleComplete(LinkedList<Task> list, Scanner scnr) {

		System.out.println("You currently have these tasks:");
		listTasks(list);

		System.out.println("Which task would you like to toggle complete? (enter a number): ");
		int toggleChoice = scnr.nextInt();

		if (toggleChoice < 1 || toggleChoice > list.size()) {
			System.out.println("Sorry, thats not in range");
		} else {

			System.out.println("    Name         Description         Due Date      Finished Status");
			System.out.println("==================================================================");
			System.out.printf("%7s %19s %17d %19s", list.get(toggleChoice - 1).getName(),
					list.get(toggleChoice - 1).getDescription(), list.get(toggleChoice - 1).getDueDate(),
					list.get(toggleChoice - 1).getComplete());

			scnr.nextLine();
			System.out.println("");

			System.out.println("Are you sure you want to toggle this selection complete? y/n:");
			String choiceSure2 = scnr.nextLine();
			if (choiceSure2.toLowerCase().startsWith("y")) {

				list.get(toggleChoice - 1).setComplete("complete");
			}

		}
	}

}
