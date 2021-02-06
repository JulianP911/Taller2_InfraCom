package uniandes.infracomp.Pasarela;

/**
 * Clase persona
 * @author Julian Padilla Molina
 */
public class Persona extends Thread
{
	/**
	 * Identificador númerico de la persona
	 */
	@SuppressWarnings("unused")
	private int identificadorPersona;
	
	/**
	 * Dirección de la persona
	 */
	private int direccionPersona;
	
	/**
	 * Pasarela
	 */
	private static Pasarela pasarela;
	
	/**
	 * Metodo constructor
	 * @param pIdentificadorPersona - Identifcador de la persona
	 * @param pDireccion - Dirección
	 */
	public Persona(int pIdentificadorPersona, int pDireccion)
	{
		this.direccionPersona = pDireccion;
		this.identificadorPersona = pIdentificadorPersona;
	}
	
	/**
	 * Metodo Run
	 */
	public void run()
	{
		pasarela.entrar(direccionPersona);
		pasarela.caminar();
		pasarela.salir();
	}
	
	/**
	 * Metodo principal
	 * @param args - Parametros
	 */
	public static void main(String args[])
	{
        pasarela = new Pasarela();
		
		for (int i = 0; i < 20; i++) 
		{
			new Persona(i,(int)(Math.random()*2)).start();
		}	
	}
}
