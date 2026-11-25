package Hilo;

public class Reiniciar implements Runnable {
    private final Inicio inicio;

    public Reiniciar(Inicio inicio) {
        this.inicio = inicio;
    }

    @Override
    public void run() {
        inicio.reiniciar();
    }
}
