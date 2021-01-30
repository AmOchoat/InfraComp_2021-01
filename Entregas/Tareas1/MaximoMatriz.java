package Tareas1;

import java.util.concurrent.ThreadLocalRandom;

public class MaximoMatriz extends Thread{

	//Rango de los números
	private final static int INT_MAX = 105345;

	//Dimensiones cuadradas
	private final static int DIM = 3;

	//Matriz
	private static int[][] matriz = new int[DIM][DIM];

	//Mayor global
	private static int mayor = -1;

	//Mayor locar
	private int mayorFila = -1;

	//ID Thread
	private int idThread;

	//Fila a registrar
	private int fila;

	//Constructor
	public MaximoMatriz(int pIdThread, int pFila) {
		this.idThread = pIdThread;
		this.fila = pFila;
	}

	//Generar la matriz con números aleatorios
	public static void crearMatriz() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				matriz[i][j] = ThreadLocalRandom.current().nextInt(0, INT_MAX);				
			}

			System.out.println("Matriz:");
			System.out.println("====================================");
			imprimirMatriz();

		}
	}

	//Imprimir la matriz en consola
	private static void imprimirMatriz() {

		for(int i = 0; i < DIM; ++i) {
			for (int j = 0; j < DIM; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}

	@Override
	public void run() {
		for (int j = 0; j < DIM; j++) {
			if ( this.mayorFila < matriz[this.fila][j]) {
				this.mayorFila = matriz[this.fila][j];
			}
		}

		if (this.mayorFila > mayor) {
			try { 
				Thread.sleep(250);
			}
			catch ( InterruptedException e) {
				e.printStackTrace();
			}

			mayor = this.mayorFila;

			String warn = String.format("============ Nuevo máximo Global encontrado ============ \n" + 
							"ID Thread: %d - Máximo Local Actual: %d - Máximo Global %d \n" + "\n"
							, this.idThread, mayor, this.mayorFila);

			System.out.println(warn);			
		}

		//Resultados
		String msg = String.format("ID Thread: %d - Máximo Local: %d - Máximo Global: %d",
				this.idThread,
				this.mayorFila,
				mayor);
		System.out.println(msg);
	}

	//Main
	public static void main(String[] args) {
		System.out.println("Búsqueda concurrente por una matriz");

		//Iniciar la matriz
		MaximoMatriz.crearMatriz();
		System.out.println();
		System.out.println("Iniciando la búsqueda por la matriz \n");

		//Iniciar la búsqueda
		MaximoMatriz[] bThreads = new MaximoMatriz[DIM];
//		for (int i = 0; i < bThreads.length; i++) {
//			bThreads[i] = new MaximoMatriz(i,i);
//			bThreads[i].start();			
//		}
		
		bThreads[0] = new MaximoMatriz(0,0);
		bThreads[0].start();
		try {
			bThreads[0].sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bThreads[1] = new MaximoMatriz(1,1);
		bThreads[1].start();
		try {
			bThreads[1].sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bThreads[2] = new MaximoMatriz(2,2);
		bThreads[2].start();
		try {
			bThreads[2].sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
