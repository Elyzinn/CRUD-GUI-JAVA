package com.unialfa.gui;

import com.unialfa.model.Produto;
import com.unialfa.service.ProdutoService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProdutoGui extends JFrame implements PainelDefault{

    private final ProdutoService service;

    private JPanel painel = new JPanel(new GridBagLayout());

    private JLabel idLabel = new JLabel("ID");
    private JTextField idField = new JTextField(20);

    private JLabel descLabel = new JLabel("Descrição");
    private JTextField descField = new JTextField(20);
    private JLabel precoLabel = new JLabel("Preço");
    private JTextField precoField = new JTextField(20);
    private JLabel qtdLabel = new JLabel("Quantidade");
    private JTextField qtdField = new JTextField(20);
    private JButton botaoEnviar = new JButton("Enviar");
    private JButton botaoDeletar = new JButton("Deletar");

    private JTable tabela = new JTable();

    public ProdutoGui() throws HeadlessException {
        this.service = new ProdutoService();

        setTitle("Produtos");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        painelAdd(painel, idLabel,0,0);
        painelAdd(painel, idField,1,0);

        painelAdd(painel,descLabel,0,1);
        painelAdd(painel,descField,1,1);
        painelAdd(painel,precoLabel,0,2);
        painelAdd(painel,precoField,1,2);
        painelAdd(painel,qtdLabel,0,3);
        painelAdd(painel,qtdField,1,3);
        painelAdd(painel, botaoEnviar,0,4);
        painelAdd(painel, botaoDeletar, 2,4);

        botaoEnviar.addActionListener(this::enviar);
        botaoDeletar.addActionListener(this::bDeletar);


        getContentPane().add(painel, BorderLayout.NORTH);

        getContentPane().add(getTabelaPanel(),BorderLayout.CENTER);

    }

    private DefaultTableModel getTabelaModel(){
        var tabelaModel = new DefaultTableModel();
        tabelaModel.addColumn("Id");
        tabelaModel.addColumn("Descrição");
        tabelaModel.addColumn("Preço");
        tabelaModel.addColumn("Quantidade");

        service.listar().forEach(produto ->{
            tabelaModel.addRow(new Object[]{
                    produto.getId(),
                    produto.getDescricao(),
                    produto.getPreco(),
                    produto.getQuantidade()
            });
        });
        return tabelaModel;
    }

    private JPanel getTabelaPanel(){

        tabela.setModel(getTabelaModel());
        tabela.setDefaultEditor(Object.class,null);
        tabela.getSelectionModel().addListSelectionListener(this::selecionarProduto);

        //todo montando a tabela
        tabela.setModel(getTabelaModel());

        var scrollPanel = new JScrollPane(tabela);

        var painelTabela = new JPanel(new BorderLayout());
        painelTabela.add(scrollPanel,BorderLayout.CENTER);

        return painelTabela;
    }

    private void selecionarProduto(ListSelectionEvent event){
        int selectedRow = tabela.getSelectedRow();
        if(selectedRow != -1){
            //Recuperar valores
            var id =(Long) tabela.getValueAt(selectedRow, 0);
            var descricao = (String) tabela.getValueAt(selectedRow, 1);
            var preco =(Float) tabela.getValueAt(selectedRow, 2);
            var quantidade = (Integer) tabela.getValueAt(selectedRow, 3);

            idField.setText(id.toString());
            descField.setText(descricao);
            precoField.setText(preco.toString());
            qtdField.setText(quantidade.toString());
        }
    }

    private void enviar(ActionEvent actionEvent){
        var produto = new Produto();

        if(!idField.getText().equals("")){
            var id = Long.valueOf(idField.getText());
            produto.setId(id);
        }

        produto.setDescricao(descField.getText());

        var preco = Float.valueOf(precoField.getText());
        produto.setPreco(preco);

        var quantidade = Integer.valueOf(qtdField.getText());
        produto.setQuantidade(quantidade);

        service.incluir(produto);

        limparCampos();
        tabela.setModel(getTabelaModel());
    }

    private void bDeletar(ActionEvent actionEvent){
        var produto = new Produto();

        if (!idField.getText().equals("")){
            var id = Long.valueOf(idField.getText());
            produto.setId(id);
        }

        System.out.println("ID QUE A GUI ESTÁ ENVIANDO: " + produto.getId());
        service.eliminar(produto);

        limparCampos();
        tabela.setModel(getTabelaModel());
    }

    private void limparCampos() {
        idField.setText("");
        descField.setText("");
        precoField.setText("");
        qtdField.setText("");
    }


}
