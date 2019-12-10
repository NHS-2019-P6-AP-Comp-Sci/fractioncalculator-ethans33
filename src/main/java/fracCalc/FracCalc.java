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
			// System.out.println("Answer: " + answer);
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

		
		int num1;
		int denom1;
		int whole1;
		int under1 = operand1.indexOf("_");
		int slash1 = operand1.indexOf("/");
		int num2;
		int denom2;
		int whole2;
		int slash2;
		slash2 = operand2.indexOf("/");
		//Parsing the first operand
		if (under1 > 0) {
			whole1 = Integer.parseInt(operand1.substring(0, under1));
			if (slash1 > 0) {
				num1 = Integer.parseInt(operand1.substring(under1 + 1, slash1));
				denom1 = Integer.parseInt(operand1.substring(slash1 + 1));
			} else {
				num1 = 0;
				denom1 = 1;
			}
		} else {
			if (slash1 > 0) {
				whole1 = 0;
				num1 = Integer.parseInt(operand1.substring(0, slash1));
				denom1 = Integer.parseInt(operand1.substring(slash1 + 1));
			} else {
				whole1 = Integer.parseInt(operand1.substring(0));
				num1 = 0;
				denom1 = 1;
			}
		}
		//Parsing the second operand
		int under2 = operand2.indexOf("_");
		if (under2 > 0) {
			whole2 = Integer.parseInt(operand2.substring(0, under2));
			if (slash2 > 0) {
				num2 = Integer.parseInt(operand2.substring(under2 + 1, slash2));
				denom2 = Integer.parseInt(operand2.substring(slash2 + 1));
			} else {
				num2 = 0;
				denom2 = 1;
			}
		} else {
			if (slash2 > 0) {
				whole2 = 0;
				num2 = Integer.parseInt(operand2.substring(0, slash2));
				denom2 = Integer.parseInt(operand2.substring(slash2 + 1));
			} else {
				whole2 = Integer.parseInt(operand2.substring(0));
				num2 = 0;
				denom2 = 1;
			}
		}
		// Converts into a mixed fraction
		num1 = num1 + Math.abs(whole1) * denom1;
		num2 = num2 + Math.abs(whole2) * denom2;
		if (whole1 < 0) {
			num1 *= -1;
		}
		if (whole2 < 0) {
			num2 *= -1;
		}
		// Declared to find the final numerator and denominators needed
		int numF = 0;
		int denomF = 0;
		// Addition operator function
		if (operator.equals("+")) {
			numF = (num1 * denom2) + (num2 * denom1);
			denomF = (denom1 * denom2);
		}
		// Subtraction operator function
		else if (operator.equals("-")) {
			numF = (num1 * denom2) - (num2 * denom1);
			denomF = (denom1 * denom2);
		}
		// Multiplication operator function
		else if (operator.equals("*")) {
			numF = (num1 * num2);
			denomF = (denom1 * denom2);
		// Division operator function
		} else if (operator.equals("/")) {
			numF = (num1 * denom2);
			denomF = (denom1 * num2);		
			if(num2 == 0) {
				return "ERROR: Cannot divide by 0";
			}
		}
		//Error handling
		if(denom1 == 0 || denom2 == 0) {
			return "ERROR: Cannot divide by zero.";
		}
		if(operator.length() > 1) {
			return "ERROR: Input is in an invalid format.";
		}
		//If denominator is negative, changes the numerator to 
		//negative instead
		if (denomF < 0 && numF > 0) {
			denomF *= -1;
			numF *= -1;
		}
		//Declares an integer to make back into a mixed fraction
		int wholeF = 0;
		//Used to make into a mixed fraction if numerator is positive
		while (numF / denomF >= 1) {
			numF -= denomF;
			wholeF += 1;
		}
		//Used to make into a mixed fraction if numerator is negative
		while (numF / denomF <= -1) {
			numF += denomF;
			wholeF -= 1;
		}
		//Makes both numerator and denominator positive for when there
		//is a whole number so that the whole number becomes neg/pos
		if (wholeF != 0) {
			numF = Math.abs(numF);
			denomF = Math.abs(denomF);
		}
		// Finds the greatest common denominator
		int gcd = 1;
		for (int i = 1; i <= Math.abs(numF) && i <= Math.abs(denomF); i++) {
			if (numF % i == 0 && denomF % i == 0)
				gcd = i;
		}
		numF /= gcd;
		denomF /= gcd;

		// Returns the final equation
		if (wholeF == 0) {
			if (numF == 0) {
				return "0";
			} else {
				return numF + "/" + denomF;
			}
		} else if (numF == 0 || denomF == 1) {
			return wholeF + "";
		} else {
			return wholeF + "_" + numF + "/" + denomF;
		}
	}

	// TODO: Implement this function to produce the solution to the input

	// TODO: Fill in the space below with any helper methods that you think you will
	// need
}