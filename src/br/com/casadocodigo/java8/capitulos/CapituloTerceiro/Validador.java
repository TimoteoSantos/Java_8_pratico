package br.com.casadocodigo.java8.capitulos.CapituloTerceiro;

//aqui estou explicitamente dizendo que uma interface é uma interface funcional
@FunctionalInterface
public interface Validador<T> {
        boolean valida (T t);
}