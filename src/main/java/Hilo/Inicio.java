package com.mycompany.hilo;

import java.util.concurrent.ThreadLocalRandom;

public class Inicio implements Runnable {

    private final double tempInicial;
    private final double humedadInicial;
    private final double velInicial;
    private final Pausa pausa;

    private double temp;
    private double humedad;
    private double vel;
    private double dt;
    private int iteracion;
    private volatile boolean activo = true;

    public Inicio(double temp, double humedad, double vel, Pausa pausa) {
        this.tempInicial = temp;
        this.humedadInicial = humedad;
        this.velInicial = vel;
        this.pausa = pausa;
        reiniciar();
    }

    /**
     * Devuelve el estado a los valores iniciales (seguro de llamar desde otro
     * hilo).
     */
    public synchronized void reiniciar() {
        this.temp = tempInicial;
        this.humedad = humedadInicial;
        this.vel = velInicial;
        this.dt = 0;
        this.iteracion = 0;
    }

    public void detener() {
        activo = false;
    }

    @Override
    public void run() {
        try {
            while (activo && !Thread.currentThread().isInterrupted()) {
                // Si está pausado, el hilo se queda aquí hasta que lo reanuden
                pausa.esperarSiEstaPausado();

                synchronized (this) {
                    iteracion++;
                    dt = vel * 0.05;
                    temp += ThreadLocalRandom.current().nextDouble(-0.5, 0.5) * dt;
                    humedad += ThreadLocalRandom.current().nextDouble(-1.0, 1.0) * dt;
                    System.out.printf("[Inicio] it=%d dt=%.3f temp=%.2f humedad=%.2f%n",
                            iteracion, dt, temp, humedad);
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[Inicio] terminado");
    }

    public synchronized double getDt() {
        return dt;
    }
}
