package com.qa.examples;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	// DEFINING VARIABLES
	private Boolean running;
	private Boolean runningMenu2;

	private List<String> results;

	// CONSTRUCTOR METHOD
	public Menu() {
		this.init();
	}

	// INITIALISER METHOD
	private void init() {
		running = true;
		results = new ArrayList<String>();
		this.welcome();
	}

	// MAIN RUN METHOD
	public void run() {
		while (running) {
			this.displayMainMenu();
			int menuInput = this.getMenuInput();
			if (menuInput > 0 && menuInput < 5) {
				this.menu1(menuInput);
			} else if (menuInput == 5) {
				this.displayMenu2();
				runningMenu2 = true;
				while (runningMenu2) {
					menuInput = this.getMenuInput();
					this.menu2(menuInput);
				}
			} else {
				System.out.println("Please try again\n");
			}
		}

	}

	// DISPLAY WELCOME MESSAGE METHOD
	private void welcome() {
		System.out.println("\nWelcome to the Cool Calculator!");
	}

	// DISPLAY MENU 1 METHOD
	private void displayMainMenu() {
		System.out.println("=".repeat(13));
		System.out.println("||Main Menu||");
		System.out.println("=".repeat(31));
		System.out.println("||  Option 1: Addition       ||");
		System.out.println("||  Option 2: Subtraction    ||");
		System.out.println("||  Option 3: Multiplication ||");
		System.out.println("||  Option 4: Division       ||");
		System.out.println("||  Option 5: Show more      ||");
		System.out.println("=".repeat(31));
	}

	// DISPLAY MENU 2 METHOD
	private void displayMenu2() {
		System.out.println("=".repeat(16));
		System.out.println("||More Options||");
		System.out.println("=".repeat(31));
		System.out.println("||  Option 1: Show history   ||");
		System.out.println("||  Option 2: Go back        ||");
		System.out.println("||  Option 3: Quit           ||");
		System.out.println("=".repeat(31));
	}

	// RUN MENU 1 METHOD
	private void menu1(int menuInput) {
		double[] nums = this.getDoubles();
		double result;
		String resultStr = "";

		if (nums[0] % 1 == 0) {
			resultStr += (int) nums[0];
		} else {
			resultStr += nums[0];
		}
		
		resultStr += returnOperator(menuInput);
		
		if (nums[1] % 1 == 0) {
			resultStr += (int) nums[1];
		} else {
			resultStr += nums[1];
		}

		resultStr += " = ";

		switch (menuInput) {
		case 1:
			result = CoolCalc.add(nums);
			break;

		case 2:
			result = CoolCalc.sub(nums);
			break;

		case 3:
			result = CoolCalc.mult(nums);
			break;

		case 4:
			result = CoolCalc.div(nums);
			break;
		default:
			result = 0;
		}
		
		if (result % 1 == 0) {
			resultStr += (int) result;
		} else {
			resultStr += result;
		}
		
		this.results.add(resultStr);
		System.out.println("Result:");
		System.out.println(resultStr + "\n");
		Utilities.sleep(1000);
	}

	// RUN MENU 2 METHOD
	private void menu2(int menuInput) {
		switch (menuInput) {
		case 1:
			int i = 1;
			System.out.println("Your calculator history:");
			for (String s : results) {
				System.out.println(i + ". " + s);
				i++;
			}
			Utilities.getInput("Press enter to continue");
			runningMenu2 = false;
			break;
		case 2:
			runningMenu2 = false;
			break;
		case 3:
			System.out.println("Thanks for using the Cool Calculator!");
			Utilities.sleep(500);
			System.out.println("Goodbye");
			runningMenu2 = false;
			running = false;
			break;
		default:
			System.out.println("Please try again\n");
			Utilities.sleep(1000);
			break;
		}
	}

	// GET MENU INPUT METHOD RETURNS A STRING WITH MENU OPTION
	private int getMenuInput() {
		int input = Utilities.getInputInt("Please enter your option: ");
		return input;
	}

	// GET USER INPUTS FOR DOUBLES TO BE OPERATED ON
	private double[] getDoubles() {
		double[] inputs = new double[2];

		inputs[0] = Utilities.getInputDouble("Enter your first number: ");
		inputs[1] = Utilities.getInputDouble("Enter your second number: ");

		return inputs;
	}

	// RETURN A STRING WITH THE OPERATOR IN USE
	private String returnOperator(int i) {
		switch (i) {
		case 1:
			return " + ";
		case 2:
			return " - ";
		case 3:
			return " x ";
		case 4:
			return " ÷ ";
		default:
			return "";
		}
	}
}
