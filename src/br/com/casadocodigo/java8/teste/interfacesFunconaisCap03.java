package br.com.casadocodigo.java8.teste;

import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class interfacesFunconaisCap03 {

    public static void main(String[] args) {

        //criando objetos do tipo Usuario
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Siveira", 190);

        //entender que estamos criando um objeto do tipo da interface passando a implementacao ArrayList<>() que é uma lista que permite valores repetidos
        List<Usuario> usuarios1 = new ArrayList<>();

        //adicionando usuarios a lista, que sao objetos do tipo Usuario
        usuarios1.add(user1);
        usuarios1.add(user2);
        usuarios1.add(user3);

        //estamos criando um objeto do tipo da interface Consumer<Objeto>
        Consumer<Usuario> mostrador =  (Usuario u) -> {
            System.out.println(u.getNome());
        };
        usuarios1.forEach(mostrador);
        System.out.println("---");

    }

}
