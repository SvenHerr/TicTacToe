import java.util.InputMismatchException;

public interface TicTacToInterface 
{
	public static void createErklärung() {}
	
	public static void input(int value, String valueStr) throws InputMismatchException{}
	
	public static void set(int reihe, int spalte, String value) {}
	
	public static boolean checkIfPlayerWinns() 
	{
		return false;
	}
	
	public static void printArray() {	}
	
	public static void createField() {}
	
	public static void startProgramm() {}
	
}
