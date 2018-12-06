package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import modelo.edificios.Edificio;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonRepararEdificioFinEventHandler implements EventHandler<ActionEvent> {
    private final ContenedorPrincipal contenedor;
    private final Aldeano reparador;
    private final Juego juego;
    private final int fila;
    private final int columna;

    public BotonRepararEdificioFinEventHandler(Juego juego, Aldeano reparador, int fila, int columna, ContenedorPrincipal contenedor){
        this.reparador = reparador;
        this.contenedor = contenedor;
        this.juego = juego;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Colocable edificio = this.juego.getColocable(this.fila, this.columna);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al reparar edificio");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.repararEdificio(this.reparador, (Edificio) edificio);
        } catch (ColocableSeleccionadoException | EdificioException | UnidadYaFueUtilizadaEnEsteTurnoException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (ConstruccionFueraDeRangoException e) {
            alert.setContentText("El edificio no se encuentra proximo al aldeano");
            alert.show();
        }
        this.contenedor.clearMensajes();
        this.contenedor.dibujarMapaConCasilleroHandler();
    }
}
