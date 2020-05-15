
public class Herido implements EstadoSalud {

	private Soldado soldado;
	
	public Herido(Soldado soldado) {
		this.soldado = soldado;
	}
	
	@Override
	public void recibirDisparo() {
		this.gritar();
		int todaLaSangre = this.soldado.getSangre();
		this.soldado.perderSangre(todaLaSangre);
		this.soldado.agregarAgujeros(1);
		this.soldado.setEstado(new Muerto(soldado));
	}

	@Override
	public void gritar() {
		System.out.println("Aaaaahhhhh!!!Ooooouuuuhhh!!");
	}

	@Override
	public void recibirCuracion() {
		this.soldado.setEstado(new Saludable(soldado));
		this.soldado.decrementarAgujeros(1);
		this.agradecer();
	}

	@Override
	public void agradecer() {
		System.out.println("Gracias");
	}

	@Override
	public String toString() {
		return "Herido";
	}
}
