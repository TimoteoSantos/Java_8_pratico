package br.com.casadocodigo.java8.teste;

import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class interfacesFunconais {

    public static void main(String[] args) {

        //criando objetos do tipo Usuario
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Siveira", 190);

        List<Usuario> usuarios1 = new ArrayList<>();

        //adicionando usuarios a lista
        usuarios1.add(user1);
        usuarios1.add(user2);
        usuarios1.add(user3);

        //temos um objeto mostrador do tipo Consumer<T>
        Consumer<Usuario> mostrador =  (Usuario u) -> {
            System.out.println(u.getNome());
        };
        usuarios1.forEach(mostrador);
        System.out.println("---");

    }
}
