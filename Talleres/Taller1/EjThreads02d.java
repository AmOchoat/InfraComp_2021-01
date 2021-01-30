package Taller1;

public class EjThreads02d implements Runnable {

	private String name;

	public EjThreads02d(String name) {
		System.out.println("Implementando la interfaz Runnable");
		this.name = name;
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(name + " valor: " + i);
				Thread.sleep(50);
			}
		}
		catch (Exception e) {
			System.out.println("Saliendo: " + name);
		}
	}

	public static void main(String[] args) {
		EjThreads01d t0 = new EjThreads01d("Thread " + 0);
		EjThreads01d t1 = new EjThreads01d("Thread " + 1);
		EjThreads01d t2 = new EjThreads01d("Thread " + 2);

		t0.start();
		t1.start();
		t2.start();
	}
}
