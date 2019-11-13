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
		while(input != "quit") {
			
		System.out.print("Calculate: ");
		input = userInput.nextLine();		
		answer = produceAnswer(input);
		System.out.println("Answer: " + answer);
		System.out.println("");
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
		String operand2 = "";
		String operator = "";

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

		// TODO: Implement this function to produce the solution to the input

		return operand2;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
