package modelo.mapa;

import modelo.unidades.Colocable;

public class Casillero {

    private Colocable colocable;

    public void colocar(Colocable colocable) {

        if (this.estaOcupado()) {
            throw new CasilleroOcupadoException();
        }
        this.colocable = colocable;
    }

    public void desocupar() {
        this.colocable = null;
    }

    private boolean estaOcupado() {
        return this.colocable != null;
    }
}
