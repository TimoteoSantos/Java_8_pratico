package br.com.casadocodigo.java8.testes.CapituloSetimo;

import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class Streams {

    public static void main(String[] args) {

        //implementar uma interface funcional que recebe dois tipos e um objeto e retorna um objeto
        //lembrando que a implementacao vem do construtor de Usuario
        BiFunction<String, Integer, Usuario> criarSuarios = Usuario::new;
        //o metodo apply() execulta a instrucao
        Usuario user1 = criarSuarios.apply("timoteo", 500);

        //outra forma de criar um usuario
        Usuario user2 = new Usuario("Tiago", 159);
        Usuario user3 = new Usuario("janaina", 7);
        Usuario user4 = new Usuario("taiza", 9888);

        //adicionar usuarios a lista de usuarios
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4);

        //ordenado usuarios filtrando os usuarios com mais de 10 pontos e tornando-os moderadore

        /* Usa o método sort da List para ordenar a própria lista.
         * O Comparator é criado com comparing(), que compara os usuários
         * pelo valor retornado por getPontos().
         * Em seguida, reversed() inverte a ordem para decrescente.
         */
        usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
        //tonar moderador os usuarios com mais de 10 pontos
        usuarios.subList(0,4).forEach(Usuario::tornaModerador);

        /*correcao sugerida pela IA estudar
        usuarios.stream()
                .sorted(Comparator.comparing(Usuario::getPontos).reversed())
                .limit(10)
                .forEach(Usuario::tornaModerador);
        */


    }
}
