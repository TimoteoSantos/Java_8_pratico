package br.com.casadocodigo.java8.projetoDoLivro;

import br.com.casadocodigo.java8.projetoDoLivro.Customer.Customer;
import br.com.casadocodigo.java8.projetoDoLivro.Payment.Payment;
import br.com.casadocodigo.java8.projetoDoLivro.Product.Product;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Testes {

    public static void main(String[] args){

        //criando novos usuarios
        Customer paulo = new Customer("Paulo Silveira");
        Customer rodrigo = new Customer("Rodrigo Turini");
        Customer guilherme = new Customer("Guilerme");
        Customer adriano = new Customer("Adriano Almeida");

        //criando novos produtos
        //observar que ao passar o paramentro estamos instanciando os objetos que sao o
        //nome do produto onde esta o arquivo e o preco
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

        //observar o construtor que pede uma lista com  os produtos, a data atual e o consumidor
        Payment payment1 =
                new Payment(asList(bach, poderosas), today, paulo);
        Payment payment2 =
        new Payment(asList(bach, bandeira, amelie), yesterday, rodrigo);
        Payment payment3 =
                new Payment(asList(beauty, vingadores, bach), today, adriano);
        Payment payment4 =
                new Payment(asList(bach, poderosas, amelie), lastMonth, guilherme);
        Payment payment5 =
                new Payment(asList(beauty, amelie), yesterday, paulo);

        //criando uma lista com os pagamentos
        List<Payment> payments = asList(payment1, payment2,
                payment3, payment4, payment5);

        //ORDENAR
        payments.stream() //estou entrarndo em um fluxo do stream
                .sorted(Comparator.comparing(Payment::getDate)). //operacao lazy ou seja nao execulta nada ela é chamada intermediaria
                forEach(System.out::println);// uma operacao terminal ela execulta

        //CALCULANDO O VALOR TOTAL DO PAGAMENTO pyment1 o BigDecimal nao tem um metodo que faz a soma
        //teremos que criar esse metodo usando o lambdas

        payment1.getProducts().stream()//enviando os dados do metodo getPducts que retorna uma lista de produtos
                .map(Product::getPrice)// extrair o preco ultilizando o metodo getPrice
                .reduce(BigDecimal::add)//esse metodo faz a soma dos valores enviados para ele
                .ifPresent(System.out::println);//se existir daddos a serem impressos iprime

        //somando os valores de todos os pagamentos
        // Stream que vai conter o total (BigDecimal) de cada pagamento
        Stream<BigDecimal> pricesStream =
                // Converte a lista de pagamentos em um Stream<Payment>
                payments.stream()
                        // Para cada pagamento (p), vamos transformar ele em um BigDecimal (total)
                        .map(p ->
                                // Pega os produtos desse pagamento e transforma em Stream<Product>
                                p.getProducts().stream()
                                        // Converte cada produto no seu preço → Stream<BigDecimal>
                                        .map(Product::getPrice)
                                        // Soma todos os preços dos produtos desse pagamento
                                        // Começa com ZERO e vai acumulando com add
                                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        );

        BigDecimal total =
                payments.stream()
                        .map(p-> p.getProducts().stream()
                                .map(Product::getPrice)
                                .reduce(BigDecimal.ZERO, BigDecimal::add))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);


        Stream<BigDecimal> priceOfEachProduct =
                payments.stream()
                        .flatMap(p-> p.getProducts().stream().map(Product::getPrice));


        Function<Payment, Stream<BigDecimal>> mapper =
                p-> p.getProducts().stream().map(Product::getPrice);


        BigDecimal totalFlat =
                payments.stream()
                        .flatMap(p-> p.getProducts().stream().map(Product::getPrice))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);


        Stream<Product> products = payments.stream()
                .map(Payment::getProducts)
                .flatMap(p-> p.stream());

        Stream<Product> products2 = payments.stream()
                .map(Payment::getProducts)
                .flatMap(List::stream);

        Stream<Product> products3 = payments.stream()
                .flatMap(p-> p.getProducts().stream());


        Map<Product, Long> topProducts = payments.stream()
                .flatMap(p-> p.getProducts().stream())
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        System.out.println(topProducts);


        topProducts.entrySet().stream()
                .forEach(System.out::println);


        topProducts.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);


        Map<Product, BigDecimal> totalValuePerProduct = payments.stream()
                .flatMap(p-> p.getProducts().stream())
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(BigDecimal.ZERO, Product::getPrice,
                                BigDecimal::add)));

        totalValuePerProduct.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(System.out::println);


        Map<Customer, List<Payment>> customerToPayments =
                payments.stream()
                        .collect(Collectors.groupingBy(Payment::getCustomer));



        Map<Customer, List<List<Product>>> customerToProductsList =
                payments.stream()
                        .collect(Collectors.groupingBy(Payment::getCustomer,
                                Collectors.mapping(Payment::getProducts, Collectors.toList())));
        customerToProductsList.entrySet().stream()
                .sorted(Comparator.comparing(e-> e.getKey().getName()))
                .forEach(System.out::println);

        Map<Customer, List<Product>> customerToProducts2steps =
                customerToProductsList.entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey,
                                e-> e.getValue().stream()
                                        .flatMap(List::stream)
                                        .collect(Collectors.toList())));

        customerToProducts2steps.entrySet().stream()
                .sorted(Comparator.comparing(e-> e.getKey().getName()))
                .forEach(System.out::println);


        Map<Customer, List<Product>> customerToProducts1step = payments.stream()
                .collect(Collectors.groupingBy(Payment::getCustomer,
                        Collectors.mapping(Payment::getProducts, Collectors.toList())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e-> e.getValue().stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList())));



        Map<Customer, BigDecimal> totalValuePerCustomer = payments.stream()
                .collect(Collectors.groupingBy(Payment::getCustomer,
                        Collectors.reducing(BigDecimal.ZERO,
                                p-> p.getProducts().stream().map(Product::getPrice).reduce(
                                        BigDecimal.ZERO, BigDecimal::add),
                                BigDecimal::add)));


        Function<Payment, BigDecimal> paymentToTotal =
                p-> p.getProducts().stream().map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);


        Map<Customer, BigDecimal> totalValuePerCustomers = payments.stream()
                .collect(Collectors.groupingBy(Payment::getCustomer,
                        Collectors.reducing(BigDecimal.ZERO,
                                paymentToTotal,
                                BigDecimal::add)));

        totalValuePerCustomer.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(System.out::println);


    }
}
