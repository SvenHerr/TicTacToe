import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe 
{
	static String[][] arr = new String[3][3];
	final static String gewonnenMeldug = "Gewonnen";
	final static String keinUndoMoeglich = "kein undo mehr möglich";
	final static String anfangsMeldung = "Bitte geben Sie eine Zahl von 0 bis 2 ein oder 'u' für undo";
	final static String hinweis = "Bitte nur Zahlen von 0 bis 2 eingeben oder 'u' für undo";
	final static int noValue = -1;
	static int reihe = noValue;
	static int spalte = noValue;
	static String xx = "";
	
	public static void main(String[]args) 
	{
		System.out.println(anfangsMeldung);
		createField();
		printArray();
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) 
		{
			try 
			{
				reihe = scan.nextInt();
				spalte = scan.nextInt();
				
				set(reihe,spalte,"x");
			}
			catch(InputMismatchException ie) 
			{
				xx = scan.nextLine();
				i--;
				
				if(reihe == -1 || spalte == -1) 
				{
					System.out.println(keinUndoMoeglich);
				}
				else 
				{
					if(xx.equals("u")) 
					{
						//undo();
						set(reihe,spalte,"o");
					}
					else 
					{
						System.out.println(hinweis);
					}
					reihe = noValue;
					spalte = noValue;
				}
			}
			printArray();
		}
		scan.close();
		
		checkIfPlayerWinns();
	}
	/*
	public static void undo() 
	{
		arr[reihe][spalte] = "o";
	}*/
	public static void set(int reihe, int spalte, String value) 
	{
		arr[reihe][spalte] = value;
	}
	
	public static void checkIfPlayerWinns() 
	{
		// Diagonal
		int count = 0;
		for(int i = 0; i < 3; i++) 
		{
			if(arr[i][i] == "x") 
			{
				count++;
					
				if(count == 3) 
				{
					System.out.println(gewonnenMeldug);
					return;
				}	
			}
		}
		
		// Reihe und Spalte
		for(int i = 0; i < 3; i++) 
		{
			for(int k = 0; k < 3; k++) 
			{
				if(arr[k][i] == "x") 
				{
					count++;
						
					if(count == 3) 
					{
						System.out.println(gewonnenMeldug);
						return;
					}	
				}
			}
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
	}
	
	public static void createField() 
	{
		for(int i = 0; i < arr.length; i++) 
		{
			for(int k = 0; k < arr.length; k++) 
			{
				arr[i][k] = "o";
			}	
		}	
	}
}
