package shaffer.j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PriorityStack {

	public static List<Integer> intList = new ArrayList<Integer>();
	public static Stack<Integer> intstack = new Stack<>();

	public static List<Double> doubleList = new ArrayList<Double>();
	public static Stack<Double> doublestack = new Stack<>();

	public static List<String> stringList = new ArrayList<String>();
	public static Stack<String> stringstack = new Stack<>();

	public static void main(String[] args) {
		System.out.println("Welcome to priorty stack!");
		MainMenu();
	}

	public static void MainMenu() {
		Scanner input = new Scanner(System.in);

		do {
			System.out.printf("%n%nMain Menu%n");
			System.out.printf(" 1. Integers%n 2. Doubles%n 3. Strings%n 4. Exit%n");
			System.out.printf("%n%nSelection: ");
			String stackType = input.nextLine();

			switch (stackType) {
			case "1":
				integerStack();
				break;
			case "2":
				doubleStack();
				break;
			case "3":
				stringStack();
				break;
			case "4":
				System.out.println("Good bye");
				System.exit(0);
				break;
			default:
				System.out.println("Oops try again.");
				break;
			}
		} while (true);
	}

	public static void integerStack() {
		System.out.printf("%nIntegers%n%n");
		Scanner intInput = new Scanner(System.in);
		String intRegex = "\\d+";
		String input;
		int number = 0;
		boolean loop = true;

		do {
			System.out.print("Enter an integer or \".\" to exit.");
			input = intInput.nextLine();

			if (input.matches(intRegex)) {
				number = Integer.parseInt(input);
				intList.add(number);
			} else if (input.equals(".")) {
				loop = false;
			} else {
				System.out.println("Not an integer, try again.");
			}
		} while (loop);

		Collections.sort(intList);
		Collections.reverse(intList);

		pushStack(intstack, intList);
		popStack(intstack);
	}

	public static void doubleStack() {
		System.out.printf("%nDoubles%n%n");
		Scanner doubleInput = new Scanner(System.in);
		String doubleRegex = "[0-9]{1,13}(\\.[0-9]*)?";
		String input;
		double number = 0.0;
		boolean loop = true;

		do {
			System.out.print("Enter a double or \".\" to exit.");
			input = doubleInput.nextLine();

			if (input.matches(doubleRegex)) {
				number = Double.parseDouble(input);
				doubleList.add(number);
			} else if (input.equals(".")) {
				loop = false;
			} else {
				System.out.println("Not a double, try again.");
			}
		} while (loop);

		Collections.sort(doubleList);
		Collections.reverse(doubleList);

		pushStack(doublestack, doubleList);
		popStack(doublestack);
	}

	public static void stringStack() {
		System.out.printf("%nStrings%n%n");
		Scanner stringInput = new Scanner(System.in);
		String input;
		boolean loop = true;

		do {
			System.out.println("Enter a string or \".\" to exit.");
			input = stringInput.nextLine();

			if (input.trim() == null || input.trim().equals("")) {
				System.out.println("Not a string or char, try again.");
			} else if (input.equals(".")) {
				loop = false;
			} else {
				stringList.add(input);
			}
		} while (loop);

		Collections.sort(stringList);
		Collections.reverse(stringList);

		pushStack(stringstack, stringList);
		popStack(stringstack);
	}

	public static <T> void pushStack(Stack<T> stack, List<T> values) {
		for (T value : values) {
			stack.push(value);
		}
	}

	public static <T> void popStack(Stack<T> stack) {
		try {
			T popValue;

			while (true) {
				popValue = stack.pop();
				System.out.printf("%s, ", popValue);
			}
		} catch (EmptyStackException eSE) {
			System.out.println();
		}
	}
}
