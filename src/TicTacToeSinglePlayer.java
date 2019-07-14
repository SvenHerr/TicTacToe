import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeSinglePlayer 
{
	static String[][] arr = new String[3][3];
	final static String gewonnenMeldug = "Gewonnen";
	final static String keinUndoMoeglich = "kein undo mehr möglich";
	final static String anfangsMeldung = "Bitte geben Sie eine Zahl von 1 bis 9 ein oder 'u' für undo";
	final static String hinweis = "Bitte nur Zahlen von 0 bis 2 eingeben oder 'u' für undo";
	final static int noValue = -1;
	final static String unAvailable = "x";
	final static String available = "o";
	final static int maxMoves = 3;
	final static String undoSign = "u";
	static int fieldNr = noValue;
	static String xx = "";
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
			try 
			{
				fieldNr = scan.nextInt();
				input(fieldNr, unAvailable);		
			}
			catch(InputMismatchException ie) 
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
						input(fieldNr, available);
					}	
				}
				else 
				{
					System.out.println(hinweis);
				}
				fieldNr = noValue;
			}
			printArray();
		}
		scan.close();
		
		checkIfPlayerWinns();
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
	
	public static void checkIfPlayerWinns() 
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
					return;
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
						return;
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
						return;
					}	
				}
			}
			count = 0;
		}
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
