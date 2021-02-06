package uniandes.infracomp.Pasarela;

public class Pasarela 
{
	private int numPerIzqDer;
	private int numPerDerIzq;
	
	/**
	 * Entrar a la pasarela
	 * @param pDireccion - Direccion (0 izquierdaDerechad y 1 derechaIzquierda)
	 */
	public synchronized void entrar(int pDireccion) 
	{
		if(pDireccion == 0)
		{
			while(numPerDerIzq > 0)
			{
				try 
				{
					wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			numPerIzqDer++;
			System.out.println("Persona entrando de izquierda a derecha");
		}
		else if(pDireccion == 1)
		{
			while(numPerIzqDer > 0)
			{
				try 
				{
					wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			numPerDerIzq++;
			System.out.println("Persona entrando de derecha a izquierda");
		}
	}
	
	/**
	 * Esperar mientras el peaton pasa por la pasarela
	 */
	public synchronized void caminar()
	{
		try
		{
			Thread.sleep(5);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Salir de la pasarela
	 */
	public synchronized void salir()
	{
		if(numPerIzqDer == 0)
		{
			numPerDerIzq--;
			System.out.println("Persona saliendo de la dirección Dercha a Izquierda");
			
			if(numPerDerIzq == 0)
			{
				notifyAll();
			}
			else
			{
				notify();
			}
		}
		else if(numPerDerIzq == 0)
		{
			numPerIzqDer--;
            System.out.println("Persona saliendo de la dirección Izquierda a Derecha");
			
			if(numPerIzqDer == 0)
			{
				notifyAll();
			}
			else
			{
				notify();
			}
		}
	}
}
