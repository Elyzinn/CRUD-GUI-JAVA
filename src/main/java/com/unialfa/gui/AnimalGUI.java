package com.unialfa.gui;

import com.unialfa.model.Animal;
import com.unialfa.service.AnimalService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AnimalGUI extends JFrame implements PainelDefault {

    private final AnimalService service;


    private JPanel painel = new JPanel(new GridBagLayout());

    private JLabel nomeLabel = new JLabel("Nome");
    private JTextField nomeField = new JTextField(20);

    private JLabel pesoLabel = new JLabel("Peso");
    private JTextField pesoField = new JTextField(20);

    private JLabel tamanhoLabel = new JLabel("Tamanho");
    private JTextField tamanhoField = new JTextField(20);

    private JButton botaoEnviar = new JButton("Enviar");

    public AnimalGUI() throws HeadlessException{
        this.service = new AnimalService();

        setTitle("Animais");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        painelAdd(painel,nomeLabel,0,0);
        painelAdd(painel,nomeField,1,0);
        painelAdd(painel,pesoLabel,0,1);
        painelAdd(painel,pesoField,1,1);
        painelAdd(painel,tamanhoLabel,0,2);
        painelAdd(painel,tamanhoField,1,2);
        painelAdd(painel, botaoEnviar,0,3);

        botaoEnviar.addActionListener(this::enviar);

        getContentPane().add(painel);
    }

    private void enviar(ActionEvent actionEvent){
        var animal = new Animal();
        animal.setNome(nomeField.getText());

        var pesoTotal = Double.valueOf(pesoField.getText());
        animal.setPeso(pesoTotal);

        var tamanhoTotal = Float.valueOf(tamanhoField.getText());
        animal.setTamanho(tamanhoTotal);

        service.incluir(animal);

        nomeField.setText("");
        pesoField.setText("");
        tamanhoField.setText("");
    }
}
