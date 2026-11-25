
package com.mycompany.hilo;

import java.util.concurrent.ThreadLocalRandom;


public class Pausa {
private final Object lock = new Object();
    private boolean pausado = false;

    public void pausar() {
        synchronized (lock) {
            pausado = true;
        }
    }

    public void reanudar() {
        synchronized (lock) {
            pausado = false;
            lock.notifyAll();
        }
    }

    /** Bloquea el hilo que la llame mientras esté pausado. */
    public void esperarSiEstaPausado() throws InterruptedException {
        synchronized (lock) {
            while (pausado) {
                lock.wait();
            }
        }
    }

    public boolean isPausado() {
        synchronized (lock) {
            return pausado;
        }
    }

}
