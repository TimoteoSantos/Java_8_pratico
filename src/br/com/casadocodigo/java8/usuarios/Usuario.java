package br.com.casadocodigo.java8.usuarios;

public class Usuario extends abstractPessoa {

    private  int pontos;
    private boolean moderador;

    public Usuario(String nome, int pontos){
        super(nome);
        this.pontos = pontos;
        this.moderador = false;
    }
    public String getNome(){
        return this.nome;
    }

    public int getPontos(){
        return this.pontos;
    }
    public void setRg(String cpf){
        this.Rg =  cpf;
    }
    public String getRg(){
        return this.Rg;
    }
    public void tornaModerador(){
        this.moderador = true;
    }
    public boolean getModerador(){
        return moderador;
    }
}