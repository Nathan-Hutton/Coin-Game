import java.util.ArrayList;
import java.util.Random;

public class CoinGameTest {
	public static void main(String[] args)
	{
		Random rand = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> red = new ArrayList<Integer>();
		ArrayList<Integer> blue = new ArrayList<Integer>();
		int n = rand.nextInt(10);
		if(n % 2 == 1)
		{
			n++;
		}
		for(int i = 0; i < n; i++)
		{
			int j = rand.nextInt(100);
			list.add(j);
			if(i % 2 == 0)
			{
				red.add(j);
			}
			else
			{
				blue.add(j);
			}
		}
		for(int i = 0; i < n; i++)
		{
			
		}
	}
}
