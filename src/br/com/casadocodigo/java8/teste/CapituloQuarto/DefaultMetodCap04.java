package br.com.casadocodigo.java8.teste.CapituloQuarto;

import br.com.casadocodigo.java8.teste.CapituloTerceiro.Validador;
import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DefaultMetodCap04 {

    //DEFAULT METHODS
    //sao metodo que sao implementados diretamente na classe
    //isso significa que nao é nesscessario fazer a implementação do metodo

    public static void main(String[] argumentos){

        //criando os objetos
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario ("Rodrigo Turini" , 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        //criando uma variavel do tipo List que recebe um generics do tipo List <T> recebendo um Usuario
        // que tem o nome de usuarios que recebe a instancia de um HashSet() -> nao premite valores duplicados ou sena
        //nao pode haver usuarios dupblicados
        //observar que o ArryList tambem tem um genrics mas que é omitido porque ele entende que
        //sera ultilizado o que foi passado para o List<Usuario> ou seja um Usuario

        List<Usuario> usuarios = new ArrayList<>();
        //usando o metodo .add() do ArrayList()
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        //forma sem lambdas
        for (Usuario u : usuarios){
            System.out.println(u.getNome());
        }
        //com lambdas
        usuarios.forEach(u -> System.out.println(u.getNome()));

        /*criando uma variavel do tipo consumer<T> passando um usuario por generics
        depois estou criando um lambdas que mostra o nome de um usuario
        esse metodo retorna o nome de um usuario
        */

        //poredmos criar varias variaveis com implementacoes de interface lambdas e depois chama-las
        Consumer<Usuario> mostrarMensagem = (u -> System.out.println("Estou aparecendo antes de imprimir o nome do usuario"));
        Consumer<Usuario> imprimirNome = (u -> System.out.println(u.getNome()));

        Scanner sc = new Scanner(System.in);
        System.out.println("digite seu RG");

        user1.setRg(sc.next());

        //validar a idade se uma pessoa escreveu sua identidade com 8 digitos
        Validador<Usuario> validarRG = (u-> u.getRg().length() > 8);

        //chamando as variaveis que contem as implementacoes dos dos metodos que cumprem o contrato de sua interface
        usuarios.forEach(mostrarMensagem.andThen(imprimirNome));

        //removeIf

        /*
        a interface Predicato permite testar objetos do tipo Predicate<Objeto>();
        o metodo removeIf() do predicato permite remover objetos que atendam a condicao de criação do
        Predicate
        */
        Predicate<Usuario> predicado = new Predicate<Usuario>() {
            public boolean test(Usuario u){
                return  u.getPontos() > 160;
             }
        };

        /*perceba que o removeIf() esta vindo do ArrayList do tipo Usuario() estou passando para ele
        o objeto predicado que é um objeto do tipo Predicate
        */

        //forma sem o lambdas
        usuarios.removeIf(predicado);
        usuarios.forEach(u -> System.out.println(u.getNome()));

        //com lambdas


        //


    }

}
