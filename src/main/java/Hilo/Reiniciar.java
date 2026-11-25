package com.mycompany.hilo;


public class Reiniciar implements Runnable{
     private final Inicio inicio;
    private final Pausa pausa;

    public Reiniciar(Inicio inicio, Pausa pausa) {
        this.inicio = inicio;
        this.pausa = pausa;
    }

    @Override
    public void run() {
        pausa.pausar();
        inicio.reiniciar();
        System.out.println("[Reiniciar] estado restablecido");
        pausa.reanudar();
    }
}
