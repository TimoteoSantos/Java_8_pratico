package br.com.casadocodigo.java8.testes.CapituloSetimo;

import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

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

        //percorrerr uma lista com um for chamando o metodo que torna um usuario um moderador
        for(Usuario usuario: usuarios){
            //se um usuario tiver mais que 100 pontos
            if (usuario.getPontos() > 100){
                //metodo que torna um usuario um moderador
                usuario.tornaModerador();
            }
        }

        //UTILIZANDO STREAMS

        //estudar esse return na expressao lambdas
        Stream<Usuario> stream = usuarios.stream();
        stream.filter(u -> {return u.getPontos() > 100; });

        //removendo o return
        //stream.filter(u -> u.getPontos() > 100);

        //sem ultilizar a variavel temporaria stream diretamente na lista
        usuarios.stream().filter(u -> u.getPontos() > 100);

        //Stream nao  altera a lista ele cria uma nova lista
        Stream<Usuario> stream2 = usuarios.stream().filter(u -> u.getPontos() > 100);
        stream2.forEach(System.out::println);
        usuarios.forEach(System.out::println);

        //podemos encadear as operações do stream

        // a Stream foi pensada para ser execultada uma unica vez como por exemplo
        //verificar um cpf se precisar em outra parte ou outro momento tera que fazer novamente
        //porque ela nao guarda as informações é uma operação solitaria
        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(System.out::println);

        //pegando o retorno de um Stream

        //estou criando uma lista
        List<Usuario> maisQue100 = new ArrayList<>();

        //adicionando os usuarios que tem mais que cem pontos nessa lista
        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(u -> maisQue100.add(u));

        //AGORA IREMOS USAR METHOS REFERENCES
        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(maisQue100::add);


    }
}
