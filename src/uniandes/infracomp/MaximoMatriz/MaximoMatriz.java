package uniandes.infracomp.MaximoMatriz;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Aplicación multithread para encontrar el elemento mayor de un matriz de enteros
 * Utilizar threads para que de manera concurrente se pueda encontrar el mayor de los elementos de la matriz
 * @author Julian Padilla Molina
 */
public class MaximoMatriz extends Thread
{
	/**
	 * Vamos a generar los numeros aleatorios en un intervalo amplio
	 */
	private final static int INT_MAX =105345;
	
	/**
	 * Matriz
	 */
	private static int[][] mat;
	
	/**
	 * Mayor global
	 */
	private static Maximo mayor;
	
	/**
	 * ID Thread
	 */
	private static Identificador identificador;
	
	/**
	 * Identificador del thread
	 */
	@SuppressWarnings("unused")
	private int idThread;
	
	/**
	 * Constructor de MaximoMatriz
	 * @param pIdThread - ID Thread
	 * @param pFila - Fila a registrar
	 */
	public MaximoMatriz(int pIdThread)
	{
		this.idThread = pIdThread;
	}
	
	/**
	 * Generar la matriz con numeros aleatorios
	 */
	public static void crearMatriz(int n)
	{
		mat = new int [n][n];
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				mat[i][j] = ThreadLocalRandom.current().nextInt(0, INT_MAX);
			}
		}
		
		// Imprimir la matriz
		System.out.println("Matriz:");
		System.out.println("===============================");
		imprimirMatriz();
	}
	
	/**
	 * Imprimir la matriz en consola
	 */
	private static void imprimirMatriz()
	{
		for (int i = 0; i < mat.length; i++) 
		{
			for (int j = 0; j < mat.length; j++) 
			{
				System.out.println(mat[i][j] + "\t");
			}
		}
	}
	
	/**
	 * Metodo run del Thread
	 */
	@Override
	public void run()
	{
		int locMax = 0;
		int id = identificador.darNumId();
		
		for (int j = 0; j < mat[id].length ; j++) 
		{
			if(mat[id][j] > locMax)
			{
				locMax = mat[id][j];
			}
		}
		
		if(mayor.anotar(locMax))
		{
			System.out.println("Max: " + mayor.darMaximo());
		}
	}
	
	/**
	 * Metodo principal del la clase
	 * @param args - Parametros
	 */
	public static void main(String[] args)
	{
		int n = 3;
		System.out.println("Busqueda concurrente por una matriz");
		
		// Iniciar la matriz
		crearMatriz(n);
		System.out.println();
		System.out.println("Iniciando la busqueda por la matriz \n");
		
		// Iniciar busqueda
		
		
		identificador = new Identificador();
		mayor = new Maximo(n);
		for (int i = 0; i < n; i++) 
		{
			new MaximoMatriz(n).start();
		}
	}
}
