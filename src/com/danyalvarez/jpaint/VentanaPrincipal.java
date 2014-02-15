package com.danyalvarez.jpaint;

import javax.swing.*;
import java.awt.*;

/**
 * Clase VentanaPrincipal
 *
 * @author Daniel Alvarez (a3dany)
 */
public class VentanaPrincipal extends JFrame {

    private Menu menu;
    private BarraHerramientas barraHerramientas;
    private Dibujo dibujo;
    private BarraInferior barraInferior;

    public VentanaPrincipal() {
        super("JPaint");
        configurarVentana();
        inicializarComponentes();

    }

    private void configurarVentana() {
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        menu = new Menu(this);
        dibujo = new Dibujo(this);
        barraInferior = new BarraInferior();
        setJMenuBar(menu);
        barraHerramientas = new BarraHerramientas();
        add(barraHerramientas, BorderLayout.NORTH);
        add(dibujo, BorderLayout.CENTER);
        add(barraInferior, BorderLayout.SOUTH);
    }

    public void reiniciar() {
        dibujo.reiniciar();
    }

    public int getGrosorPincel() {
        return barraInferior.getSliderGrosor().getValue();
    }

    public Color getColor() {
        return barraInferior.getBotonColor().getBackground();
    }

    public String getOpcion() {
        return barraHerramientas.getOpcion();
    }

    public boolean esRelleno() {
        return barraInferior.esRelleno();
    }

    public void seleccionar(String opcion) {
        barraHerramientas.setOpcion(opcion);
    }

    public void repintar() {
        dibujo.repaint();
    }

    public void deshacer() {
        dibujo.deshacer();
        dibujo.repaint();
    }
}
