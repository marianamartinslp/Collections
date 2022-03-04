package List;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<Double>();

        int count = 0;
        while (true) {
            if (count == 6) break;

            System.out.println("Digite a temperatura: ");
            double temp = scan.nextDouble();
            temperaturas.add(temp);
            count++;
        }

        System.out.println("-------------");

        //exibindo as temperaturas:
        System.out.println("Todas as temperaturas: ");
        temperaturas.forEach(t -> System.out.print(t + " "));

        //calculando e exibindo a média das temperaturas:
        double media = temperaturas.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0d);
        System.out.printf("\nMédia das temperaturas: %.1f", media);

        //exibindo as temperaturas acima da média
        System.out.println("\nTemperaturas acima da média: ");
        temperaturas.stream()
                .filter(t -> t > media)
                .forEach(t -> System.out.printf("%.1f ", t));

        //exibindo o mês das temperaturas acima da média por extenso:
        System.out.println("\nMeses das temperaturas acima da média: ");
        Iterator<Double> iterator = temperaturas.iterator();

        count = 0;
        while (iterator.hasNext()) {
            Double temp = iterator.next();
            if(temp > media) {
                switch (count) {
                    case (0):
                        System.out.printf("1 - Janeiro: %.1f ", temp);
                        break;
                        case (1):
                            System.out.printf("2 - fevereiro: %.1f\n", temp);
                            break;
                        case (2):
                            System.out.printf("3 - março: %.1f\n", temp);
                            break;
                        case (3):
                            System.out.printf("4 - abril: %.1f\n", temp);
                            break;
                        case (4):
                            System.out.printf("5 - maio: %.1f\n", temp);
                            break;
                        case (5):
                            System.out.printf("6 - junho: %.1f\n", temp);
                            break;
                        default:
                            System.out.println("Não houve temperatura acima da média.");
                    }
                }

                count++;
            }

        }
    }
/*
public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> temperaturaSemestral = new ArrayList<Double>();

        double soma = 0.0;
        for (int i = 1; i <= 6; i++) {
            System.out.println("Qual a temperatura do mês " + i + ": ");
            double temp = scan.nextDouble();
            temperaturaSemestral.add(temp);
            soma += temp;
        }

        double mediaTemperaturaSemestral = soma/temperaturaSemestral.size();

        System.out.println("Temperaturas Semestral: " + temperaturaSemestral);
        System.out.println("Média temperaturas Semestral: " + mediaTemperaturaSemestral + "oC");
        System.out.println("---------");

        for (Double temp : temperaturaSemestral) {
            if (temp > mediaTemperaturaSemestral) {
                int index = temperaturaSemestral.indexOf(temp);
                switch (index) {
                    case 0:
                        System.out.println((index + 1) + " - Janeiro: " + temp + "oC");
                        break;
                    case 1:
                        System.out.println((index + 1) + " - Fevereiro: " + temp + "oC");
                        break;
                    case 2:
                        System.out.println((index + 1) + " - Março: " + temp + "oC");
                        break;
                    case 3:
                        System.out.println((index + 1) + " - Abril: " + temp + "oC");
                        break;
                    case 4:
                        System.out.println((index + 1) + "Maio: " + temp + "oC");
                        break;
                    case 5:
                        System.out.println((index + 1) + "Junho: " + temp + "oC");
                        break;
                    default:
                        break;

                }
            }
        }
    }



}
*/