package modelo.unidades.aldeano;

import modelo.edificios.Edificio;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.UnidadFueDestruidaException;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoAldeanoDisponible implements EstadoAldeano {

    private static final String NOMBRE_ESTADO = "Disponible";
    private static final int ORO_A_GENERAR = 20;

    public void recolectarOro(Oro oro) {
        oro.sumarOro(ORO_A_GENERAR);
    }

    public void avanzarTurno(Aldeano aldeano) {
        // Aldeano no maneja turnos mientras se encuentra en este estado
    }

    @Override
    public PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro) {
        PlazaCentral plaza = new PlazaCentral(oro);
        aldeano.estarOcupado(3);
        return plaza;
    }

    @Override
    public Cuartel construirCuartel(Aldeano aldeano, int turnosOcupado, Oro oro) {
        Cuartel cuartel = new Cuartel(oro);
        aldeano.estarOcupado(3);
        return cuartel;
    }

    @Override
    public void repararEdificio(Aldeano aldeano, Edificio edificio) {
        aldeano.estarEnReparacion();
        aldeano.repararEdificio(edificio);
    }

    @Override
    public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int distanciaMaxima) {
        origen.moverUnidadHacia(unidad, mapa, destino, distanciaMaxima);
    }

    @Override
    public String getNombreEstado() {
        return NOMBRE_ESTADO;
    }
    
    @Override
    public void matar() {
        throw new UnidadFueDestruidaException();
    }
}