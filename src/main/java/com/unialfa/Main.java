package com.unialfa;

import com.unialfa.gui.PrincipalGUI;
import com.unialfa.gui.ProdutoGui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(Main::executar);
    }

    private static void executar(){
        var gui = new PrincipalGUI();
        gui.setVisible(true);
    }
}
