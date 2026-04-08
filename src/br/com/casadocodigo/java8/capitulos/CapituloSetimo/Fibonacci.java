package br.com.casadocodigo.java8.capitulos.CapituloSetimo;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.function.IntSupplier;

// Classe que implementa IntSupplier (fornece números inteiros sob demanda)
public class Fibonacci implements IntSupplier {

    // Armazena o valor anterior da sequência
    private int anterior = 0;

    // Armazena o próximo valor da sequência
    private int proximo = 1;

    // Método obrigatório da interface IntSupplier
    // Cada chamada retorna o próximo número da sequência de Fibonacci
    @Override
    public int getAsInt() {

        // Guarda o valor atual que será retornado
        int resultado = anterior;

        // Calcula a soma dos dois últimos valores
        int soma = anterior + proximo;

        // Atualiza o anterior para o valor do próximo
        anterior = proximo;

        // Atualiza o próximo com a soma (avança na sequência)
        proximo = soma;

        // Retorna o valor atual da sequência
        return resultado;
    }
}