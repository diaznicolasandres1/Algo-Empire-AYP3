package modelo.excepciones;

public class EdificioObjetivoEsPropioException extends ColocableSeleccionadoException {
    
    public EdificioObjetivoEsPropioException() {
        super("Edificio objetivo pertenece al jugador actual");
    }

}
