package br.com.casadocodigo.java8.capitulos.Revisao;

import br.com.casadocodigo.java8.InterfaceFuncional.InterfaceCalcular;

public class Revisao {

    public static void main(String[] args) {

        //interface funcional
        InterfaceCalcular calcular = (a, b) -> a + b;
        System.out.println(calcular.calcular(1,1));

        //INTERFACES FUNCIONAIS JAVA

        // Function -> transforma um valor em outro
        // Predicate -> testa uma condicao
        // Consumer -> executa uma ação
        // Supplier -> fornece um valor

        //METODOS DO STREAM

        /*
        filter() → filtrar

        map() → transformar

        sorted() → ordenar

        forEach() → executar algo

        collect() → gerar outra lista
         */

        /*Analogia da fábrica

        Lista → depósito

        Stream → esteira

        filter/map → funcionários mexendo nas peças

        collect → caixa final com resultado

        Interface funcional

        Lambda

        Method reference

        Stream

        Filter

        Map

        Reduce

        Collect

        Optional
        */

    }
}
