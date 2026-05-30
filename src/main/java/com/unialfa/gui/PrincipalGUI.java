package com.unialfa.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PrincipalGUI extends JFrame implements PainelDefault {

    private JMenuBar menuBar = new JMenuBar();

    public PrincipalGUI() throws HeadlessException{

        setTitle("Projeto Monkey");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setSize(200,200);

        menuBar.add(montarMenu());

        setJMenuBar(menuBar);

    }

    private JMenu montarMenu(){
        var menu = new JMenu("Cadastros");
        menu.setFont(new Font("Arial", Font.PLAIN, 16));

        var miProduto = new JMenuItem("Produto");
        miProduto.setFont(new Font("Arial", Font.PLAIN, 14));
        miProduto.addActionListener(this::abrirProduto);

        var miAnimal = new JMenuItem("Animais");
        miAnimal.setFont(new Font("Arial",Font.PLAIN, 14));
        miAnimal.addActionListener(this::abrirAnimal);

        menu.add(miProduto);
        menu.add(miAnimal);
        return menu;
    }


    private void abrirProduto(ActionEvent actionEvent){
        var guiProduto = new ProdutoGui();

        guiProduto.setVisible(true);
    }

    private void abrirAnimal(ActionEvent actionEvent){
        var guiAnimal = new AnimalGUI();

        guiAnimal.setVisible(true);
    }


}
