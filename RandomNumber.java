import java.util.Random;
import java.util.Scanner;
public class RandomNumber {
	

	public static void main(String[] args) {
		Random rand= new Random();
		int numberguess = rand.nextInt(15) + 1;
		int userGuess = 0;
		int attempted = 0;
		
	
Scanner scanner = new Scanner(System.in);

System.out.println("Random number guessing game! [START]");
System.out.println("thinking of a number b/w 1 to 15. Will you be able to guess ot correctly?");

while(userGuess !=numberguess) {
	System.out.print("Enter your guess number:");
	userGuess = scanner.nextInt();
	attempted++;

	if(userGuess< numberguess) {
		System.out.println("too low! try once more");
	}
	else if (userGuess>numberguess) {
		System.out.println("too high! try once more");
	
	}
	
	else {
		System.out.println("You guessed it correctly");
		
	}
}

scanner.close();}}