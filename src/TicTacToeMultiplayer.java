import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeMultiplayer extends TicTacToeBase implements TicTacToInterface
{
	final static String fieldPlayer1 = "x";
	final static String fieldPlayer2 = "y";
	final static String gewonnenMeldugSpieler1 = "Spieler 1 hat Gewonnen";
	final static String gewonnenMeldugSpieler2 = "Spieler 2 hat Gewonnen";
	static String eingabeValue = "";
	final static int maxMoves = 9;
	
	public static void main(String[]args) 
	{
		System.out.println(anfangsMeldung);
		createErklärung();
		printArray();
		createField();
		printArray();
		
		for(int i = 0; i < maxMoves; i++) 
		{
			int spielernummer = 0;
			if(i % 2 == 0) 
			{
				spielernummer = 1;
			}
			else 
			{
				spielernummer = 2;
			}
			System.out.println("Spieler "+spielernummer+" bitte Zahl eingeben");
			
			try 
			{
				fieldNr = scan.nextInt();
				
				String value = "";
				if(spielernummer ==1) 
				{
					value = fieldPlayer1;
				}
				else 
				{
					value = fieldPlayer2;
				}
				input(fieldNr, value);	
			}
			catch(FeldIstSchonBelegtException e) 
			{
				i--;
				System.out.println("hier");
			}
			catch(InputMismatchException ie) 
			{
				eingabeValue = scan.nextLine();
				i--;
				
				if(eingabeValue.equals(undoSign)) 
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
						catch(Exception e1) 
						{
							e1.printStackTrace();
						}
						i--;
						fieldNr = noValue;
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
		int countPlayer1 = 0;
		int countPlayer2 = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			if(arr[i][i] == fieldPlayer1) 
			{
				countPlayer1++;
			}
			if(arr[i][i] == fieldPlayer2) 
			{
				countPlayer2++;
			}
			
			
			if(countPlayer1 == 3) 
			{
				System.out.println(gewonnenMeldugSpieler1);
				return true;
			}
			if(countPlayer2 == 3) 
			{
				System.out.println(gewonnenMeldugSpieler2);
				return true;
			}
		}
		
		// Zeile
		countPlayer1 = 0;
		countPlayer2 = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			for(int k = 0; k < arr.length; k++) 
			{
				if(arr[i][k] == fieldPlayer1) 
				{
					countPlayer1++;
					
				}
				if(arr[i][k] == fieldPlayer2) 
				{
					countPlayer2++;
				}
				
				
				if(countPlayer1 == 3) 
				{
					System.out.println(gewonnenMeldugSpieler1);
					return true;
				}
				if(countPlayer2 == 3) 
				{
					System.out.println(gewonnenMeldugSpieler2);
					return true;
				}
			}
			countPlayer1 = 0;
			countPlayer2 = 0;
		}
		
		// Spalte
		countPlayer1 = 0;
		countPlayer2 = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			for(int k = 0; k < arr.length; k++) 
			{
				if(arr[k][i] == fieldPlayer1) 
				{
					countPlayer1++;
				}
				if(arr[k][i] == fieldPlayer2) 
				{
					countPlayer2++;
				}
				
				if(countPlayer1 == 3) 
				{
					System.out.println(gewonnenMeldugSpieler1);
					return true;
				}
				if(countPlayer2 == 3) 
				{
					System.out.println(gewonnenMeldugSpieler2);
					return true;
				}
			}
			countPlayer1 = 0;
			countPlayer2 = 0;
		}
		return false;
	}
}
