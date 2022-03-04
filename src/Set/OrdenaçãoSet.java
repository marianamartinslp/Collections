package Set;

/*Dadas as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de episódio);
Série 1 = Nome: greys anatomy, genero: drama, tempoEpisodio: 50
Série 2 = nome: riverdale, genero: drama, tempoEpisodio: 40
Série 3 = nome: htgawm, genero: suspende, tempoEpisodio: 40
*/

import java.util.*;

public class OrdenaçãoSet {
    public static void main(String[] args) {

        System.out.println("-- Ordem aleatória -- ");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("greys anatomy", "drama", 50));
            add(new Serie("riverdale", "drama", 40));
            add(new Serie("htgawm", "suspense", 40));

        }};

        for(Serie serie: minhasSeries) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEp());

        System.out.println(" -- Ordem Natural (TempoEpisodio)--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries);
        System.out.println(minhasSeries2);
        for(Serie serie: minhasSeries2) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEp());

        System.out.println("-- Ordem Nome/Genero/TempoEp --");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEp());

        minhasSeries3.addAll(minhasSeries);
        for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - "
        + serie.getGenero() + " - " + serie.getTempoEp());
        }

    }

class Serie implements Comparable <Serie> {


    private String nome;
    private String genero;
    private Integer tempoEp;

    public Serie(String nome, String genero, Integer tempoEp) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEp = tempoEp;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEp() {
        return tempoEp;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEp=" + tempoEp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEp.equals(serie.tempoEp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEp);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempEp = Integer.compare(this.getTempoEp(), serie.getTempoEp());
        if(tempoEp != 0) return tempEp;

        return this.getGenero().compareTo(serie.getGenero());
    }
}

class ComparatorNomeGeneroTempoEp implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEp(), s2.getTempoEp());
    }
}