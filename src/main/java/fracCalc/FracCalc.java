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

//		// Separates the first operand
//		second = input.indexOf(" ");
//		operand1 = input.substring(first, second);
//		input = input.substring(second + 1);
//		// Finds and separates the operator
//		second = input.indexOf(" ");
//		operator = input.substring(first, second);
//		input = input.substring(second + 1);
//		// separates the last operand which should just be the rest of the input
//		operand2 = input;
		int index = input.indexOf(" ");
		operand1 = input.substring(0, index);
		operator = input.substring((index + 1), (index + 2));
		operand2 = input.substring(index + 3);

		int num1;
		int denom1;
		int whole1;
		int under1 = operand1.indexOf("_");
		int slash1 = operand1.indexOf("/");
		int num2;
		int denom2;
		int whole2;
		int under2 = operand2.indexOf("_");
		int slash2;
		slash2 = operand2.indexOf("/");
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
int underscore2 = operand2.indexOf("_");
slash2 = operand2.indexOf("/");

if (underscore2 > 0) {
            whole2 = Integer.parseInt(operand2.substring(0, underscore2));
            if (slash2 > 0) {
                           num2 = Integer.parseInt(operand2.substring(underscore2 + 1, slash2));
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
num1 = num1 + Math.abs(whole1) * denom1;
num2 = num2 + Math.abs(whole2) * denom2;
if (whole1 < 0) {
            num1 *= -1;
}
if (whole2 < 0) {
            num2 *= -1;
}
int numF = 0;
int denomF = 0;
if (operator.equals("+")) {
            numF = (num1 * denom2) + (num2 * denom1);
            denomF = (denom1 * denom2);
} else if (operator.equals("-")) {
            numF = (num1 * denom2) - (num2 * denom1);
            denomF = (denom1 * denom2);
} else if (operator.equals("*")) {
    numF = (num1 * num2);
    denomF = (denom1 * denom2);
            }
else if (operator.equals("/")) {
            numF = (num1 * denom2);
            denomF = (denom1 * num2);
}

		String result = (numF + "/" + denomF);
		return result;
	}

	// TODO: Implement this function to produce the solution to the input

	public static String fracOne(String x) {
		String operand1 = "";

		int first = 0;
		int second = 0;

		// Separates the first operand
		second = x.indexOf(" ");
		operand1 = x.substring(first, second);
		x = x.substring(second + 1);
		int num1;
		int denom1;
		int under1 = operand1.indexOf("_");
		if (under1 > 0) {
			String whole1 = operand1.substring(0, under1);
			operand1 = operand1.substring(under1 + 1);
			under1 = operand1.indexOf("/");
			num1 = Integer.parseInt(operand1.substring(0, under1));
			denom1 = Integer.parseInt(operand1.substring(under1 + 1));
			String part1 = "whole:" + whole1 + " numerator:" + num1 + " denominator:" + denom1;
			return part1;
		} else {
			under1 = operand1.indexOf("/");
			if (under1 > 0) {
				num1 = Integer.parseInt(operand1.substring(0, under1));
				denom1 = Integer.parseInt(operand1.substring(under1 + 1));
				String part1 = "whole:0" + " numerator:" + num1 + " denominator:" + denom1;
				return part1;
			} else {
				String part1 = "whole:" + operand1 + " numerator:0" + " denominator:1";
				return part1;
			}
		}
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need
	// This method looks for the least common multiple
	public static int lcm(int denom11, int denom12) {
		int gcd = 1;
		for (int w = 1; w <= denom11 && w <= denom12; ++w) {
			if (denom11 % w == 0 && denom12 % w == 0) {
				gcd = w;
			}
		}
		int lcmF = (denom11 / denom12) / gcd;
		return lcmF;
	}
}