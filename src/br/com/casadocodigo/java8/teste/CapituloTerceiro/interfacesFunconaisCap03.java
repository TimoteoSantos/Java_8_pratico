package br.com.casadocodigo.java8.teste.CapituloTerceiro;

/*uma interface funcional é uma interface que contem apenas um metodo abstrato
porem ela pode ter outros metodos default mas so um e apenas um metodo abstrato
nao é nescessario deixar explicito que é um metodo abstrato pois os metodos
que nao sao dafault ja sao por sua natureza abstratos
nao é obrigatorio fazer a notação @FunctionalInterface mas é uma boa pratica
* */

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

        //USANDO UMA INTERFACE FUNCIONAL

        //passando para a mesma atraves do generics o tipo String

        //criando um objeto do tipo Validador<T> instanciando um Validador e fazendo a implentaçao do metodo validar porque
        //o Validador é uma interface

        //usando classe anonima
        Validador<String> validadorCEP = new Validador<String>() {
            @Override
            public boolean valida(String s) {
                return s.matches("[0-9]{5}-[0-9]{3}");
            }
        };
        System.out.println(validadorCEP.valida("04101-300"));

        //usando lambdas para interface funcional ou seja uma interface que tem apenas um metodo

        Validador<String> validarCER = valor -> valor.matches("[0-9]{5}-[0-9]{3}");

        //usando a interface Validador<T>
        //perceber que posso mudar o comportamento do validar da interface
        Validador<String> validar = s -> s.length() > 5;
        System.out.println(validar.valida("teste"));

        //o lambdas funciona atraves das interfaces funcionais sem interfaces funcionais nao podemos fazer lambdas
        Runnable o = () -> {
            System.out.println("O que sou ? Que lambdas ?");
        };
        System.out.println(o);
        System.out.println(o.getClass());
    }



}
