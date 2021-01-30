package Tareas1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1a extends Thread{
	
	//milisegundos de espera del Thread
	private int limite; 
	
	//base
	private int inicio;
	
	public Ejercicio1a(int pLimiteSup, int pInicio)
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
				Thread.sleep(Integer.MAX_VALUE);
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
			
			Ejercicio1a e0 = new Ejercicio1a(limite, 1);
			Ejercicio1a e1 = new Ejercicio1a(limite, 2);
			
			e0.start();
			e1.start();
		} catch (IOException e) {
			System.out.println("Error con los datos de entrada.");
		}			
	}

}
