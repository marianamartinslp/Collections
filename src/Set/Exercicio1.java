package Set;

    /*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

import java.util.*;

public class Exercicio1 {

    public static void main(String[] args) {
        System.out.println("Crie um conjunto contendo as cores do arco-íris: ");
        Set<String> coresArcoIris = new HashSet<>();
        coresArcoIris.add("violeta");
        coresArcoIris.add("anil");
        coresArcoIris.add("azul");
        coresArcoIris.add("verde");
        coresArcoIris.add("amarelo");
        coresArcoIris.add("laranja");
        coresArcoIris.add("vermelho");
        System.out.println(coresArcoIris);

        System.out.println("\nExiba todas as cores do arco-íris uma abaixo da outra: ");
        for (String cor: coresArcoIris){
            System.out.println(cor);
        }

        System.out.println("\nA quantidade de cores que o arco-íris tem: " + coresArcoIris.size());

        System.out.println("\nExiba as cores em ordem alfabética: ");
        Set<String> coresArcoIris2 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIris2);

        System.out.println("\nExiba as cores na ordem inversa da que foi informada: ");
        Set<String> coresArcoIris3 = new LinkedHashSet<>(
                Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        System.out.println(coresArcoIris3);
        List<String> coresArcoIrisList = new ArrayList<>(coresArcoIris3);
        Collections.reverse(coresArcoIrisList);

        System.out.println("\nExiba todas as cores que começam com a letra 'V': ");
        for (String cor : coresArcoIris){
            if(cor.startsWith("v")) System.out.println(cor);
        }

        System.out.println("\nRemova todas as cores que não começam com a letra “v”: ");
        Iterator<String> iterator2 = coresArcoIris.iterator();
        while (iterator2.hasNext()) {
            if (!iterator2.next().startsWith("v")) iterator2.remove();
        }
        System.out.println(coresArcoIris);

        System.out.println("\nLimpe o conjunto: ");
        coresArcoIris.clear();



        System.out.println("\nConfira se o conjunto está vazio: " + coresArcoIris.isEmpty());



    }
}


