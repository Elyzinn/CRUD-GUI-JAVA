package com.unialfa.model;

public class Animal {
    private String nome;
    private Double peso;
    private Float tamanho;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Float getTamanho() {
        return tamanho;
    }

    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", peso=" + peso +
                ", tamanho=" + tamanho +
                '}';
    }
}
