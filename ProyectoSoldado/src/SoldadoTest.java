import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;

public class SoldadoTest {

	private static final int AGUJEROS = 0;
	private static final int SANGRE = 3000;
	private Soldado soldado;
	
	
	@Before
	public void setUp() {
		soldado = new Soldado(SANGRE, AGUJEROS);
	}
	
	@Test
    public void siEstaSaludableYRecibeUnDisparoQuedaHerido() {
        soldado.recibirDisparo();
        
        assertThat(soldado.getEstado(), instanceOf(Herido.class));
    }
	
	@Test
    public void siEstaSaludableYRecibeUnDisparoPierde100cm3DeSangre() {
        soldado.recibirDisparo();
        
        assertEquals(soldado.getSangre(), SANGRE - 100);
    }
	
	@Test
    public void siEstaSaludableYRecibeUnDisparoSeLeGeneraUnAgujero() {
        soldado.recibirDisparo();
        
        assertEquals(soldado.getAgujeros(), AGUJEROS + 1);
    }
	
	@Test
    public void siEstaHeridoYRecibeUnDisparoMuere() {
		soldado.setEstado(new Herido(soldado));
        soldado.recibirDisparo();
        
        assertThat(soldado.getEstado(), instanceOf(Muerto.class));
    }
	
	@Test
    public void siEstaHeridoYRecibeUnDisparoPierdeTodaLaSangre() {
		soldado.setEstado(new Herido(soldado));
        soldado.recibirDisparo();
        
        assertEquals(soldado.getSangre(), 0);
    }
	
	@Test
    public void siEstaHeridoYRecibeUnDisparoSeLeGeneraUnAgujero() {
		soldado.setEstado(new Herido(soldado));
        soldado.recibirDisparo();
        
        assertEquals(soldado.getAgujeros(), AGUJEROS + 1);
    }
	
	@Test
	public void siEstaSaludableYRecibeCuracionPermaneceSaludable() {
		soldado.recibirCuracion();
		
		assertThat(soldado.getEstado(), instanceOf(Saludable.class));
	}
	
	@Test
	public void siEstaHeridoYRecibeCuracionQuedaSaludable() {
		soldado.setEstado(new Herido(soldado));
		soldado.recibirCuracion();
		
		assertThat(soldado.getEstado(), instanceOf(Saludable.class));
	}
	
	@Test
	public void siEstaHeridoYRecibeCuracionSeLeCuraUnAgujeroDeBala() {
		soldado.setEstado(new Herido(soldado));
		soldado.recibirCuracion();
		
		assertEquals(soldado.getAgujeros(), AGUJEROS - 1);
	}
	
	@Test
	public void siEstaMuertoYRecibeUnDisparoSeLeGeneraUnAgujero() {
		estaMuerto();
		int agujeros = soldado.getAgujeros();
		
		soldado.recibirDisparo();
		
		assertEquals(soldado.getAgujeros(), agujeros + 1);
	}
	
	@Test
	public void siEstaMuertoYRecibeCuracionQuedaSaludable() {
		estaMuerto();
		
		soldado.recibirCuracion();
		
		assertThat(soldado.getEstado(), instanceOf(Saludable.class));
	}
	
	@Test
	public void siEstaMuertoYRecibeCuracionRecuperaTodaLaSangre() {
		estaMuerto();
		
		soldado.recibirCuracion();
		
		assertEquals(soldado.getSangre(), 3000);
	}
	
	@Test
	public void siEstaMuertoYRecibeCuracionSeLeCuranTodosLosAgujerosDeBala() {
		estaMuerto();
		
		soldado.recibirCuracion();
		
		assertEquals(soldado.getAgujeros(), 0);
	}
	
	private void estaMuerto() {
		soldado.setEstado(new Muerto(soldado));
		soldado.agregarAgujeros(2);
		soldado.perderSangre(3000);
	}
}
