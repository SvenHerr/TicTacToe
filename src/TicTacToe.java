import java.util.Scanner;

public class TicTacToe 
{
	static String[][] arr = new String[3][3];
	final static String gewonnenMeldug = "Gewonnen";
	
	public static void main(String[]args) 
	{
		int reihe = 0;
		int spalte = 0;
		createField();
		printArray();
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) 
		{
			try 
			{
				reihe = scan.nextInt();
				spalte = scan.nextInt();
				
				set(reihe,spalte);
			}
			catch(Exception e) 
			{
				i--;
				System.out.println("Bitte nur Zahlen von 0 bis 2 eingeben");
			}
			printArray();
		}
		scan.close();
		
		checkIfPlayerWinns();
	}
	
	public static void checkIfPlayerWinnsDiagonal() 
	{
		if(arr[0][0] == "x" && arr[1][1] == "x" && arr[2][2] == "x") 
		{
			System.out.println(gewonnenMeldug);
		}
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
	
	public static void set(int reihe, int zeile) 
	{
		arr[reihe][zeile] = "x";
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
