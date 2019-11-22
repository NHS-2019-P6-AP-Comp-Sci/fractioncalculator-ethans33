/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String input = " ";
		String answer = " ";

		System.out.print("Calculate: ");
		input = userInput.nextLine();
		while (!input.equalsIgnoreCase("quit")) {

			answer = produceAnswer(input);
			//System.out.println("Answer: " + answer);
			System.out.println(answer);
			System.out.println("");
			System.out.print("Calculate: ");
			input = userInput.nextLine();
		}
		// TODO: Read the input from the user and call produceAnswer with an equation

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// This is to parse each space to individual variables
		String operand1 = "";
		String operator = "";
		String operand2 = "";

		int first = 0;
		int second = 0;

		// Separates the first operand
		second = input.indexOf(" ");
		operand1 = input.substring(first, second);
		input = input.substring(second + 1);
		// Finds and separates the operator
		second = input.indexOf(" ");
		operator = input.substring(first, second);
		input = input.substring(second + 1);
		// separates the last operand which should just be the rest of the input
		operand2 = input;
		System.out.println(input);
		
//		int num1;
//		int denom1;
//		int under1 = operand1.indexOf("_");
//		if(under1 > 0) {
//			String whole1 = operand1.substring(0,under1);
//			operand1 = operand1.substring(under1 + 1);
//			under1 = operand2.indexOf("/");
//			num1 = Integer.parseInt(operand1.substring(0,under1));
//			denom1 = Integer.parseInt(operand1.substring(under1 + 1));
//			String part1 = "whole:" + whole1 + " numerator:" + num1 + " denominator:" + denom1;
//		}
//		else {
//			under1 = operand2.indexOf("/");
//			if (under1 > 0) {
//				num1 = Integer.parseInt(operand1.substring(0, under1));
//				denom1 = Integer.parseInt(operand1.substring(under1 + 1));
//				String part1 = "whole:0" + " numerator:" + num1 + " denominator:" + denom1;
//			}
//			else {
//				String part1 = "whole:" + operand1 + " numerator:0" + " denominator:1";
//			}
		
//		int whole2;
		int num2;
		int denom2;
		int under2 = operand2.indexOf("_");
		if(under2 > 0) {
			String whole2 = operand2.substring(0,under2);
			operand2 = operand2.substring(under2 + 1);
			under2 = operand2.indexOf("/");
			num2 = Integer.parseInt(operand2.substring(0,under2));
			denom2 = Integer.parseInt(operand2.substring(under2 + 1));
			String part2 = "whole:" + whole2 + " numerator:" + num2 + " denominator:" + denom2;
			return part2;
		}
		else {
			under2 = operand2.indexOf("/");
			if (under2 > 0) {
				num2 = Integer.parseInt(operand2.substring(0, under2));
				denom2 = Integer.parseInt(operand2.substring(under2 + 1));
				String part2 = "whole:0" + " numerator:" + num2 + " denominator:" + denom2;
				return part2;
			}
			else {
				String part2 = "whole:" + operand2 + " numerator:0" + " denominator:1";
				return part2;
			}
		}

		// TODO: Implement this function to produce the solution to the input

		//return operand2;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}