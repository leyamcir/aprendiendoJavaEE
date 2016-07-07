package es.curso.singleton;

public class Principal {

	public static void main(String[] args) {
		Singleton s1;
		Singleton s2;
		
		s1 = Singleton.getInstance();
		System.out.println(s1.getTiempo().getTime());
		
		// Retardo 2 seg
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s2 = Singleton.getInstance();
		System.out.println(s2.getTiempo().getTime());

	}

}
