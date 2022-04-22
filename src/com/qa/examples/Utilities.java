package com.qa.examples;

import java.util.Scanner;

public class Utilities {
	static Scanner input;
	public Utilities() {
		input = new Scanner(System.in);
	}
	
	public static String getInput(String message) {
		System.out.print(message);
		String output = input.nextLine();

		return output;
	}

	public static int getInputInt(String message) {
		Boolean flag = true;
		int o = 0;

		while (flag) {

			System.out.print(message);
			String output = input.nextLine();

			try {
				o = Integer.parseInt(output);
				flag = false;
			} catch (Exception e) {
				o = getInputInt("Please enter an integer: ");
			}
		}
		return o;
	}

	public static Double getInputDouble(String message) {
		Boolean flag = true;
		Double o = 0.0d;

		while (flag) {
			System.out.print(message);
			String output = input.nextLine();
			try {
				o = Double.parseDouble(output);
				flag = false;
			} catch (Exception e) {
				o = getInputDouble("Please enter an integer.\n");
			}
		}
		return o;
	}

	public static Boolean getInputBoolean(String message) {
		Boolean flag = true;
		Boolean o = true;

		while (flag) {
			System.out.print(message);
			String output = input.nextLine();
			input.nextLine();

			if (output.equalsIgnoreCase("t") || output.equalsIgnoreCase("true")) {
				o = Boolean.parseBoolean("true");
				flag = false;
			} else if (output.equalsIgnoreCase("f") || output.equalsIgnoreCase("false")) {
				o = Boolean.parseBoolean("false");
				flag = false;
			} else {
				System.out.println("Please enter a boolean.\n");
			}
		}
		return o;
	}
	
	public static void closeScanner() {
		input.close();
	}

	public static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
