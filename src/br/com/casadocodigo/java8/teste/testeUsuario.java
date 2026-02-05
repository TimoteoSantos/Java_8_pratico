package br.com.casadocodigo.java8.teste;

import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testeUsuario {

    public static void main(String[] args) {

        //criando objetos do tipo Usuario
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Siveira", 190);

        //criando uma lista de usuario usando a classe util.Arrays()
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        //criando um usuario com o ArrayList();
        List<Usuario> usuarios1 = new ArrayList<>();

        //adicionando usuarios a lista
        usuarios1.add(user1);
        usuarios1.add(user2);
        usuarios1.add(user3);

        //percorrendo o array de usuarios
        for (Usuario u : usuarios1){
            System.out.println(u.getNome());
        }

        //percorrendo o array de usuarios
        for (Usuario u : usuarios){
            System.out.println(u.getNome());
        }
    }
}
