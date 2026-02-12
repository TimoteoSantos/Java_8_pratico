package br.com.casadocodigo.java8;

@FunctionalInterface //aqui estou explicitamente dizendo que uma interface é uma interface funcional
public interface Validador<T> {
        boolean valida (T t);
}