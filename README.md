# Honguito

Simulador de crecimiento fúngico con interfaz Swing. Requiere Java 21.

## Cómo usarlo

Al pulsar **Inicio** por primera vez, se abre la configuración:

| Entrada | Valor inicial propuesto | Validación |
| --- | ---: | --- |
| Masa inicial (kg) | 1 | Mayor que 0 y menor o igual a la capacidad |
| Capacidad máxima (kg) | 10 | Mayor que 0 |
| Temperatura (°C) | 18 | Cualquier número finito |
| Humedad (%) | 90 | De 0 a 100, inclusive |

Los campos aceptan punto o coma decimal. Con los valores propuestos, la biomasa comienza en 1 kg (10 % de la capacidad) y aumenta gradualmente. La barra indica el porcentaje de capacidad ocupada y el honguito dibujado sobre el tronco del panel central crece conforme aumenta ese porcentaje. Si la masa inicial es igual a la capacidad, la masa permanece constante.

El deslizador **Velocidad** va de x1 a x5: a x1, un segundo de ejecución equivale aproximadamente a un día simulado; a x5, a cinco días. La temperatura y la humedad se mantienen constantes durante cada ejecución. El tiempo sigue avanzando aunque las condiciones impidan que crezca la masa.

- **Pausa** congela el tiempo y la masa; **Reanudar** continúa desde ese punto.
- **Reiniciar** vuelve al día cero y a la masa inicial, conservando la configuración y el estado de pausa.
- **Simulación → Configurar simulación…** permite cambiar las entradas e iniciar otra ejecución.

## Compilar y ejecutar (PowerShell)

```powershell
$fuentes = @(Get-ChildItem -Path src/main/java -Recurse -Filter '*.java' -File).FullName
javac --release 21 -encoding UTF-8 -d target/classes $fuentes
java -cp 'target/classes;src/main/resources' com.mycompany.honguito.Honguito
```
