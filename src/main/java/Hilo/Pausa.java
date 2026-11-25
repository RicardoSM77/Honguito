package Hilo;

public class Pausa {
    private boolean pausado;
    private long revision;

    public synchronized void pausar() {
        if (!pausado) {
            pausado = true;
            revision++;
        }
    }

    public synchronized void reanudar() {
        pausado = false;
        notifyAll();
    }

    public synchronized void esperarSiEstaPausado() throws InterruptedException {
        while (pausado) {
            wait();
        }
    }

    public synchronized boolean isPausado() {
        return pausado;
    }

    synchronized long getRevision() {
        return revision;
    }
}
