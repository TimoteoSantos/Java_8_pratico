package br.com.casadocodigo.java8.capitulos.CapituloNono;

import br.com.casadocodigo.java8.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Paralelo {
    public static void main(String[] args) {

        //criar os objetos
        Usuario user1 = new Usuario("timoteo", 10);
        Usuario user2 = new Usuario("taiza" , 300);
        Usuario user3 = new Usuario("tiago", 800);

        //criando uma lista que recebera os usuarios
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        //criando uma lista com os usuarios que
        // tem mais de 100 pontos porque o steam nao altera
        //a lista de usuarios

        //execultando sem paralismo

        List<Usuario> filtradosOrdenados = usuarios.stream(). //entrando no fluxo stream
                                                    filter(u -> u.getPontos() > 100).//filtrando os dados operacao intermediaria
                                                    sorted(Comparator.comparing(Usuario::getNome)).//ordenando os dados operacao intermediaria
                                                    collect(Collectors.toList());//coletando os dados para a variavel operacao terminal

        //escrevendo a lista
        filtradosOrdenados.stream().forEach(u -> System.out.println(u));

        //usando paralelismo
        List<Usuario> filtradosOrdenados2 = usuarios.parallelStream().
                                            filter(u -> u.getPontos() > 100).
                                            sorted(Comparator.comparing(Usuario::getPontos)).
                                            collect(Collectors.toList());
        filtradosOrdenados2.stream().forEach(u -> System.out.println(u));



    }
}
