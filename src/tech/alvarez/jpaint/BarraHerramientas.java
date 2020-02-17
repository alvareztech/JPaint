package tech.alvarez.jpaint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraHerramientas extends JToolBar implements ActionListener {

    private String opcion;
    private JToggleButton botonLapiz;
    private JToggleButton botonLinea;
    private JToggleButton botonRectangulo;
    private JToggleButton botonElipse;
    private JToggleButton botonArco;
    private JToggleButton botonPoligono;
    private String PATH_IMAGES = "/tech/alvarez/jpaint/images/";

    public BarraHerramientas() {
        // setRollover(true);
        opcion = "LAPIZ";
        setFloatable(false);
        inicializarComponentes();
        actualizarEstadoBotones();
    }

    private void inicializarComponentes() {
        botonLapiz = new JToggleButton();
        botonLinea = new JToggleButton();
        botonRectangulo = new JToggleButton();
        botonElipse = new JToggleButton();
        botonArco = new JToggleButton();
        botonPoligono = new JToggleButton();
        botonLapiz.setIcon(crearImageIcon(PATH_IMAGES + "lapiz.png"));
        botonLinea.setIcon(crearImageIcon(PATH_IMAGES + "linea.png"));
        botonRectangulo.setIcon(crearImageIcon(PATH_IMAGES + "rectangulo.png"));
        botonElipse.setIcon(crearImageIcon(PATH_IMAGES + "elipse.png"));
        botonArco.setIcon(crearImageIcon(PATH_IMAGES + "arco.png"));
        botonPoligono.setIcon(crearImageIcon(PATH_IMAGES + "poligono.png"));
        botonLapiz.addActionListener(this);
        botonLinea.addActionListener(this);
        botonRectangulo.addActionListener(this);
        botonElipse.addActionListener(this);
        botonArco.addActionListener(this);
        botonPoligono.addActionListener(this);
        add(botonLapiz);
        add(botonLinea);
        add(botonArco);
        add(botonRectangulo);
        add(botonElipse);
        add(botonPoligono);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonLapiz) {
            opcion = "LAPIZ";
        } else if (e.getSource() == botonLinea) {
            opcion = "LINEA";
        } else if (e.getSource() == botonRectangulo) {
            opcion = "RECTANGULO";
        } else if (e.getSource() == botonElipse) {
            opcion = "ELIPSE";
        } else if (e.getSource() == botonArco) {
            opcion = "ARCO";
        } else if (e.getSource() == botonPoligono) {
            opcion = "POLIGONO";
        }
        actualizarEstadoBotones();
    }

    public String getOpcion() {
        return opcion;
    }

    private void actualizarEstadoBotones() {
        if (opcion.equals("LAPIZ")) {
            botonLapiz.setSelected(true);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(false);
            botonArco.setSelected(false);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("LINEA")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(true);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(false);
            botonArco.setSelected(false);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("RECTANGULO")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(true);
            botonElipse.setSelected(false);
            botonArco.setSelected(false);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("ELIPSE")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(true);
            botonArco.setSelected(false);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("ARCO")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(false);
            botonArco.setSelected(true);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("POLIGONO")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(false);
            botonArco.setSelected(false);
            botonPoligono.setSelected(true);
        }
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
        actualizarEstadoBotones();
    }

    protected static ImageIcon crearImageIcon(String path) {
        java.net.URL imgURL = BarraHerramientas.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + path);
            return null;
        }
    }
}
