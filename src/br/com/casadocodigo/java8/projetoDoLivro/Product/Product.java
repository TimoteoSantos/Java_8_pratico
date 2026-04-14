package br.com.casadocodigo.java8.projetoDoLivro.Product;

import java.math.BigDecimal;
import java.nio.file.Path;

public class Product {

    private String name;
    private Path file;
    private BigDecimal price;

    //metodo construtor
    public Product(String nome, Path file, BigDecimal price){
        this.name = nome;
        this.file = file;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }
    public Path getFile(){
        return this.file;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public String toString(){
        return this.name;
    }

}
