package br.com.casadocodigo.java8.testes.CapituloSexto;

import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.ArrayList;
import java.util.*;
import java.util.function.Function;

public class MethodDefault {
    public static void main(String[] args) {

        //usando o metodo default
        List<Usuario> usuarios = new ArrayList<>();

        //criando usuarios distintos
        Usuario user = new Usuario("Timoteo", 129);
        Usuario user1 = new Usuario("Taiza", 148);
        Usuario user2 = new Usuario("Luiza", 2000);

        //adicionar esses usuarios a uma lista
        usuarios.add(user);
        usuarios.add(user1);
        usuarios.add(user2);

        //litar o atributo moderador antesde aplicar o metodo que torna um usuario moderador
        usuarios.forEach(u -> System.out.println(u.getModerador()));

        /* percorrer todos os usuarios com foreach
        depois chamar o metodo tornarModerador
        esse metodo define que se passar um usuario ele se torna moderador
        */

        //os dois codigos fazem a mesma coisa mas o ultimo usa methodo default com lambdas
        usuarios.forEach(u -> u.tornaModerador());
        usuarios.forEach(Usuario::tornaModerador);

        //listar o valor do atributo moderador de todos os usuarios
        usuarios.forEach(u -> System.out.println(u.getModerador()));

        //method references no sort
        //usando o metodo comparing do Comparator para fazer a ordenacao pelo nome
        //atraves do metodo references
        usuarios.sort(Comparator.comparing(Usuario::getNome));

        //implementado
        //extrair o nome do usuario
        Function<Usuario,String> byName = Usuario::getNome;

        //criar um Compareto que tem como base o nome extraido
        //fazer a ordenação com sort
        usuarios.sort(Comparator.comparing(byName));

        //ordenar pelo ponto
        usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));

    }
}
