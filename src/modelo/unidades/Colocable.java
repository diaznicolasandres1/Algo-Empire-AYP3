package modelo.unidades;

import modelo.mapa.Mapa;

public interface Colocable {

    void colocarseEn(Mapa mapa, int fila, int columna);

    void finalizarTurno();
    void descolocarseDe(Mapa mapa);
}
