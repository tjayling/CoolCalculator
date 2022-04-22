package com.qa.examples;

public class CoolCalc {
	public static double add(double a, double b) {
		return a + b;
	}

	public static double add(double[] nums) {
		return nums[0] + nums[1];
	}

	public static double sub(double a, double b) {
		return a - b;
	}
	
	public static double sub(double[] nums) {
		return nums[0] - nums[1];
	}
	
	public static double mult(double a, double b) {
		return a * b;
	}
	
	public static double mult(double[] nums) {
		return nums[0] * nums[1];
	}
	
	public static double div(double a, double b) {
		return a / b;
	}
	
	public static double div(double[] nums) {
		return nums[0] / nums[1];
	}
}
