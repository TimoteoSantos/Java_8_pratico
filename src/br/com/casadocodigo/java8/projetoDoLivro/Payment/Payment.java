package br.com.casadocodigo.java8.projetoDoLivro.Payment;

import br.com.casadocodigo.java8.projetoDoLivro.Customer.Customer;
import br.com.casadocodigo.java8.projetoDoLivro.Product.Product;

import java.beans.Customizer;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Payment {

    //uma lista de produtos
    private List<Product> products;
    //data
    private LocalDateTime date;
    //cliente
    private Customer customer;

    public Payment(List<Product> products,
                   LocalDateTime date,
                   Customer customer){

        //esse metodo cria uma lista que nao pode ser modificada
        this.products = Collections.unmodifiableList(products);
        this.date = date;
        this.customer = customer;
    }

    //retorna uma lista de produtos
    public List<Product> getProducts(){
        return this.products;
    }

    public LocalDateTime getDate(){
        
    }
}
