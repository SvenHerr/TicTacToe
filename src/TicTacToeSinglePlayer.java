import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeSinglePlayer extends TicTacToeBase implements TicTacToInterface
{
	public static void startProgramm() 
	{	
		System.out.println(anfangsMeldung);
		createErklärung();
		printArray();
		createField();
		printArray();
		
		for(int i = 0; i < maxMoves; i++) 
		{
			try 
			{
				fieldNr = scan.nextInt();
				input(fieldNr, unAvailable);		
			}
			catch(Exception e) 
			{
				xx = scan.nextLine();
				i--;
				
				if(xx.equals(undoSign)) 
				{
					if(fieldNr == -1) 
					{
						System.out.println(keinUndoMoeglich);
					}else 
					{
						try 
						{
							input(fieldNr, available);
						} 
						catch (InputMismatchException e1) 
						{
							e1.printStackTrace();
						} 
						catch (FeldIstSchonBelegtException e1) 
						{
							e1.printStackTrace();
						}
						fieldNr = noValue;
						i--;
					}	
				}
				else 
				{
					System.out.println(hinweis);
				}
			}
			printArray();
			
			if(checkIfPlayerWinns()) 
			{
				break;
			}
		}
		scan.close();
	}
	
	public static boolean checkIfPlayerWinns() 
	{
		// Diagonal
		int count = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			if(arr[i][i] == unAvailable) 
			{
				count++;
					
				if(count == 3) 
				{
					System.out.println(gewonnenMeldug);
					return true;
				}	
			}
		}
		
		// Reihe
		count = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			for(int k = 0; k < arr.length; k++) 
			{
				if(arr[i][k] == unAvailable) 
				{
					count++;
					
					if(count == 3) 
					{
						System.out.println(gewonnenMeldug);
						return true;
					}	
				}
			}
			count = 0;
		}
		
		// Spalte
		count = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			for(int k = 0; k < arr.length; k++) 
			{
				if(arr[k][i] == unAvailable) 
				{
					count++;
					
					if(count == 3) 
					{
						System.out.println(gewonnenMeldug);
						return true;
					}	
				}
			}
			count = 0;
		}
		return false;
	}
}
