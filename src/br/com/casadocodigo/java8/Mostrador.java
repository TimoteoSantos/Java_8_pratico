package br.com.casadocodigo.java8;
import br.com.casadocodigo.java8.usuarios.*;
import java.util.function.Consumer;

// estamos implementaddo a interface Coonsumer<T> que tem um unico metodo
//ou seja um default method reposvel por pegar um objeto do itpo
//Usuario e consumi-lo :)

public class Mostrador implements Consumer<Usuario>{

    //sobrescrevendo o metodo accept(TipoObjeto variavel)
    @Override
    public void accept(Usuario u){

        //escrever o nome do objeto passado
        System.out.println(u.getNome());
    }
}
