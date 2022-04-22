package com.qa.examples;

import java.util.Scanner;

public class Utilities {
	public static String getInput(String message) {
		// Initialise scanner object
		Scanner input = new Scanner(System.in);

		System.out.print(message);
		String output = input.nextLine();

		return output;
	}
	
	public static int getInputInt(String message) {
		// Initialise scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.print(message);
		String output = input.nextLine();
		
		int o;
		try {
			o = Integer.parseInt(output);
		} catch(Exception e) {
			o = getInputInt("Please enter an integer: ");
		}
		return o;
	}
	
	public static Double getInputDouble(String message) {
		// Initialise scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.print(message);
		String output = input.nextLine();
		
		Double o;
		try {
			o = Double.parseDouble(output);
		} catch(Exception e) {
			o = getInputDouble("Please enter an integer: ");
		}
		return o;
	}
	
	public static Boolean getInputBoolean(String message) {
		// Initialise scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.print(message);
		String output = input.nextLine();
		input.nextLine();
		
		Boolean o;
		
		if (output.equalsIgnoreCase("t") || output.equalsIgnoreCase("true")) {
			o = Boolean.parseBoolean("true");
		} else if (output.equalsIgnoreCase("f") || output.equalsIgnoreCase("false")) {
			o = Boolean.parseBoolean("false");
		} else {
			o = getInputBoolean("Please enter a boolean: ");
		}
		return o;
	}
	
	public static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void println(String s) {
		System.out.println(s);
	}

	public static void println(int a) {
		System.out.println(a);
	}
}
