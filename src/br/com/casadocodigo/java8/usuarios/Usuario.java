package br.com.casadocodigo.java8.usuarios;

public class Usuario extends abstractPessoa {

    private  int pontos;
    private boolean moderador;

    public Usuario(String nome, int pontos){
        super(nome);
        this.pontos = pontos;
        this.moderador = false;
    }

    public Usuario() {
        super();
    }

    public Usuario(String nome){
        this.nome = nome;
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
    public void escreverUsuario(){
        System.out.println(this.nome);
    }

    //estou dizendo aqui como quero mostrar meu Usuario
    @Override
    public String toString() {
        return "Usuario [ " + nome + " ] [ " + pontos + " ] ";
    }
}