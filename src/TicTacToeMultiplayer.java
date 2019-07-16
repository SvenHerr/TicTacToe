import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeMultiplayer extends TicTacToeBase implements TicTacToInterface
{
	final static String fieldPlayer1 = "x";
	final static String fieldPlayer2 = "y";
	static String eingabeValue = "";
	final static int maxMoves = 9;
	static String value = "";
	static int spielernummer = 0;
	
	public static void startProgramm() 
	{
		System.out.println(anfangsMeldung);
		createErklärung();
		printArray();
		createField();
		printArray();
		
		for(int i = 0; i < maxMoves; i++) 
		{
			if(i % 2 == 0) 
			{
				spielernummer = 1;
				System.out.println(spielerAufforderung1);
			}
			else 
			{
				spielernummer = 2;
				System.out.println(spielerAufforderung2);
			}
			//System.out.println("Spieler "+spielernummer+" bitte Zahl eingeben");
			
			try 
			{
				fieldNr = scan.nextLine();
				
				if(fieldNr.equals(undoSign)) 
				{
					if(valueInt == noValue) 
					{
						System.out.println(keinUndoMoeglich);
					}
					else 
					{
						undoPossible = true;
						undo();
						i--;
					}	
					i--;
				}
				else 
				{
					try 
					{
						valueInt = Integer.parseInt(fieldNr);
					}
					catch(NumberFormatException ne) 
					{
						System.out.println(hinweis);
						i--;
					}
				}
				
				if(spielernummer ==1) 
				{
					value = fieldPlayer1;
				}
				else 
				{
					value = fieldPlayer2;
				}
				input(valueInt, value);	
				undoPossible = true;
			}
			catch(FeldIstSchonBelegtException e) 
			{
				i--;
				System.out.println("hier");
			}
			catch(InputMismatchException ie) 
			{
				
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
		int countPlayer1D = 0;
		int countPlayer2D = 0;
		int countPlayer1Z = 0;
		int countPlayer2Z = 0;
		int countPlayer1S = 0;
		int countPlayer2S = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			for(int k = 0; k < arr.length; k++) 
			{
				if(arr[k][k] == fieldPlayer1) 
				{
					countPlayer1D++;
				}
				if(arr[k][k] == fieldPlayer2) 
				{
					countPlayer2D++;
				}
				
				if(arr[i][k] == fieldPlayer1) 
				{
					countPlayer1Z++;
				}
				if(arr[i][k] == fieldPlayer2) 
				{
					countPlayer2Z++;
				}
				
				if(arr[k][i] == fieldPlayer1) 
				{
					countPlayer1S++;
				}
				if(arr[k][i] == fieldPlayer2) 
				{
					countPlayer2S++;
				}
				
				
				if(countPlayer1Z == 3 || countPlayer1S == 3 || countPlayer1D == 3) 
				{
					System.out.println(gewonnenMeldugSpieler1);
					return true;
				}
				if(countPlayer2Z == 3 || countPlayer2S == 3 || countPlayer2D == 3) 
				{
					System.out.println(gewonnenMeldugSpieler2);
					return true;
				}
			}
			countPlayer1Z = 0;
			countPlayer2Z = 0;
			countPlayer1S = 0;
			countPlayer2S = 0;
			countPlayer1D = 0;
			countPlayer2D = 0;
		}

		return false;
	}
}
