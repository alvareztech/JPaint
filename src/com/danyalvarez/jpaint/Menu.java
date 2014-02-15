package com.danyalvarez.jpaint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Clase Menu
 * @author Daniel Alvarez
 */
public class Menu extends JMenuBar implements ActionListener {

    private VentanaPrincipal nucleo;
    private JMenu menuArchivo;
    private JMenu menuEdicion;
    private JMenu menuAyuda;
    private JMenu menuLineas;
    private JMenu menuFiguras;
    private JMenuItem itemNuevo;
    private JMenuItem itemDeshacer;
    private JMenuItem itemDibujoLibre;
    private JMenuItem itemLineaRecta;
    private JMenuItem itemArco;
    private JMenuItem itemRectangulo;
    private JMenuItem itemElipse;
    private JMenuItem itemPoligono;
    private JMenuItem itemAcercaDe;

    public Menu(VentanaPrincipal nucleo) {
        this.nucleo = nucleo;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        //JPopupMenu.setDefaultLightWeightPopupEnabled(false); // para que Canvas no tape al Menu
        menuArchivo = new JMenu("Archivo");
        menuEdicion = new JMenu("Edición");
        menuAyuda = new JMenu("Ayuda");

        menuLineas = new JMenu("Lineas");
        menuFiguras = new JMenu("Figuras");

        itemNuevo = new JMenuItem("Nuevo");
        itemNuevo.addActionListener(this);

        itemDibujoLibre = new JMenuItem("Dibujo Libre");
        itemLineaRecta = new JMenuItem("Recta");
        itemArco = new JMenuItem("Arco");
        itemRectangulo = new JMenuItem("Rectángulo");
        itemElipse = new JMenuItem("Elipse");
        itemPoligono = new JMenuItem("Polígono");

        itemDeshacer = new JMenuItem("Deshacer");
        itemDeshacer.addActionListener(this);

        itemDibujoLibre.addActionListener(this);
        itemLineaRecta.addActionListener(this);
        itemArco.addActionListener(this);
        itemRectangulo.addActionListener(this);
        itemElipse.addActionListener(this);
        itemPoligono.addActionListener(this);

        itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe.addActionListener(this);


        // Archivo
        menuArchivo.add(itemNuevo);
        // Edicion
        menuEdicion.add(itemDeshacer);
        menuEdicion.addSeparator();
        menuEdicion.add(itemDibujoLibre);

        menuLineas.add(itemLineaRecta);
        menuLineas.add(itemArco);
        menuEdicion.add(menuLineas);

        menuFiguras.add(itemRectangulo);
        menuFiguras.add(itemElipse);
        menuFiguras.add(itemPoligono);
        menuEdicion.add(menuFiguras);

        // Acerca De
        menuAyuda.add(itemAcercaDe);
        // MENU
        add(menuArchivo);
        add(menuEdicion);
        add(menuAyuda);
    }

    public void actionPerformed(ActionEvent e) {

        if (itemNuevo == e.getSource()) {
            nucleo.reiniciar();
        }
        if (itemDibujoLibre == e.getSource()) {
            nucleo.seleccionar("LAPIZ");
        }
        if (itemLineaRecta == e.getSource()) {
            nucleo.seleccionar("LINEA");
        }
        if (itemArco == e.getSource()) {
            nucleo.seleccionar("ARCO");
        }
        if (itemRectangulo == e.getSource()) {
            nucleo.seleccionar("RECTANGULO");
        }
        if (itemElipse == e.getSource()) {
            nucleo.seleccionar("ELIPSE");
        }
        if (itemPoligono == e.getSource()) {
            nucleo.seleccionar("POLIGONO");
        }
        if (itemDeshacer == e.getSource()) {
            nucleo.deshacer();
        }
        if (itemAcercaDe == e.getSource()) {
            JOptionPane.showMessageDialog(nucleo, "JPaint v.1\nDaniel Alvarez\nwww.danyalvarez.com", "Acerca de JPaint", JOptionPane.INFORMATION_MESSAGE);
        }
        //nucleo.repintar();
    }
}
