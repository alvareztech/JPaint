package tech.alvarez.jpaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraInferior extends JPanel implements ActionListener {

    private JLabel etiquetaGrosor;
    private JLabel etiquetaColor;
    private JSlider sliderGrosor;
    private JButton botonColor;
    private JCheckBox checkBoxRelleno;

    public BarraInferior() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        etiquetaGrosor = new JLabel("Grosor del pincel");
        sliderGrosor = new JSlider(1, 30, 1);
        etiquetaColor = new JLabel("Color");
        botonColor = new JButton();
        botonColor.setBackground(Color.red);
        botonColor.addActionListener(this);
        checkBoxRelleno = new JCheckBox("Relleno");
        add(etiquetaColor);
        add(botonColor);
        add(etiquetaGrosor);
        add(sliderGrosor);
        add(checkBoxRelleno);
    }

    public JSlider getSliderGrosor() {
        return sliderGrosor;
    }

    public void actionPerformed(ActionEvent e) {
        Color color = JColorChooser.showDialog(null, "Seleccione Color", Color.yellow);
        botonColor.setBackground(color);
    }

    public JButton getBotonColor() {
        return botonColor;
    }

    public boolean esRelleno() {
        return checkBoxRelleno.isSelected();
    }
}