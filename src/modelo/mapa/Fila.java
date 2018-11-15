package modelo.mapa;

import unidades.Colocable;

import java.util.ArrayList;

public class Fila {

    private ArrayList<Casillero> casilleros;

    public Fila() {
        casilleros = new ArrayList<>();
    }

    public void agregarCasilleros(ArrayList<Casillero> casilleros) {

        this.casilleros.addAll(casilleros);
    }

    public Casillero buscarCasillero(int numeroColumna) {
        return casilleros.get(numeroColumna - 1);
    }

    public void colocar(Colocable colocable, int columna) {
        this.buscarCasillero(columna).colocar(colocable);
    }

}
