package uniandes.infracomp.MaximoMatriz;

public class Maximo 
{
	private int maximo;
	private int cont;
	private int nThreads;
	
	public Maximo(int numT)
	{
		nThreads = numT;
		maximo = 0;
		cont = 0;
	}
	
	public synchronized boolean anotar(int n)
	{
		if(n > maximo)
		{
			this.maximo = n;
		}
		return (++cont == nThreads) ? true: false;
	}
	
	public synchronized int darMaximo()
	{
		return this.maximo;
	}
}
