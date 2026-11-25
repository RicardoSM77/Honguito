package Motor_Log;

public class Logica {
    //constantes
    final int masMin = 20, masMax = 40;
    final double TEMP_OPTIMA = 18.0;   // °C
    final double HUM_OPTIMA = 90.0;   // %
    final double tempTolerada = 10.0; // ±10 °C
    final double humTolerada = 40.0; // ±40 %
    
    
    double masaSemilla,
            tiempo, //1 seg = 1 dia
            capCarga; //capacidad de carga

    public Logica(double masaInicial, double kg) {

        if (masaInicial <= 0) {
            throw new IllegalArgumentException("La masa inicial debe ser > 0");
        }
        if (kg <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser > 0");
        }

        this.masaSemilla = masaInicial;
        this.capCarga = kg;
    }

    public double crecimiento(double dt, double humedad, double temperatura) {
        //dt = días simulados que avanza este tick
        double factor = calcular(temperatura, humedad);
        double r = radioBase() * factor;
        double deltaM = r * masaSemilla * (1.0 - masaSemilla / capCarga) * dt;
        masaSemilla += deltaM;                       // se suma

        masaSemilla = Math.max(0.0, Math.min(capCarga, masaSemilla)); // seguridad numérica
        return masaSemilla;
    }

    public double calcular(double temperatura, double humedad) {
        double fTemp = penalizacion(temperatura, TEMP_OPTIMA, 10.0);
        double fHum = penalizacion(humedad, HUM_OPTIMA, 40.0);
        return fTemp * fHum;
    }

    // 1.0 en el óptimo, baja linealmente hasta 0.0 en el borde de tolerancia
    private double penalizacion(double valor, double optimo, double tolerancia) {
        double f = 1.0 - Math.abs(valor - optimo) / tolerancia;
        return Math.max(0.0, Math.min(1.0, f));
    }

    public double radioBase() {
        //tasa de crecimiento en %
        return  (Math.random() * (masMax - masMin)) + masMin; //limiuta el valor en este caso entre 20 y 40 
    }

    public double getM() {
        return masaSemilla;
    }
}