package br.com.casadocodigo.java8.capitulos.CapituloOitavo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClasseFiles {

    public static void main(String[] args) throws IOException {

        Files.list(Paths.get("./br/com/casadocodigo/java8"))
                .forEach(System.out::println);
    }
}



/*assunto sera abordado em outro momento com mais profundidade*/
