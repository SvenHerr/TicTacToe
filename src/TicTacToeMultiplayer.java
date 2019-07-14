import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeMultiplayer 
{
	static String[][] arr = new String[3][3];
	final static String gewonnenMeldugSpieler1 = "Spieler 1 hat Gewonnen";
	final static String gewonnenMeldugSpieler2 = "Spieler 2 hat Gewonnen";
	final static String keinUndoMoeglich = "kein undo mehr möglich";
	final static String anfangsMeldung = "Bitte geben Sie eine Zahl von 1 bis 9 ein oder 'u' für undo";
	final static String hinweis = "Bitte nur Zahlen von 0 bis 2 eingeben oder 'u' für undo";
	final static int noValue = -1;
	final static String fieldPlayer1 = "x";
	final static String fieldPlayer2 = "y";
	final static String available = "o";
	final static int maxMoves = 9;
	final static String undoSign = "u";
	static int fieldNr = noValue;
	static String eingabeValue = "";
	static Scanner scan = new Scanner(System.in);
	
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
				}else 
				{
					value = fieldPlayer2;
				}
				input(fieldNr, value);	
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
						input(fieldNr, available);
						i--;
					}	
					fieldNr = noValue;
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
	
	public static void createErklärung() 
	{
		int count = 1;
		for(int i = 0; i < arr.length; i++) 
		{
			for(int k = 0; k < arr.length; k++) 
			{
				arr[i][k] = String.valueOf(count);
				count++;
			}	
		}
	}
	
	public static void input(int value, String valueStr) throws InputMismatchException
	{
		switch(value) 
		{
			case 1: set(0,0,valueStr);
			break;
			case 2: set(0,1,valueStr);
			break;
			case 3: set(0,2,valueStr);
			break;
			case 4: set(1,0,valueStr);
			break;
			case 5: set(1,1,valueStr);
			break;
			case 6: set(1,2,valueStr);
			break;
			case 7: set(2,0,valueStr);
			break;
			case 8: set(2,1,valueStr);
			break;
			case 9: set(2,2,valueStr);
			break;
			default: throw new InputMismatchException();
		}
	}
	public static void set(int reihe, int spalte, String value) 
	{
		arr[reihe][spalte] = value;
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
	
	public static void printArray() 
	{
		for(int i = 0; i < arr.length; i++) 
		{	
			for(int k = 0; k < arr.length; k++) 
			{
				System.out.print(arr[i][k]);
				if(k < arr.length-1) 
				{
					System.out.print("|");
				}	
			}	
			if( i < arr.length-1) 
			{
				System.out.println("\n" + "-----");
			}	
		}	
		System.out.println();
		System.out.println();
	}
	
	public static void createField() 
	{
		for(int i = 0; i < arr.length; i++) 
		{
			for(int k = 0; k < arr.length; k++) 
			{
				arr[i][k] = available;
			}	
		}	
	}
}
