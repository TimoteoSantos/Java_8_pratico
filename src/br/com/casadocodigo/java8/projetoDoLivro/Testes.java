package br.com.casadocodigo.java8.projetoDoLivro;

import br.com.casadocodigo.java8.projetoDoLivro.Customer.Customer;
import br.com.casadocodigo.java8.projetoDoLivro.Payment.Payment;
import br.com.casadocodigo.java8.projetoDoLivro.Product.Product;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static java.util.Arrays.asList;

public class Testes {

    public static void main(String[] args){

        //criando novos usuarios
        Customer paulo = new Customer("Paulo Silveira");
        Customer rodrigo = new Customer("Rodrigo Turini");
        Customer guilherme = new Customer("Guilerme");
        Customer adriano = new Customer("Adriano Almeida");

        //criando novos produtos
        //observar que ao passar o paramentro estamos instanciando os objetos
        //ou seja em tempo de execulçao
        Product bach = new Product("Bach Completo",
                Paths.get("/music/bach.mp3"), new BigDecimal(100));
        Product poderosas = new Product("Poderosas Anita",
                Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
        Product bandeira = new Product("Bandeira Brasil",
                Paths.get("/images/brasil.jpg"), new BigDecimal(50));
        Product beauty = new Product("Beleza Americana",
                Paths.get("beauty.mov"), new BigDecimal(150));
        Product vingadores = new Product("Os Vingadores",
                Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
        Product amelie = new Product("Amelie Poulain",
                Paths.get("/movies/amelie.mov"), new BigDecimal(100));

        //criando alguns pagamentos

        //pegando a data atual
        LocalDateTime today = LocalDateTime.now();
        // a data do dia anterior
        LocalDateTime yesterday = today.minusDays(1);
        // o mes anterior
        LocalDateTime lastMonth = today.minusMonths(1);

        //criando os pagamentos
        //prestar atenção nos parametros enviados o primeito é um paramtro que é uma lista
        //por isso estamos enviando uma lista
        Payment payment = new Payment(asList(bach, poderosas), today, paulo);

    }
}
