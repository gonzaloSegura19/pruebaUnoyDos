package paquete;

public class pruebaDos {
	
	
	private static final String palabras []= {
		"En", "Banco", "Azteca", "Sueñas", "Decides", "Logras"
	};
	
	
    public static void main(String[] args) {
    	int acumulado = 0;
    	for (int i=0;i<palabras.length;i++) {
    		final int id = i+1;
    		final String palabra = palabras[i];
    		acumulado += id;
    		final int tiempoEspera= acumulado;
    	
    	Thread hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(tiempoEspera * 1000);
					System.out.println(" El hilo "+ id + ": "+palabra);
				} catch (InterruptedException e) {
					System.out.println("Hilo" + id + "interrumpido");
				}
				
			}
		});
    	
    	hilo.start();
    	}
    	
    }

}
