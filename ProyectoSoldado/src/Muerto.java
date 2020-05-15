
public class Muerto implements EstadoSalud {

	private Soldado soldado;
	
	public Muerto(Soldado soldado) {
		this.soldado = soldado;
	}

	@Override
	public void recibirDisparo() {
		this.soldado.agregarAgujeros(1);
		
	}

	@Override
	public void gritar() {
	}

	@Override
	public void recibirCuracion() {
		this.soldado.setEstado(new Saludable(soldado));
		this.soldado.recuperarSangre(3000);
		this.soldado.decrementarAgujeros(this.soldado.getAgujeros());
		this.agradecer();
	}

	@Override
	public void agradecer() {
		System.out.println("He revivido!");
	}
	
	@Override
	public String toString() {
		return "Muerto";
	}

}
