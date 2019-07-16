import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeBase extends Meldungen implements TicTacToInterface
{
	static String[][] arr = new String[3][3];
	final static int noValue = -1;
	final static String unAvailable = "x";
	final static String available = "o";
	final static int maxMoves = 3;
	final static String undoSign = "u";
	static String fieldNr = null;
	static int valueInt = noValue; 
	static String xx = "";
	static Scanner scan = new Scanner(System.in);
	Language language;
	static boolean undoPossible;
	
	public static void setLanguage() 
	{
		// Schaut sich die eingestellte Sprache vom PC an und setzt sie dementsprechend
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
	
	public static void input(int value, String valueStr) throws InputMismatchException, FeldIstSchonBelegtException
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
	public static void undo() 
	{
		try 
		{
			input(valueInt, available);
		} 
		catch (InputMismatchException e) 
		{
			e.printStackTrace();
		} 
		catch (FeldIstSchonBelegtException e) 
		{
			e.printStackTrace();
		}
		valueInt = noValue;
		undoPossible = false;
	}
	
	public static void set(int reihe, int spalte, String value) throws FeldIstSchonBelegtException
	{
		if(arr[reihe][spalte] != available && !undoPossible) 
		{
			System.out.println("Feld ist schon belegt!");
			return;
		}
		else if(undoPossible)
		{
			arr[reihe][spalte] = value;
		}
		else 
		{
			arr[reihe][spalte] = value;
		}
	}
	
	public static boolean checkIfPlayerWinns() 
	{
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
