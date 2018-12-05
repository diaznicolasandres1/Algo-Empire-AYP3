package modelo.unidades.armadeasedio;

import modelo.unidades.Atacable;
import modelo.unidades.Atacante;
import modelo.excepciones.ColocableFueraDeRangoDeAtaqueException;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class ArmaDeAsedio extends Unidad implements Atacante {

	private static final int DISTANCIA_MAXIMA_ATAQUE = 5;
	private EstadoArmaAsedio estado = new EstadoArmaAsedioDesmontada();

	public ArmaDeAsedio(Oro oro) {
		this.vida = 150;
		oro.restarOro(200);
	}

	public void montarArma() {
		this.estado.montarArma(this);
		this.estado = new EstadoArmaAsedioEnPausa(new EstadoArmaAsedioMontada());
	}

	public void desmontarArma() {
		this.estado.desmontarArma(this);
		this.estado = new EstadoArmaAsedioEnPausa(new EstadoArmaAsedioDesmontada());
	}

	public void finalizarTurno() {
		this.estado = this.estado.proximoEstado();
	}

	@Override
	public void moverHacia(Posicion destino, Mapa mapa) {
		this.estado.moverUnidadDesdeHacia(this, mapa, destino, this.posicion, DISTANCIA_DE_MOVIMIENTO);
	}

	@Override
	public void atacar(Atacable objetivo) {
		if (objetivo.calcularDistanciaA(this.posicion) > DISTANCIA_MAXIMA_ATAQUE) {
			throw new ColocableFueraDeRangoDeAtaqueException();
		}
		this.estado.atacar(objetivo, this);
        this.estado = new EstadoArmaAsedioEnPausa(this.estado);
	}

}
