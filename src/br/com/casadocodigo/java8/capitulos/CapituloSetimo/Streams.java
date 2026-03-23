package br.com.casadocodigo.java8.capitulos.CapituloSetimo;

import br.com.casadocodigo.java8.usuarios.Usuario;
import javafx.scene.control.ListViewBuilder;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

            System.out.println(usuario.getNome() + "Assim acesso elementos da lista");

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

        //filtrar usuarios e trona-los moderadores

        /* 1. Criamos um Stream a partir da lista de usuarios
           2. Definimos um fitlro para selecionar com mais de 100 porntos
           3. A execulcao acontece na operacao terminal forEach()
           4. Para cada usuario filtrado, chamamos o metodo tornarModerador()
        * */
        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(Usuario::tornaModerador);

        //verificar se um usuario é um moderador

        //enviando apra a stream
        //o filtro é referente a um objeto ser um moderador ou seja true
        //se ele for true ele é filtrado
        usuarios.stream().filter(Usuario::isModerador);

        //estou criando uma lista
        List<Usuario> maisQue100 = new ArrayList<>();

        //adicionando os usuarios que tem mais que cem pontos nessa lista
        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(u -> maisQue100.add(u));

        //AGORA IREMOS USAR METHOS REFERENCES
        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(maisQue100::add);

        //OBTENDO UMA LISTA DE VOLTA
        // o forEach é void
        // o filter devolve um Stream
        //como poderia ter uma lista a partir da minha selecao

        //driando uma objeto do tipo Usuario que é uma lista ou seja uma nova lista do tipo usuario
        List<Usuario> maisQue100Pontos = new ArrayList<>();

        //olha que pulo do gato esto adicionando a uma lista os dados que sao do filtro de todos os usuarios
        //que tem mais do que 100 pontos sangue de cristo quanta informação

        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(u -> maisQue100Pontos.add(u));

        //usando method references
        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(maisQue100Pontos::add);

        //coletando o retono de um filter
        List<Usuario> listaComMaisQeuCem = usuarios.stream().filter(u -> u.getPontos() > 100 ).collect(Collectors.toList());

        //retornando um set<Usuario>
        Set<Usuario> setMaisQueCem = usuarios.stream().filter(u -> u.getPontos() > 100).collect(Collectors.toSet());

        // # assunto para estudar

        //metodo que permite que escohemos qual a colecao que sera devolvida
        //Set<Usuario> set = stream.collect(Collectors.toCollection(HashSet::new));

        //pegar apenas os pontos dos usuarios
        //podemos fazer da seguinte forma

        //criar uma lista e adicionar os pontos dos usuarios sera uma lista de pontos
        List<Integer> pontos = new ArrayList<>();
        usuarios.forEach(u -> pontos.add(u.getPontos()));
        pontos.forEach(u -> System.out.println(u));

        //USANDO O METODO MAP DO STREAM

        //nesse codigo abaixo estamos criando uma lista de pontos de todos os usuarios
        //perceber que estamos enviando numeros inteiros e recebendo Integer que é um objeto
        //o processamento do java para transformar de inteiro para Integer pode causar mais
        //processamento em grandes quantidades de registros ou de objetos

        List<Integer> pontosNovo = usuarios.stream().map(Usuario::getPontos).collect(Collectors.toList());
        //imprimindo o novo array criado com map
        pontosNovo.forEach(u -> System.out.println(u));

        //para  que nao seja nescessario fazer a conversao podemos usar o IntStream

        //criando uma variavel que recebe
        IntStream stream1 = usuarios.stream().mapToInt(Usuario::getPontos);

        //verificar a media de pontos dos usuarios

        //criar uma variavel temporaria
        double totalDePontos = 0;
        //percorrer os usuarios
        for (Usuario u : usuarios){
            //somar os pontos de cada usuario
            totalDePontos += u.getPontos();
        }

        double mediaDosPontos = totalDePontos / usuarios.size();
        System.out.println("A MEDIA DE PONTOS FOI DE: " + mediaDosPontos);

        //USANDO O STREAM PARA REALIZAR A MESMA OPERACAO
        double pontuacaoMedia =
                //lista de usuarios
                usuarios.
                        //aplicando a interface stream no Lis entra em um fluxo de trabalho do stream
                stream().
                        //extrair os pontos dos usuarios
                mapToInt(Usuario::getPontos).
                        //metodo do stream que calcula a media e retorna um objeto do tipo OptionalDouble
                average().
                        //agora estamos acessando o OptionalDouble e extraindo o valor como um double
                getAsDouble();

        //teremos o mesmo resultado porem usando uma melhor abordagem
        System.out.println("A PONTUACAO MEDIA FOI DE " + pontuacaoMedia);

        //no exemplo acima vimos como verificar a media atraves do metodo average() do stream que nasceu para
        //que quando uma lista for vazia nao tenhamos que fazer um if para verificar ele mesmo faz isso internamente

        //encontrando o usuario com maior ponto
        Optional<Usuario> max = usuarios.stream().max(Comparator.comparing(Usuario::getPontos));
        System.out.println("O usuario com maior ponto foi" + max + "Quem escreveu isso foi o toString de Usuarios");

        //estou criando uma variavel do 
        OptionalDouble media = usuarios.stream().mapToInt(Usuario::getPontos).average();
        double pontuacaoMediaNovo = media.orElse(5.5);
        System.out.println(pontuacaoMediaNovo);

        //relembrando como extrair os pontos de um usuario

        //fazendo isso com uma variavel de controle
        List<Integer> pontos2 = new  ArrayList<>();
        usuarios.forEach(u -> pontos2.add(u.getPontos()));


        //lancar uma exceçao ao fazer uma media caso ela seja vazia
        double pontuacaoMedia3 = usuarios.stream().mapToInt(Usuario::getPontos).average().orElseThrow(IllegalStateException::new);


        //verificar o usuario com maior quantidade de pontos e tratando se a lista for vazia

        // usando a interface optional para receber um usuario que nesse caso é o que tem o maior ponto
        //que foi definido no ComparingInt() e execultado pelo metodo max que recebe esse comparing
        //isso porque ele precisa comparar para saber quem tem o maior ponto

        //lembrando que nao o max2 nao é uma lista mas um objeto retornado ou seja o objeto com maior numeros de pontos
        //o Optional serve para que se uma lsita for vazia o programa nao gerar um erro
        Optional <Usuario> max2 = usuarios.stream().max(Comparator.comparingInt(Usuario::getPontos));
        System.out.println(max2 + "valor retornado do optional");

    }
}
