import java.util.Scanner;

public class Main 
{
	public static void main(String[]args) 
	{
		System.out.println("Möchten Sie gegen einen anderen Spieler spielen? Dann bitte Die Zahl 1 eingeben");
		System.out.println("Möchten Sie gegen den Computer spielen? Dann bitte Die Zahl 2 eingeben");
		Scanner scan = new Scanner(System.in);
		int count = 0;
		int anzahlAnVersuchen = 3;
		
		while(count < anzahlAnVersuchen)
		{
			count++;
			
			String inputStr = scan.nextLine();
			
			if(inputStr.equals("1")) 
			{
				startMultiplayer() ;
				break;
			}
			else if(inputStr.equals("2")) 
			{
				startSingleplayer();
				break;
			}
			else if(count < anzahlAnVersuchen)
			{
				System.out.println("Bitte nur die Zahl 1 oder 2 eingeben");
			}
			else 
			{
				System.out.println("Programm wird beendet");
			}	
		}
		scan.close();
	}
	
	public static void startSingleplayer() 
	{
		TicTacToeSinglePlayer.startProgramm();
	}
	
	public static void startMultiplayer() 
	{
		TicTacToeMultiplayer.startProgramm();
	}
}

