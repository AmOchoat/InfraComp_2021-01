package Taller1;

public class ContadorMonoThread {
	
	private int contador = 0;
	
	public void contador() {
		for (int i = 0; i < 1000; i++) {
			contador++;			
		}
	}
	
	public int getContador() {
		return contador;		
	}
	
	public static void main(String[] args) {
			
		ContadorMonoThread c = new ContadorMonoThread();
		
		for (int i = 0; i < 1000; i++) {
			c.contador();
		}
		
		System.out.println(c.getContador());
	}
	
	
}
