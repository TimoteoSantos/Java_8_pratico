package br.com.casadocodigo.java8.capitulos.CapituloNono;

import java.time.*;
import java.util.Calendar;

public class Datas {

    public static void main(String[] args) {

        //pegando a data atual
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);

        LocalTime agora2 = LocalTime.now();
        System.out.println(agora2);

        //mesm dia no mes que vem
        LocalDate mesQueVem = LocalDate.now().plusMonths(1);
        System.out.println(mesQueVem);

        //pegando o ano passado
        LocalDate anoPassado = LocalDate.now().minusYears(1);
        System.out.println(anoPassado);

        LocalTime agora3 = LocalTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDateTime dataEhora = hoje.atTime(agora3);
        System.out.println(dataEhora);

        //atibuindo uma zona ao timezone
        ZonedDateTime dataComHoraETimezone =
        dataEhora.atZone(ZoneId.of("America/Sao_Paulo"));

        LocalDate date = LocalDate.of(2014, 12, 25);
        System.out.println(date);
    }

}
