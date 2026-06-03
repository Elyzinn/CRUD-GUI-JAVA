package com.unialfa.service;

import com.unialfa.dao.ProdutoDao;
import com.unialfa.model.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    public List<Produto> listar(){
        try{
           var dao = new ProdutoDao();

           return dao.listar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    public void incluir(Produto produto){
       // System.out.println(produto.getDescricao());

      //  var arquivo = new File(System.getProperty("user.dir"),"\\produtos.txt");
       // writerFile(produto.toString(), arquivo.toString());
      //  readerFile(arquivo.toString()).forEach(System.out::println);

        try{
            var dao = new ProdutoDao();

            if(produto.getId() == null){
                dao.inserir(produto);
            }else{
                dao.atualizar(produto);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminar(Produto produto){
        try{
            var dao = new ProdutoDao();
            if (produto.getId() != null){
                dao.deletar(produto);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public Integer contarProdutosBaratos(){
        //regra de negócio
        return 1;
    }

    private void writerFile(String conteudo, String nomeArquivo){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))){
            writer.newLine();
            writer.write(conteudo);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private List<String> readerFile(String nomeArquivo){
        List<String> result = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))){
            reader.lines().forEach(result::add);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return result;
    }
}
