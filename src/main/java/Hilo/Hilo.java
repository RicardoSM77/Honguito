

package com.mycompany.hilo;


public class Hilo {

  public static void main(String[] args) throws InterruptedException {
        Pausa pausa = new Pausa();
        Inicio inicio = new Inicio(25.5, 60.0, 12.0, pausa);

        // Hilo de trabajo
        Thread hiloInicio = new Thread(inicio, "hilo-inicio");
        hiloInicio.start();

        // Hilo controlador: pausa, reanuda y reinicia, cada acción en su propio hilo
        Thread controlador = new Thread(() -> {
            try {
                Thread.sleep(2000);
                Thread hiloPausa = new Thread(() -> {
                    pausa.pausar();
                    System.out.println("[Pausa] pausado");
                }, "hilo-pausa");
                hiloPausa.start();
                hiloPausa.join();

                Thread.sleep(2000);
                Thread hiloReanudar = new Thread(() -> {
                    pausa.reanudar();
                    System.out.println("[Pausa] reanudado");
                }, "hilo-reanudar");
                hiloReanudar.start();
                hiloReanudar.join();

                Thread.sleep(2000);
                Thread hiloReiniciar = new Thread(new Reiniciar(inicio, pausa), "hilo-reiniciar");
                hiloReiniciar.start();
                hiloReiniciar.join();

                Thread.sleep(2000);
                inicio.detener();
                pausa.reanudar(); // por si quedó pausado, para que pueda terminar
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "hilo-controlador");
        controlador.start();

        controlador.join();
        hiloInicio.join();
    }
}
