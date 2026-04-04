package br.com.casadocodigo.java8.capitulos.CapituloSetimo;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Fibonacci  implements IntSupplier {

    private int anterior =0;
    private  int proximo =0;

    public int getAsInt(){
        proximo = proximo + anterior;
        anterior = proximo - anterior;
        return  anterior;
    }
}