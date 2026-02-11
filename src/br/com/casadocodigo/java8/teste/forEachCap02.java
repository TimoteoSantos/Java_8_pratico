package br.com.casadocodigo.java8.teste;

import br.com.casadocodigo.java8.Mostrador;
import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class forEachCap02 {

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

        //usando o Consumer()
        //forEach() , esse metodo recebe como argumento um objeto do tipo

        //PRIMEIRO IREMOS USAR A CLASSE Mostrador() PARA MOSTRAR OS DADOS
        //DEPOIS VEREMOS SOLUCOES MAIS SOFISTICADAS

        //estamos criando um objeto do tipo Mostrador()
        Mostrador mostrador0 = new Mostrador(); //essa classe implementa a interface que possue apenas um metodo por isso é uma interface funcional

        //estamos fazendo um foreach no objeto
        usuarios.forEach(mostrador0);


        //criando uma classe anonima
        Consumer<Usuario> mostrador = new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        };

        usuarios.forEach(mostrador); // estamos passando para o forEach() o mostrador

        //LAMBDAS
        // de forma simples um lambdas no java é uma forma simples de implementar uma interface
        //que tem apenas um unico metodo

        //estamos usando o nome da interface como tipo passando o usuario para uma variavel de nome mostrador2
        // na segunda parte do codigo estamos passando para a interface uma variavel de nome u do tipo Usuario
        //
        Consumer<Usuario> mostrador2 =  (Usuario u) -> {
            System.out.println(u.getNome());
        };
        usuarios.forEach(mostrador2);
        System.out.println("---");

        //USANDO MAIS LAMBDAS
        Consumer<Usuario> mostrador3 = u -> System.out.println(u.getNome());
        usuarios.forEach(mostrador3);

        //o forEach() sabe qu e o usuarios é do tipo Usuario e o u recebe esse tipo e no tipo tem o getNome()
        usuarios.forEach(u -> System.out.println(u.getNome()));
        System.out.println("--");

        // veja que interessante podemos chamar um metodo de cada objeto (Por isso  precisam ser do mesmo tipo)
        // objeto.loop(variavel -> variavel.metodo());

        //lembrando que a varivavel u nao pode existir antes desse loop senao o compilador pode usar a variavel errada
        usuarios.forEach(u -> u.tornaModerador());

    }
}
