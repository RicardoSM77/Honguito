package Motor_Log;

/** Modelo de crecimiento logístico de una biomasa, en kilogramos. */
public class Logica {
    private static final double TEMP_OPTIMA = 18.0;
    private static final double HUM_OPTIMA = 90.0;
    private static final double TOLERANCIA_TEMP = 10.0;
    private static final double TOLERANCIA_HUM = 40.0;
    private static final double TASA_BASE = 0.30; // Por día simulado.

    private final double masaInicial;
    private final double capacidad;
    private double masa;

    public Logica(double masaInicial, double capacidad) {
        if (!Double.isFinite(masaInicial) || masaInicial <= 0) {
            throw new IllegalArgumentException("La masa inicial debe ser finita y mayor que 0 kg.");
        }
        if (!Double.isFinite(capacidad) || capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser finita y mayor que 0 kg.");
        }
        if (masaInicial > capacidad) {
            throw new IllegalArgumentException("La masa inicial no puede superar la capacidad.");
        }
        this.masaInicial = masaInicial;
        this.capacidad = capacidad;
        this.masa = masaInicial;
    }

    /** Avanza dt días simulados con las condiciones dadas y devuelve la nueva masa. */
    public synchronized double crecimiento(double dt, double humedad, double temperatura) {
        if (!Double.isFinite(dt) || dt < 0) {
            throw new IllegalArgumentException("El paso de tiempo debe ser finito y no negativo.");
        }
        double exponente = TASA_BASE * calcular(temperatura, humedad) * dt;
        if (exponente == 0 || masa == capacidad) {
            return masa;
        }

        // Solución exacta para condiciones constantes durante el paso.
        double nuevaMasa;
        if (exponente < 700) {
            double fraccion = masa / capacidad;
            nuevaMasa = masa / (fraccion + (1 - fraccion) * Math.exp(-exponente));
        } else {
            // Evita perder ambos términos del denominador para pasos muy grandes.
            double logRelacion = Math.log(capacidad - masa) - Math.log(masa) - exponente;
            nuevaMasa = logRelacion > 0
                    ? Math.exp(Math.log(capacidad) - logRelacion) / (1 + Math.exp(-logRelacion))
                    : capacidad / (1 + Math.exp(logRelacion));
        }
        masa = Math.max(masa, Math.min(capacidad, nuevaMasa));
        return masa;
    }

    /** Devuelve un factor ambiental entre 0 y 1. */
    public double calcular(double temperatura, double humedad) {
        if (!Double.isFinite(temperatura)) {
            throw new IllegalArgumentException("La temperatura debe ser un número finito en °C.");
        }
        if (!Double.isFinite(humedad) || humedad < 0 || humedad > 100) {
            throw new IllegalArgumentException("La humedad debe estar entre 0 y 100 %.");
        }
        return penalizacion(temperatura, TEMP_OPTIMA, TOLERANCIA_TEMP)
                * penalizacion(humedad, HUM_OPTIMA, TOLERANCIA_HUM);
    }

    private double penalizacion(double valor, double optimo, double tolerancia) {
        return Math.max(0, 1 - Math.abs(valor - optimo) / tolerancia);
    }

    public synchronized void reiniciar() {
        masa = masaInicial;
    }

    public synchronized double getM() {
        return masa;
    }

    public double getCapacidad() {
        return capacidad;
    }
}
