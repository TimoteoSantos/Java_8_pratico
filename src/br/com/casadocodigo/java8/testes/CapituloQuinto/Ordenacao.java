package br.com.casadocodigo.java8.testes.CapituloQuinto;

import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.*;
import java.util.function.Function;

public class Ordenacao {
    public static void main(String[] args) {

        //criando uma lista que aceita objetos do tipo Usuario
        List<Usuario> usuarios = new ArrayList<>();

        //criando os usuarios
        Usuario user1 = new Usuario("TIMOTEO", 89);
        Usuario user2 = new Usuario("RaMALHO", 250);
        Usuario user3 = new Usuario("Jaquinaldo", 300);
        Usuario user4 = new Usuario("AMARO",39);
        Usuario user5 = new Usuario("Zagildo", 10);

        //adicionando a lista
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
        usuarios.add(user4);
        usuarios.add(user5);

        //listar os usuarios
        //observe a {} no forEach isso serve para criar um bloco semelhante um for
        usuarios.forEach(usuario-> {
            //System.out.println(usuario.getNome());
            //System.out.println(usuario.getPontos());
        });

        //ORDENAR COM JAVA 8

        //5.1 Comparators como lambdas
        // se uma classe implementa o Comparable podemos passar uma lista de instancias dessa classe
        // para  o Collections.sort

        //criamos uma variavel comparator do tipo Comparator<Usuario>
        //Comparator é uma interface funcional que define como dois objetos serao comparados
        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            //aqui de fato estamos dizendo para o Comparator quais os atributos ou como os objetos serao comparados
            //nesse expemplo os objetos serao comparados pelo nome
            @Override
            public int compare(Usuario u1, Usuario u2){
                // retorno da comparação
                return u1.getNome().compareTo(u2.getNome());
            }
        };

        //execultando o metodo sort
       Collections.sort(usuarios, comparator);
       //perceba que a ordem dos dados da lista mudou agora segem a ordem dos nomes
       usuarios.forEach(u -> System.out.println(u.getNome()));

       //usando lambdas, entender que o fato de criar o lambdas é como se estivessemos implementando o metodo nao o invocando
        Comparator<Usuario> comparator1 = (u1 , u2) -> u1.getNome().compareTo(u2.getNome());
        // a coleção sort recebe uma lista e uma implementacao de como ordenar
        Collections.sort(usuarios, comparator1);

        //fazendo tudo com lambdas em uma unica linha

        Collections.sort(usuarios, (u1 , u2)-> u1.getNome().compareTo(u2.getNome()));
        usuarios.forEach(u -> System.out.println(u.getNome()));

        //METODO LIST.SORT
        //usando metodo List.Sort()
        usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
        usuarios.forEach(u-> System.out.println(u.getNome()));

        // METODOS ESTATICOS
        //implementado o metodo da interface Comarator<T> comparing(U , String)
        Comparator<Usuario> comparator2 = Comparator.comparing(u -> u.getNome());
        //enviar para o metodo da lista .sort() a variavel comparator2 que contem um objeto que sabe logica defina para fazer a comparacao
        usuarios.sort(comparator2); //aqui ele modifica a lista

        //naturalOrder()
        List<String> palavras = Arrays.asList("Casa do Código", "Alura", "Caelum");

        palavras.sort(Comparator.naturalOrder());

        //forma concreta
        for (String palavra : palavras){
            System.out.println(palavra);
        }
        //forma lambdas
        palavras.forEach(palavra -> System.out.println(palavra));

        //uma funcao que rebe um objto e retorna seus pontos
        Function<Usuario, Integer> extrairPontos = u -> u.getPontos();

        //função que compara os usuarios a partir dos pontos recebidos

        Comparator<Usuario> comparator3 = Comparator.comparing(extrairPontos);

        //usa o Coparetor para decidir como ordenar a lista
        usuarios.sort(comparator3);

        /*
        Function

        ️ Comparator Define como obter um valor (Integer) a partir de um Usuario
        Define como comparar dois Usuario usando esse valor

        ️ sort
        Executa o algoritmo de ordenação e reorganiza a lista
        */

        //lambdas
        usuarios.sort(Comparator.comparing(u -> u.getPontos()));

    }
}