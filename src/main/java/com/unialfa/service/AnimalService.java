package com.unialfa.service;

import com.unialfa.model.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalService {

    public void incluir(Animal animal){

        var arquivo = new File(System.getProperty("user.dir"),"\\produtos.txt");
        writerFile(animal.toString(), arquivo.toString());
        readerFile(arquivo.toString()).forEach(System.out::println);
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
