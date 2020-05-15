
public class Soldado {

	private int sangre;
	private int agujeros;
	private EstadoSalud estado;
	
	public Soldado(int sangre, int agujeros) {
		this.estado = new Saludable(this);
		this.sangre = sangre;
		this.agujeros = agujeros;
	}
	
	public void recibirDisparo() {
		estado.recibirDisparo();
	}
	
	public void recibirCuracion() {
		estado.recibirCuracion();
		
	}
	
	public void perderSangre(int cantidad) {
		this.sangre -= cantidad;
	}
	
	public void recuperarSangre(int cantidad) {
		this.sangre += cantidad;
	}
	
	public int getSangre() {
		return this.sangre;
	}

	public void agregarAgujeros(int cantidad) {
		this.agujeros += cantidad;
	}
	
	public void decrementarAgujeros(int cantidad) {
		this.agujeros -= cantidad;
	}

	public void setEstado(EstadoSalud estado) {
		this.estado = estado;
	}
	
	public EstadoSalud getEstado() {
		return this.estado;
	}
	
	public int getAgujeros() {
		return this.agujeros;
	}
	
	@Override
	public String toString() {
		return "Soldado [sangre=" + sangre + " cm3, agujeros=" + agujeros + ", estado=" + estado + "]";
	}

}
