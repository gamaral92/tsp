package caixeiroviajante.genetico;

/**
 *
 * @author gabrielamaral
 */
public final class Populacao {

    private final Individuo[] individuos;

    public Populacao(int tamanhoPopulacao, boolean iniciar, Caminho caminho) {
        individuos = new Individuo[tamanhoPopulacao];
        if (iniciar) {
            for (int i = 0; i < tamanhoPopulacao; i++) {
                Individuo novoIndividuo = new Individuo(caminho);
                novoIndividuo.gerarIndividuo(caminho);
                salvarIndividuo(i, novoIndividuo);
            }
        }
    }

    public void salvarIndividuo(int indice, Individuo individuo) {
        individuos[indice] = individuo;
    }

    public Individuo getIndividuo(int indice) {
        return individuos[indice];
    }

    public Individuo getIndividuoMaisApto() {
        Individuo maisApto = individuos[0];
        for (int i = 1; i < tamanhoPopulacao(); i++) {
            if (maisApto.getFitness() <= getIndividuo(i).getFitness()) {
                maisApto = getIndividuo(i);
            }
        }
        return maisApto;
    }

    public int tamanhoPopulacao() {
        return individuos.length;
    }

}
