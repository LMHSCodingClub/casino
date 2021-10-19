package com.lmhscodingclub.monopoly.userinterface;

import java.text.NumberFormat;

import javax.swing.JFormattedTextField;

public class NumberField extends JFormattedTextField {
    private static final long serialVersionUID = -5576339439234941163L;

    public NumberField() {
        super(NumberFormat.getNumberInstance());
        setValue(0);
        setColumns(10);
    }
}
