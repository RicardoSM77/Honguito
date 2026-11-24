package Motor_Log;

public class Logica {
    double m, 
           tiempo,  //1 seg = 1 dia
           kg,      //capacidad de carga
           rBase,   //tasa de crecimiento en %
           masaI;
    final double TEMP_OPTIMA = 18.0;   // °C
    final double HUM_OPTIMA = 90.0;   // %
    final double tempTolerada = 10.0; // ±10 °C
    final double humTolerada = 40.0; // ±40 %

    public Logica(double masaInicial, double kg) {

        if (masaInicial <= 0) {throw new IllegalArgumentException("La masa inicial debe ser > 0");}
        if (kg <= 0) {throw new IllegalArgumentException("La capacidad debe ser > 0");}

        this.m = masaInicial;
        this.kg = kg;
        this.masaI = masaInicial;
    }

    public double crecimiento(double dt, double humedad, double temperatura) {
        //dt = días simulados que avanza este tick
        double factor = calcular(temperatura, humedad);
        double r = rBase * factor;
        double deltaM = r * m * (1.0 - m / kg) * dt;
        m += deltaM;                       // se suma

        m = Math.max(0.0, Math.min(kg, m)); // seguridad numérica
        return m;
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
    
    public void reiniciar(){
        m = masaI;
    }

    public void radioBase(){
        
    }

    public double getM() {
        return m;
    }
}
