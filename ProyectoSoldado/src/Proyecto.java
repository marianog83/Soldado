import java.io.UnsupportedEncodingException;

public class Proyecto {

	public static void main(String[] args) throws UnsupportedEncodingException {

		Soldado soldado = new Soldado(3000, 0);
		
		
		System.out.println("Estado inicial -> " + soldado);
		soldado.recibirDisparo();
		System.out.println("El soldado recibió un disparo -> " + soldado);
		soldado.recibirDisparo();
		System.out.println("El soldado recibió un segundo disparo -> " + soldado);
		soldado.recibirDisparo();
		System.out.println("El soldado recibió un tercer disparo -> " + soldado);
	}

}
