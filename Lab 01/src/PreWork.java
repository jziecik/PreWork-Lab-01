import java.util.Scanner;

public class PreWork {

	public static void main(String[] args) {
		
		//creates new Scanner object, passing in standard system.in
		Scanner input = new Scanner(System.in);
		
		//output a prompt
		System.out.println("Enter two integers with the same number of digits: ");
		
		//creating an int to capture user input, wait for input
		int value1 = input.nextInt();
		int value2 = input.nextInt();
		
		//CHECK IF INPUT IS OKAY

		//For string input: String line = input.nextLine();
		//For double input: double value = input.nextDouble();

		//output what they entered
		System.out.println("You entered: " + value1 + " and " + value2);
		
		//CHECK IF CORRESPONDING TENS PLACES SUMS EQUAL
		System.out.println(task(value1, value2));
		
		//closes input stream
		input.close();
	}
	
	private static boolean task(int value1, int value2) {
		
		//count how many digits in value1
		int x = value1;
		int count1 = 0;
		while (x != 0) {
			count1++;
			//chops off last digit in number each iteration
			x = x / 10;
		}
		//count how many digits in value2
		int y = value2;
		int count2 = 0;
		while (y != 0) {
			count2++;
			//chops off last digit in number each iteration
			y = y / 10;
		}
		//if either value is 0, this just gives it a digit count of 1
		if (value1 == 0) {
			count1 = 1;
		}
		if (value2 == 0) {
			count2 = 1;
		}
		
		//checks that both integers have the same number of digits
		if (count1 != count2) {
			System.out.println("User input is invalid, both intergers should have the same number of digits");
			return false;
		}
		
		//0 case
		if (value1 == 0 && value2 == 0) {
			return true;
		}
		//one digit case
		if ((count1 == 1) && (count2 == 1)) {
			if (value1 == value2) {
				return true;
			} else {
				return false;
			}
		}
		
		//creating tracker variables
		int lastDigitSum = 0;
		int secondLastSum = 0;
		//repeat as many times as there are digits in the user's integers
		for (int i = 0; i < count1; i++) {

			//last digits sum
			lastDigitSum = (value1 % 10) + (value2 % 10);
			//chop off last digit
			value1 = value1 / 10;
			value2 = value2 / 10;
			//find second last digits sum
			secondLastSum = (value1 % 10) + (value2 % 10);
			//compare last digit with second last
			if (lastDigitSum != secondLastSum) {
				return false;
			}
			//keep track of how many digit sums left to compare
			count2--;
			//if we get here, the last comparison necessary was made and passed
			if (count2 == 1) {
				return true;
			}
		}

		return false;
	}

}
