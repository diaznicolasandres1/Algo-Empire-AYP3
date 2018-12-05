package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonConstruirPlazaCentralInicioEventHandler implements EventHandler<ActionEvent> {

    private Aldeano aldeano;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonConstruirPlazaCentralInicioEventHandler(Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.aldeano = aldeano;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.setMensaje("Haz click en donde\n quieres colocar la\n plaza central");
        this.contenedorPrincipal.cambiarHandlerConstuirPlazaCentral(this.aldeano);
    }
}
