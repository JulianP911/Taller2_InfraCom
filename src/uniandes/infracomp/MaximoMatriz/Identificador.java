package uniandes.infracomp.MaximoMatriz;

public class Identificador 
{
	private int numId;
	
	public Identificador() 
	{
		numId = 0;
	}
	
	public synchronized int darNumId() 
	{
		return numId++;
	}
}
