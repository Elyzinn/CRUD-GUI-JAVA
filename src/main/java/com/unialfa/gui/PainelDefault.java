package com.unialfa.gui;

import javax.swing.*;
import java.awt.*;

public interface PainelDefault {

    default void painelAdd(JPanel painel, Component component, int coluna, int linha) {
        var constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = coluna;
        constraints.gridy = linha;
        painel.add(component, constraints);
    }
}
