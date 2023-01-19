/**
 * Plays Greedy Coin game such that the computer never loses.
 * 
 * Nathan Hutton
 */
import java.io.*;
import java.util.Scanner;

public class GreedyCoinGame {
	List list = new LinkedList();
	List red = new LinkedList();
	List blue = new LinkedList();
	int r = 0;
	int b = 0;
	int humanScore = 0;
	int computerScore = 0;
	public GreedyCoinGame(String file) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File(file));

		while (inFile.hasNext()) {
			list.add(inFile.nextInt());
		}

		inFile.close();
		
		for(int i = 0; i < list.getLength(); i++)
		{
			if(i % 2 == 0)
			{
				red.add(list.get(i));
				r += (int)list.get(i);
				continue;
			}
			blue.add(list.get(i));
			b += (int)list.get(i);
		}
	}

	// prints the coins and their position
	public void printCoins() {
		for(int i = 0; i < list.getLength(); i++)
		{
			System.out.print("\t" + list.get(i));
		}
		System.out.println();
		for(int i = 0; i < list.getLength(); i++)
		{
			System.out.print("\t" + i);
		}
		System.out.println();
	}
	
	public void computerChoice()
	{
		if(r > b)
		{
			if(red.contains(list.get(0)))
			{
				System.out.println("Computer chose: " + list.get(0));
				computerScore += (int)list.get(0);
				System.out.println("Computer Score: " + computerScore);
				list.remove(0);
			}
			else if(red.contains(list.getLength() - 1))
			{
				System.out.println("Computer chose: " + list.get(list.getLength() - 1));
				computerScore += (int)list.get(list.getLength() - 1);
				System.out.println("Computer Score: " + computerScore);
				list.remove(list.getLength() - 1);
			}
		}
		if(b > r)
		{
			if(blue.contains(list.get(0)))
			{
				System.out.println("Computer chose: " + list.get(0));
				computerScore += (int)list.get(0);
				System.out.println("Computer Score: " + computerScore);
				list.remove(0);
			}
			else if(blue.contains(list.get(list.getLength() - 1)))
			{
				System.out.println("Computer chose: " + list.get(list.getLength() - 1));
				computerScore += (int)list.get(list.getLength() - 1);
				System.out.println("Computer Score: " + computerScore);
				list.remove(list.getLength() - 1);
			}
		}
	}

	public void playGame() {
				
		System.out.println("Let's play the coin game!");
		while(list.getLength() > 0)
		{
			printCoins();
			computerChoice();
			printCoins();
			
			// get the keyboard for the silly human
			Scanner keyboard = new Scanner(System.in);
						
			System.out.println("\nIndicate the position of the coin you choose: ");
			int humanChoice = keyboard.nextInt();
			while((humanChoice != 0) && (humanChoice != list.getLength() - 1))
			{
				System.out.println("Pick a number you can use: ");
				humanChoice = keyboard.nextInt();
			} 
	
			System.out.println("You chose: " + list.get(humanChoice));
			humanScore += (int)list.get(humanChoice);
			System.out.println("Your Score: " + humanScore);
			list.remove(humanChoice);
		}
		System.out.println("Computer score: " + computerScore);
		System.out.println("You lost, but I'm sure if you try again you'll get it.");
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Provide a file on the command line");
			System.exit(0);
		}

		GreedyCoinGame game = new GreedyCoinGame(args[0]);

		game.playGame();
	}

}
