package modelo;

import junit.framework.Assert;
import org.junit.Test;
import unidades.Aldeano;

public class AldeanoTest {

	@Test
	public void test01CreacionDeAldeano() {
		Aldeano aldeano = new Aldeano();		
		Assert.assertEquals(aldeano.getVida(), 50);
	}

    @Test
    public void test02AldeeanoDisponibleSumaOro() {
        Aldeano aldeano = new Aldeano();
        Oro oro = new Oro(100);
        aldeano.recolectarOro(oro);
        int cantidadOro = oro.getOro();
        Assert.assertEquals(125, cantidadOro);
    }

    @Test
    public void test03AldeanoOcupadoNoSumaOro() {
        Aldeano aldeano = new Aldeano();
        Oro oro = new Oro(100);
        aldeano.estarOcupado();
        aldeano.recolectarOro(oro);
        int cantidadOro = oro.getOro();
        Assert.assertEquals(100, cantidadOro);
		}
}