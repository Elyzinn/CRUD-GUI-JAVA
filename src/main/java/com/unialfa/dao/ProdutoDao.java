package com.unialfa.dao;

import com.unialfa.model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDao extends Dao {

    public List<Produto> listar() throws SQLException {

        List<Produto> produtos = new ArrayList<>();

        var resultSet = getConnection()
                .prepareStatement("select * from produto")
                .executeQuery();

        while(resultSet.next()){
            var p = new Produto();
            p.setId(resultSet.getLong("id"));
            p.setDescricao(resultSet.getString("descricao"));
            p.setPreco(resultSet.getFloat("preco"));
            p.setQuantidade(resultSet.getInt("quantidade"));

            produtos.add(p);
        }


        return produtos;
    }

    public void inserir(Produto produto) throws SQLException {
        var sqlInsert = "insert into produto(descricao,preco,quantidade) values (?,?,?)";
        var ps = getConnection().prepareStatement(sqlInsert);
        ps.setString(1, produto.getDescricao());
        ps.setFloat(2,produto.getPreco());
        ps.setInt(3, produto.getQuantidade());

        ps.execute();
    }

    public void atualizar(Produto produto) throws SQLException{

            var sqlUpdate = "update produto set descricao=?, preco=?, quantidade=? where id = ?";
            var ps = getConnection().prepareStatement(sqlUpdate);

            ps.setString(1, produto.getDescricao());
            ps.setFloat(2,produto.getPreco());
            ps.setInt(3, produto.getQuantidade());
            ps.setLong(4, produto.getId());

            ps.execute();

    }
}
