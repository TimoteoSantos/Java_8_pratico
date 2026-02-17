package br.com.casadocodigo.java8.testes.CapituloTerceiro;

@FunctionalInterface //aqui estou explicitamente dizendo que uma interface é uma interface funcional
public interface Validador<T> {
        boolean valida (T t);
}