package Tareas1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1b implements Runnable{

	//milisegundos de espera del Thread
	private int limite; 

	//base
	private int inicio;

	public Ejercicio1b(int pLimiteSup, int pInicio)
	{
		this.limite = pLimiteSup;
		this.inicio = pInicio;
	}

	public void run() {

		int act = inicio;
		try
		{
			while(act <= limite) {			
				System.out.println("Thread " + inicio + ":" + act);
				Thread.sleep(100);
				act = act + 2;
			}
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		InputStreamReader is= new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		try {
			System.out.println("Ingrese un límite superior");
			String entrada = br.readLine();
			int limite = Integer.parseInt(entrada);

			Thread t0 = new Thread( new Ejercicio1b(limite, 1));
			Thread t1 = new Thread( new Ejercicio1b(limite, 2));

			t0.start();
			t1.start();
		} catch (IOException e) {
			System.out.println("Error con los datos de entrada.");
		}			
	}

}
