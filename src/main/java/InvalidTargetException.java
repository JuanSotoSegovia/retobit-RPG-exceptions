public class InvalidTargetException extends Exception {
    public InvalidTargetException() {
        super("No se puede realizar una acción a un objetivo nulo");
    }
}
