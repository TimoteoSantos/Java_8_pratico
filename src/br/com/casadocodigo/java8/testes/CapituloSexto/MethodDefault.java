package br.com.casadocodigo.java8.testes.CapituloSexto;

import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.ArrayList;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodDefault {
    public static void main(String[] args) {

        //usando o metodo default
        List<Usuario> usuarios = new ArrayList<>();

        //criando usuarios distintos
        Usuario user = new Usuario("Timoteo", 129);
        Usuario user1 = new Usuario("Taiza", 148);
        Usuario user2 = new Usuario("Luiza", 2000);

        //adicionar esses usuarios a uma lista
        usuarios.add(user);
        usuarios.add(user1);
        usuarios.add(user2);

        //litar o atributo moderador antesde aplicar o metodo que torna um usuario moderador
        usuarios.forEach(u -> System.out.println(u.getModerador()));

        /* percorrer todos os usuarios com foreach
        depois chamar o metodo tornarModerador
        esse metodo define que se passar um usuario ele se torna moderador
        */

        //os dois codigos fazem a mesma coisa mas o ultimo usa methodo default com lambdas
        usuarios.forEach(u -> u.tornaModerador());
        usuarios.forEach(Usuario::tornaModerador);

        //listar o valor do atributo moderador de todos os usuarios
        usuarios.forEach(u -> System.out.println(u.getModerador()));

        //method references no sort
        //usando o metodo comparing do Comparator para fazer a ordenacao pelo nome
        //atraves do metodo references
        usuarios.sort(Comparator.comparing(Usuario::getNome));

        //implementado
        //extrair o nome do usuario
        Function<Usuario,String> byName = Usuario::getNome;

        //criar um Compareto que tem como base o nome extraido
        //fazer a ordenação com sort
        usuarios.sort(Comparator.comparing(byName));

        //ordenar pelo ponto
        usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));

        //chamando um metodo com lambdas atraves do forEach
        usuarios.forEach(u -> u.escreverUsuario());
        //acessando o metodo usando methods references
        usuarios.forEach(Usuario::escreverUsuario);

        //FAZENDO COMPARAÇOES COM METHODS REFERENCES
        usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));

        //REFERENCIANDO METODO DE INSTANCIAS
        Usuario rodrigo = new Usuario("Rodrigo Turini", 120);

        //usando o lambdas
        Runnable bloco2 = () -> rodrigo.tornaModerador();
        //fazendo a mesma coisa mas com metodos de instancia
        Runnable bloco = rodrigo::tornaModerador;
        bloco.run();

        //tonando o objeto user um moderador
        Runnable teste = user::tornaModerador;

        //é como se eu tivesse implementado um metodo que escreve esse print mas fiz sem nenhuma classe eureca
        Runnable soma = () -> System.out.println(3+3);
        soma.run();

        //a variavel mensagem recebe uma funçao que foi implementada de acordo com a especificação da interface Runnable
        //que é uma interface que nao rece nada nem retorna nada
        Runnable mensagem = () -> System.out.println("sou filho orfao");
        //usando o metodo run() da interface Runnable que esta contido no bojeto mensagem
        mensagem.run();

        //a cada loop teremos um objeto do tipo Usuario as duas implementaçoes a seguir sao equivalentes
        usuarios.forEach(u -> System.out.println(u.getNome()));
        usuarios.forEach(System.out::println);

        //referenciando construtores
        Supplier<Usuario> criaDorDeUsuario =  Usuario::new;
        Usuario novo = criaDorDeUsuario.get();

        //usando a interface Function porque ela pode receber uma entrada e eu irei usar uma string como entrda
        //aqui vc pode escloher que tipo entra
        Function<String,Usuario> criarUsuarios = Usuario::new;
        //agora iremos passar dados para o construtor do Usuario
        Usuario rodrigo2 = criarUsuarios.apply("TIMOTEO");
        Usuario pauloSilveira = criarUsuarios.apply("Paulo Silveira");

        //criar um usuario com dois parametros
        BiFunction<String, Integer, Usuario> criarUsuarioDoisParametros = Usuario::new;
        Usuario novo2 = criarUsuarioDoisParametros.apply("timoteo santos", 220);
        Usuario novo3 = criarUsuarioDoisParametros.apply("tiago jose ", 399);

    }
}
