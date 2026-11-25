package Hilo;

import Motor_Log.Logica;
import java.util.Objects;

public class Inicio implements Runnable {
    private static final long INTERVALO_MS = 250;

    private final Logica logica;
    private final Pausa pausa;
    private final double temperatura;
    private final double humedad;

    // El monitor de pausa serializa los avances, el reinicio y la detención.
    private double velocidad;
    private double dias;
    private long reinicios;
    private boolean activo = true;
    private Thread hilo;

    public Inicio(Logica logica, double temperatura, double humedad, double velocidad, Pausa pausa) {
        this.logica = Objects.requireNonNull(logica);
        this.pausa = Objects.requireNonNull(pausa);
        logica.calcular(temperatura, humedad);
        this.temperatura = temperatura;
        this.humedad = humedad;
        setVelocidad(velocidad);
    }

    public void setVelocidad(double velocidad) {
        if (!Double.isFinite(velocidad) || velocidad < 1 || velocidad > 5) {
            throw new IllegalArgumentException("La velocidad debe estar entre x1 y x5.");
        }
        synchronized (pausa) {
            this.velocidad = velocidad;
        }
    }

    public void reiniciar() {
        synchronized (pausa) {
            logica.reiniciar();
            dias = 0;
            reinicios++;
        }
    }

    public void detener() {
        synchronized (pausa) {
            activo = false;
            if (hilo != null) {
                hilo.interrupt();
            }
        }
    }

    @Override
    public void run() {
        synchronized (pausa) {
            if (!activo || hilo != null) {
                return;
            }
            hilo = Thread.currentThread();
        }
        try {
            while (!Thread.currentThread().isInterrupted()) {
                long revisionPausa;
                long revisionReinicio;
                synchronized (pausa) {
                    if (!activo) {
                        return;
                    }
                    pausa.esperarSiEstaPausado();
                    revisionPausa = pausa.getRevision();
                    revisionReinicio = reinicios;
                }

                Thread.sleep(INTERVALO_MS);

                synchronized (pausa) {
                    // Descarta un paso pendiente si se pausó o reinició durante la espera.
                    if (activo && revisionPausa == pausa.getRevision() && revisionReinicio == reinicios) {
                        double dt = velocidad * INTERVALO_MS / 1000.0;
                        logica.crecimiento(dt, humedad, temperatura);
                        dias += dt;
                    }
                }
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } finally {
            synchronized (pausa) {
                hilo = null;
            }
        }
    }

    public Estado getEstado() {
        synchronized (pausa) {
            return new Estado(dias, logica.getM(), logica.getCapacidad(), temperatura, humedad);
        }
    }

    public record Estado(double dias, double masa, double capacidad, double temperatura, double humedad) {
    }
}
