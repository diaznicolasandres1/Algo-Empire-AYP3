package modelo.unidades.armadeasedio;

import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoArmaAsedioDesmontada implements EstadoArmaAsedio{

	
	
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento) {
		origen.moverUnidadHacia(unidad, mapa, destino, rangoMovimiento);
	}


	@Override
	public void atacar(Edificio edificio) {
		throw new NoSePuedeAtacarArmaAsedioDesmontadaException();
		
	}


	@Override
	public void atacar(Unidad unidad) {
		throw new NoSePuedeAtacarArmaAsedioDesmontadaException();
		
	}
}