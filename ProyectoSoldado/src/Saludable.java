
public class Saludable implements EstadoSalud {

	private Soldado soldado;
	
	public Saludable(Soldado soldado) {
		this.soldado = soldado;
	}
	
	@Override
	public void recibirDisparo() {
		this.gritar();
		this.soldado.perderSangre(100);
		this.soldado.agregarAgujeros(1);
		this.soldado.setEstado(new Herido(this.soldado));
	}
	
	public void gritar() {
		System.out.println("Aaaaahhhhh!!!");
	}

	@Override
	public void recibirCuracion() {
		this.agradecer();
	}

	@Override
	public void agradecer() {
		System.out.println("Gracias, pero estoy saludable");
	}

	@Override
	public String toString() {
		return "Saludable";
	}
}
